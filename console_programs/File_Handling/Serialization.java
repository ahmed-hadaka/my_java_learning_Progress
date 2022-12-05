package filesAndstreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
	public static void main(String[] args) {
		GameCharacter one = new GameCharacter(1, "Elf1", new String[] { "bla1", "bla2", "bla3" });
		GameCharacter two = new GameCharacter(2, "Elf2", new String[] { "blala1", "blala2", "blala3" });
		GameCharacter three = new GameCharacter(3, "Elf3", new String[] { "b1", "b2", "b3" });

		Serialize(one, two, three);
		List<GameCharacter> gameCharacters = new ArrayList<>();
		try {
			gameCharacters = deSerialize(one, two, three);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (GameCharacter gameCharacter : gameCharacters) {
			System.out.println(gameCharacter.toString());
		}
	}

	private static void Serialize(GameCharacter one, GameCharacter two, GameCharacter three) {
		try {
			ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("BinaryObjects.txt"));
			ous.writeObject(one);
			ous.writeObject(two);
			ous.writeObject(three);
			ous.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<GameCharacter> deSerialize(GameCharacter one, GameCharacter two, GameCharacter three)
			throws ClassNotFoundException {
		List<GameCharacter> gameCharacters = new ArrayList<>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BinaryObjects.txt"));
			gameCharacters.add((GameCharacter) ois.readObject());
			gameCharacters.add((GameCharacter) ois.readObject());
			gameCharacters.add((GameCharacter) ois.readObject());
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gameCharacters;
	}
}

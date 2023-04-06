package filesAndstreams;

import java.io.Serializable;
import java.util.Arrays;

public class GameCharacter implements Serializable {
	int power;
	String type;
	String[] weapons;

	public GameCharacter(int p, String t, String[] w) {
		this.power = p;
		this.type = t;
		this.weapons = w;
	}

	public int getPower() {
		return power;
	}

	public String getType() {
		return type;
	}

	public String getWeapons() {
		String weaponList = "";
		for (int i = 0; i < weapons.length; i++) {
			weaponList += weapons[i] + " ";
		}
		return weaponList;
	}

	@Override
	public String toString() {
		return "GameCharacter [power=" + power + ", type=" + type + ", weapons=" + Arrays.toString(weapons) + "]";
	}
}

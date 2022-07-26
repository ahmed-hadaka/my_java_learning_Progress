package projects;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Library_SystemApp {
	public static void main(String[] args) {
		new Library_System().go();
	}
}

class Library_System {
	Scanner sc = new Scanner(System.in);
	// ------------------------
	final int MAX_USERS = 10;
	final int MAX_BOOKS = 10;
	Users[] users;
	Books[] books;
	int booksLength, usersLength;

	public Library_System() {
		users = new Users[MAX_USERS];
		books = new Books[MAX_BOOKS];
		for (int i = 0; i < MAX_BOOKS; i++) {
			users[i] = new Users();
			books[i] = new Books();
		}
		booksLength = 0;
		usersLength = 0;
	}

	// go
	void go() {
		int choice;
		menu();
		while (true) {
			System.out.println("Enter Your menue choice [1 - 10]: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter book info: id & name & total quantity:");
				int id = sc.nextInt();
				String name = sc.next();
				int quantity = sc.nextInt();
				add_book(name, id, quantity);
				break;
			}
			case 2: {
				String prefix;
				System.out.println("Enter Book name prefix:");
				prefix = sc.next();
				getBook_by_prefix(prefix);
				break;
			}
			case 3: {
				String bookName;
				System.out.println("Enter Book name:");
				bookName = sc.next();
				print_who_borrowe_me(bookName);
				break;
			}
			case 4: {
				print_library_by_id();
				break;
			}
			case 5: {
				print_library_by_names();
				break;
			}
			case 6: {
				System.out.println("Enter user name & id:");
				String name = sc.next();
				int id = sc.nextInt();
				add_user(name, id);
				break;
			}
			case 7: {
				String userName, bookName;
				System.out.println("Enter user name and book name:");
				userName = sc.next();
				bookName = sc.next();
				if (is_admin(userName)) { // check if he is admin
					int bookId = get_book_id_decrease(bookName, userName);
					borrow_book_handler(userName, bookName, bookId);
					update_book_data(userName, bookName);
				} else {
					System.out.println("please be admin first by selecte add user choice.");
				}
				break;
			}
			case 8: {
				System.out.println("Enter user name and book name:");
				String userName = sc.next();
				String bookName = sc.next();
				return_book_handler(bookName, userName);
				break;
			}
			case 9: {
				print_users();
				break;
			}
			case 10: {
				return;
			}
			default:
				System.out.println("Invalid choice, try again.");
			}
		}
	}

	// Menu
	void menu() {
		System.out.println("Library Menu");
		System.out.println("1) add book");
		System.out.println("2) search book by prefix");
		System.out.println("3) print who borrowed book by name");
		System.out.println("4) print library by id");
		System.out.println("5) print library by name");
		System.out.println("6) add user");
		System.out.println("7) user borrow book");
		System.out.println("8) user return book");
		System.out.println("9) print users");
		System.out.println("10) Exit");

	}

	boolean is_admin(String userName) {
		for (int i = 0; i < MAX_USERS; i++) {
			if (users[i].name.equals(userName))
				return true;
		}
		return false;
	}

	void add_book(String name, int id, int quantity) {
		if (booksLength < MAX_BOOKS) {
			books[booksLength++] = new Books(name, id, quantity);
		} else
			System.out.println("We can't add more books!");
	}

	void add_user(String name, int id) {
		if (usersLength < MAX_USERS) {
			users[usersLength++] = new Users(name, id);
		} else
			System.out.println("We can't add more users to the system!");
	}

	void getBook_by_prefix(String prefix) {
		boolean is_available = false;
		for (int i = 0; i < booksLength; i++) {
			if (books[i].isMatch(prefix)) {
				is_available = true;
				System.out.println(books[i].name);
			}
		}
		if (!is_available)
			System.out.println("No books with such prefix!");
	}

//---- borrow ----------------------------
	void borrow_book_handler(String userName, String bookName, int bookId) {
		int index = getUser_index(userName);
		users[index].borrow_book(bookId); // update book in user borrowed books list
	}

	int get_book_id_decrease(String bookName, String userName) {
		int index = getBook_index(bookName);
//		books[index].add_to_borrow_me(userName); 
		return books[index].id;
	}

	void update_book_data(String userName, String bookName) {// update data at book object
		int index = getBook_index(bookName);
		books[index].add_to_borrow_me(userName);
	}

	void print_who_borrowe_me(String bookName) {
		int index = getBook_index(bookName);
		books[index].show_who_borrowed_you();
	}

// ----- return book -----------------------
	void return_book_handler(String bookName, String userName) {
		int bookIndex = getBook_index(bookName);
		int bookId = books[bookIndex].id;
		int userIndex = getUser_index(userName);
		users[userIndex].removeBook(bookId);
		books[bookIndex].removeUser(userName);
	}

// sort books area -------------------------
	class CompareIds implements Comparator<Books> {

		@Override
		public int compare(Books o1, Books o2) {
			return -(o1.id - o2.id);
		}

	}

	class CompareNames implements Comparator<Books> {
		@Override
		public int compare(Books o1, Books o2) {
			return -o1.name.compareTo(o2.name);
		}

	}

	void print_library_by_id() {
		Arrays.sort(books, new CompareIds());
		for (int i = 0; i < booksLength; i++) {
			System.out.println("id = " + books[i].id + " name = " + books[i].name + " total_quantity "
					+ books[i].quantity + " total_borrowed " + books[i].length);
		}
	}

	void print_library_by_names() {
		Arrays.sort(books, new CompareNames());
		for (int i = 0; i < booksLength; i++) {
			System.out.println("id = " + books[i].id + " name = " + books[i].name + " total_quantity "
					+ books[i].quantity + " total_borrowed " + books[i].length);
		}
	}

// - --- print --------------------------
	void print_users() {
		for (int i = 0; i < usersLength; i++) {
			System.out.print("user " + users[i].name + " id " + users[i].id + " borrowed books ids: ");
			users[i].print_user_books();
		}
		System.out.println();
	}

//------------------------------------------
	int getUser_index(String userName) {
		int i = 0;
		for (; i < usersLength; i++) {
			if (users[i].name.equals(userName))
				break;
		}
		return i;
	}

	int getBook_index(String BookName) {
		int i = 0;
		for (; i < booksLength; i++) {
			if (books[i].name.equals(BookName))
				break;
		}
		return i;
	}

}

//********************************************************************************************
class Users {
	// ---- data -----------
	final int MAX_BORROWED_BOOKS = 7 * 10;
	int id;
	String name;
	int[] borrowed_books;
	int borrowed_books_length;
	// -------------------

	public Users() {
		id = 0;
		name = "";
		borrowed_books = new int[MAX_BORROWED_BOOKS];
		borrowed_books_length = 0;
	}

	public Users(String name, int id) {
		borrowed_books = new int[MAX_BORROWED_BOOKS];
		this.id = id;
		this.name = name;
	}

	// user borrow book
	void borrow_book(int bookId) {
		borrowed_books[borrowed_books_length++] = bookId;
	}

	// user return book
	void removeBook(int bookId) {
		int i = 0;
		for (; i < borrowed_books_length; i++) {
			if (borrowed_books[i] == bookId)
				break;
		}
		for (int j = i; j < borrowed_books_length - 1; j++) { //
			borrowed_books[j] = borrowed_books[j + 1];
		}
		borrowed_books_length--;
	}

	// print users
	void print_user_books() {
		for (int i = 0; i < borrowed_books_length; i++) {
			System.out.println(borrowed_books[i] + " ");
		}
	}

}

class Books {
	// ---- data -----------
	int quantity;
	int id;
	String name;
	String[] Who_Borrowed_me;
	int length;

	// -------------------
	public Books() {
		name = "";
		length = 0;
	}

	public Books(String name, int id, int quantity) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		Who_Borrowed_me = new String[quantity];
		for (int i = 0; i < quantity; i++) {
			Who_Borrowed_me[i] = "";
		}
	}

	// is match
	boolean isMatch(String pattern) {
		for (int i = 0; i < pattern.length(); i++)
			if (name.charAt(i) != pattern.charAt(i))
				return false;
		return true;
	}

	// show_who_borrow_your
	void show_who_borrowed_you() {
		for (int i = 0; i < length; i++) {
			System.out.println(Who_Borrowed_me[i]);
		}
	}

	// update borrowed me list
	void add_to_borrow_me(String userName) {
		Who_Borrowed_me[length++] = userName;
		quantity--;
	}

	// remove
	void removeUser(String userName) {
		int i = 0;
		for (; i < length; i++) {
			if (Who_Borrowed_me[i] == userName)
				break;
		}
		for (int j = i; j < length - 1; j++) { //shifting
			Who_Borrowed_me[j] = Who_Borrowed_me[j + 1];
		}
		length--;
		quantity++;
	}
}

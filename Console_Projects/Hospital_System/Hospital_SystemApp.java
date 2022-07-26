package projects;
//============================================================================

// Name        : Hospital_System
// Author      : Ahmed_hadaka
// Version     :
// Copyright   : Your copyright notice
//============================================================================

import java.util.Scanner;

public class Hospital_SystemApp {
	public static void main(String[] args) {
		Hospital_System hospital_System = new Hospital_System();
		hospital_System.go();
	}
}

class Hospital_System {
	Scanner sc = new Scanner(System.in);
	final int MAX_SPECIALIZATION = 21;

	Hospital_queue[] queues = new Hospital_queue[MAX_SPECIALIZATION];

	Hospital_System() {
		for (int i = 1; i < MAX_SPECIALIZATION; ++i) {
			queues[i] = new Hospital_queue();
		}
	}

	void print_specializations() {
		for (int i = 1; i < MAX_SPECIALIZATION; ++i) {
			if (!queues[i].is_empty()) {
				System.out.println("There are " + queues[i].length + " patients in specialization " + i);
				queues[i].print_patient();
			}
		}
	}

	int print_menu() { // will handle invalid inputs
		int choice;
		while (true) {
			System.out.println("Enter your choice:  ");
			System.out.println("1) Add new patient  ");
			System.out.println("2) Print all patients  ");
			System.out.println("3) Get next patient  ");
			System.out.println("4) Exit  ");
			choice = sc.nextInt();
			if (choice > 4 || choice < 1) {
				System.out.println("Invalid choice, please try again ");
			} else
				return choice;
		}
	}

	int[] read_request(int specialization, int status) {
		int[] data = new int[2];
		while (true) {
			System.out.println("Enter specialization, status: ");
			data[0] = sc.nextInt();
//			name = sc.next();
			data[1] = sc.nextInt();
			if (!(data[0] <= 20 && data[0] >= 1) || (data[1] != 1 && data[1] != 0)) {
				System.out.println("Invalid specialization or status, please try again. ");
				continue;
			} else {
				System.out.println();
				break;
			}
		}
		return data;
	}

	void adding_patient(int specialization, String name, int status) {
		if (status == 1) // urgent
			queues[specialization].add_first(name);
		else
			queues[specialization].add_last(name);
	}

	// go()
	void go() {
		while (true) {
			int[] data = new int[2];
			int specialization = 0, status = 0;
			String name = "";
			int choice = print_menu();
			if (choice == 1) { // add new patient
				System.out.println("Enter Your name: ");
				name = sc.next();
				data = read_request(specialization, status);
				specialization = data[0];
				status = data[1];
				if (queues[specialization].is_full()) {
					System.out.println("Sorry, this specialization is full\n");
				} else
					adding_patient(specialization, name, status);
			} else if (choice == 2) { // print all patient
				print_specializations();
			} else if (choice == 3) { // get next patient
				System.out.println("Enter specialization: ");
				specialization = sc.nextInt();
				queues[specialization].get_next_patient();
			} else
				// exit
				break;
		}
	}
}

class Hospital_queue {
	final int MAX_SPECIALIZATION = 21, MAX_QUEUE = 6;
	String[] names = new String[MAX_QUEUE];
	int[] status = new int[MAX_QUEUE];
	int length;

	Hospital_queue() {
		length = 0;
	}

	void remove_patient() {
		int i = 1;
		while (names[i] != "") { // shifting left
			names[i] = names[i + 1];
			i++;
		}
		length--; // resize
	}

	void print_patient() {
		for (int i = 1; i <= length; ++i) {
			System.out.print(names[i]);
			if (status[i] == 1)
				System.out.println(" urgent ");
			else
				System.out.println(" regular ");
		}
		System.out.println(" ");
	}

	void shift_right() {
		for (int i = length; i > 0; i--) {
			names[i + 1] = names[i];
			status[i + 1] = status[i];
		}
	}

	void add_first(String name) { // urgent
		shift_right(); // shifting right
		names[1] = name; // add it
		length++; // resize the queue
		status[1] = 1; // set status
	}

	void add_last(String name) { // regular
		names[length + 1] = name;
		length++; // resize
	}

	// is_full()
	boolean is_full() {
		return (length == MAX_QUEUE - 1);
	}

	// is_empty()
	boolean is_empty() {
		return (length == 0);
	}

	// get_next_patient();
	void get_next_patient() {
		if (is_empty())
			System.out.println("No patient at the moment, Have rest Dr ");
		else {
			System.out.println(names[1] + " Please go with the Dr");
			remove_patient();
		}
		System.out.println();
	}
}

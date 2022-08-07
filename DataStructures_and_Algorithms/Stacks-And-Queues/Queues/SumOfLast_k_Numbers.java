package problems_java_DS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SumOfLast_k_Numbers_class {
	int k;
	Queue<Integer> q;
	int lastSum;

	public SumOfLast_k_Numbers_class(int k) {
		this.k = k;
		q = new LinkedList<Integer>();
		lastSum = 0;
	}

	public int next(int newNum) {
		if (q.size() == k)
			lastSum = lastSum - q.poll() + newNum;
		else
			lastSum = lastSum + newNum;
		q.add(newNum);
		return lastSum;
	}

}

public class SumOfLast_k_Numbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SumOfLast_k_Numbers_class sK_Numbers = new SumOfLast_k_Numbers_class(4);
		int num;
		while (true) {
			num = sc.nextInt();
			if (num == -1) {
				sc.close();
				return;
			}
			System.out.println(sK_Numbers.next(num));
		}

	}

}

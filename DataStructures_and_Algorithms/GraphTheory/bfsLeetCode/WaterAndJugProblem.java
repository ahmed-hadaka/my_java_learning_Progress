package bfsLeetCode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class WaterAndJugProblem {

	public static void main(String[] args) {
		System.out.println(canMeasureWater(1, 2, 3));
	}

	private static class Pair {
		int v1;
		int v2;

		public Pair(int v1, int v2) {
			this.v1 = v1;
			this.v2 = v2;
		}

		@Override
		public int hashCode() {
			return v1 + v2;
		}

		@Override
		public boolean equals(Object obj) {
			Pair o = (Pair) obj;
			return this.v1 == o.v1 && this.v2 == o.v2;
		}
	}

	public static boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
		if (targetCapacity > (jug1Capacity + jug2Capacity))
			return false;
		if (targetCapacity == (jug1Capacity + jug2Capacity))
			return true;
		Set<Pair> set = new HashSet<>();
		ArrayDeque<Pair> q = new ArrayDeque<>();
		return canMeasureWaterBFS(set, q, jug1Capacity, jug2Capacity, targetCapacity);
	}

	private static boolean canMeasureWaterBFS(Set<Pair> set, ArrayDeque<Pair> q, int jug1Capacity, int jug2Capacity,
			int targetCapacity) {
		Pair pair = new Pair(0, 0);
		q.addLast(pair);
		set.add(pair);
		for (int size = q.size(); !q.isEmpty(); size = q.size()) {
			while (size-- > 0) {
				Pair cur = q.pollFirst();
				if (process(set, q, jug1Capacity, cur.v2, targetCapacity) // fill1
						|| process(set, q, cur.v1, jug2Capacity, targetCapacity)// fill2
						|| process(set, q, pour1(cur.v1, cur.v2, jug2Capacity)[0],
								pour1(cur.v1, cur.v2, jug2Capacity)[1], targetCapacity) // pour1
						|| process(set, q, pour2(cur.v1, cur.v2, jug1Capacity)[0],
								pour2(cur.v1, cur.v2, jug1Capacity)[1], targetCapacity) // pour2
						|| process(set, q, 0, cur.v2, targetCapacity) // empty1
						|| process(set, q, cur.v1, 0, targetCapacity)) // empty2
					return true;
			}
		}
		return false;
	}

	private static boolean process(Set<Pair> set, ArrayDeque<Pair> q, int v1, int v2, int targetCapacity) {
		Pair temp = new Pair(v1, v2);
		if (!set.contains(temp)) {
			if (v1 + v2 == targetCapacity)
				return true;
			q.addLast(temp);
			set.add(temp);
		}
		return false;
	}

	private static int[] pour1(int v1, int v2, int c2) {
		int temp = v1 + v2;
		int newV1, newV2;
		if (temp <= c2) {
			newV1 = 0;
			newV2 = temp;
		} else {
			newV1 = temp - c2;
			newV2 = c2;
		}
		return new int[] { newV1, newV2 };
	}

	private static int[] pour2(int v1, int v2, int c1) {
		int temp = v1 + v2;
		int newV1, newV2;
		if (temp <= c1) {
			newV1 = temp;
			newV2 = 0;
		} else {
			newV1 = c1;
			newV2 = temp - c1;
		}
		return new int[] { newV1, newV2 };
	}

}

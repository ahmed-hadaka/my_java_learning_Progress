package dfsLeetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/employee-importance

public class ImployeeImportance {

	public int getImportance(List<Employee> employees, int id) {
		int[] res = { 0 };
		Map<Integer, Employee> map = idToEmployee(employees);
		DFS(employees, id, map, res);
		return res[0];
	}

	private Map<Integer, Employee> idToEmployee(List<Employee> employees) {
		Map<Integer, Employee> map = new HashMap<>();
		for (int i = 0; i < employees.size(); i++) {
			map.put(employees.get(i).id, employees.get(i));
		}
		return map;
	}

	private void DFS(List<Employee> employees, int id, Map<Integer, Employee> map, int[] res) {
		Employee employee = map.get(id);
		res[0] += employee.importance;
		for (int i : employee.subordinates) {
			DFS(employees, i, map, res);
		}
	}

	class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
	}
}

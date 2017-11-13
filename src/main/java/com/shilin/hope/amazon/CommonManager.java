package com.shilin.hope.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 第二题： 类似于 你需要登录以查看此链接. 但是完全不一样。 是说给一个 公司的级别树，最上面是CEO， 然后employee下面有需要向他report的人的话， 这个employee 就是manager，每个employee
 * 最多有一个manager。 然后给你两个employee 让你找出他们的最低的common manager。 employee的数据结构如下： Employee { int id; string name; vector
 * reports; vector getReports(); int getId(); string getName(); } Employee* findCommonManager(Employee* ceo, Employee*
 * employee1, Employee* employee2) { }
 */
public class CommonManager {

    public static void main(String args[]) {
        Employee emp1 = new Employee();
        emp1.id = 1;

        Employee emp2 = new Employee();
        emp2.id = 2;

        Employee emp3 = new Employee();
        emp3.id = 3;

        Employee emp4 = new Employee();
        emp4.id = 4;

        Employee emp5 = new Employee();
        emp5.id = 5;

        Employee emp6 = new Employee();
        emp6.id = 6;

        Employee ceo = new Employee();
        ceo.id = 7;

        ceo.reports = Arrays.asList(emp6, emp5);

        emp6.reports = Arrays.asList(emp4, emp3);

        emp4.reports = Arrays.asList(emp1);

        emp3.reports = Arrays.asList(emp2);

        emp2.reports = new ArrayList<>();
        emp1.reports = new ArrayList<>();
        emp5.reports = new ArrayList<>();

        System.out.println(findCommonManager(ceo, emp1, emp2).getId());

    }

    public static Employee findCommonManager(Employee ceo, Employee employee1, Employee employee2) {

        Stack<Employee> dfs = new Stack<>();

        Employee emp = ceo;

        List<Employee> path = new ArrayList<>();
        List<Employee> path1 = new ArrayList<>();
        path.add(ceo);
        helper(path1, path, ceo, employee1);

        path = new ArrayList<>();
        List<Employee> path2 = new ArrayList<>();
        path.add(ceo);
        helper(path2, path, ceo, employee2);

        if (path1.size() == 0 || path2.size() == 0) {
            return null;
        }

        int i = path1.size() - 1;
        int j = path2.size() - 1;

        while (path1.get(i) != path2.get(j)) {
            i--;
            j--;
        }

        return path1.get(i);
    }

    private static void helper(List<Employee> solution, List<Employee> path, Employee root, Employee emp) {
        if (path.get(path.size() - 1) == emp) {
            solution.addAll(new ArrayList<>(path));
            return;
        }

        for (Employee sub : root.getReports()) {
            if (solution.size() > 0) {
                break;
            }
            path.add(sub);
            helper(solution, path, sub, emp);
            path.remove(path.size() - 1);
        }
    }

    static class Employee {
        int id;
        String name;
        List<Employee> reports;

        List<Employee> getReports() {
            return reports;
        }

        int getId() {
            return id;
        }

        String getName() {
            return name;
        }

        public String toString() {
            return "id = " + id;
        }
    }


}

package p1.tests;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class E1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l1 = new LinkedList<>();
		l1.add("a");
		l1.add("b");
		l1.add("c");
		l1.add("d");
		List<String> l2 = l1.subList(1, 4);
		System.out.println(l1);
		l2.remove(2);
		System.out.println(l2);
		Set<String> s1 = new HashSet<>();
		s1.add("a");
		s1.add("b");
		s1.add("c");
		s1.add("d");
	}

}

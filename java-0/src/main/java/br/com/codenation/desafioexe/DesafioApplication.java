package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> numbers = new ArrayList<>();
		Integer previous = 0;
		Integer current = 1;
		Integer next;

		numbers.addAll(Arrays.asList(previous, current));

		while (current < 350){
			next = current + previous;
			numbers.add(next);
			previous = current;
			current = next;
		}
		return numbers;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}
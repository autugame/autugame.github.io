package com.autuo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("good", "good", "study", "day", "day", "up");
		//stream.forEach((str) -> {System.out.println(str);});
		//stream.filter((str) -> str.length() > 3).forEach(System.out::println);
		//stream.distinct().forEach(s -> System.out.println(s));
		//stream.map((s) -> s.toUpperCase()).forEach(s -> System.out.println(s));;
//		Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
//		stream.flatMap(list -> list.stream()).forEach(System.out::println);
		//Optional<String> opt = stream.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
		//System.out.println(opt.get());
		List<String> list = stream.collect(Collectors.toList());
		list.forEach(System.out::println);
		
	}

}

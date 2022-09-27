package com.autuo;

import java.util.Comparator;

public class DogComparator implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
		return o1.getAge() - o2.getAge();
	}

}

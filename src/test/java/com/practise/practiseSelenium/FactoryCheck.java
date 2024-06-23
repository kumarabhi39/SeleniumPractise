package com.practise.practiseSelenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.ITestListener;
import org.testng.annotations.Factory;

public class FactoryCheck
//implements ITestListener
{

//	@Factory
//	public Object[] factorymethod() {
//		Object[] data = { 
//				new DemoFactory(),
//				new DemoFactory()
//				};
//		return data;
//	}

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(2);
		al.add(5);
		al.add(10);
		al.add(9);
		al.add(100);
		al.add(101);

		// List to Arrays
		int[] arr = new int[al.size()];
		int i = 0;
		for (int l : al) {
			arr[i] = l;
			i++;
		}
		for (int j : arr) {
			System.out.println(j);
		}

		// Arrays to List
		ArrayList<Integer> al2 = new ArrayList<>();
		for (int j = 0; j < arr.length; j++) {
			al2.add(arr[j]);
		}
		System.out.println(al2);

		// List to Set
		Set<Integer> set = new HashSet<>();
		for (int e : al2) {
			set.add(e);
		}
		System.out.println(set);
	}
}

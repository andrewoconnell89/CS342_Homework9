package edu;

import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		long startTime, endTime;
		
		// Create Array
		int size = 100000;
		int[] rawData = new int[size];
		for(int element=0; element<rawData.length; element++){
			rawData[element] = (int)(Math.random()*1000);
		}
		
		// Clone the rawData for each sorting method
		int[] rawData_Select = rawData.clone();
		int[] rawData_Insert = rawData.clone();
		int[] rawData_Merge = rawData.clone();
		int[] rawData_Quick = rawData.clone();
		int[] rawData_Heap = rawData.clone();
		
		// Select Sort
		Select select = new Select();
		startTime = System.currentTimeMillis();
		select.selectionsort(rawData_Select, 0, size);
		endTime = System.currentTimeMillis();
		System.out.println("Selection Sort: "+(endTime-startTime));
		
		// Insert Sort
		Insert insert = new Insert();
		startTime = System.currentTimeMillis();
		insert.insertionsort(rawData_Insert, 0, size);
		endTime = System.currentTimeMillis();
		System.out.println("Insert Sort: "+(endTime-startTime));
		
		// Merge Sort
		Mergesort merge = new Mergesort();
		startTime = System.currentTimeMillis();
		merge.mergesort(rawData_Merge, 0, size);
		endTime = System.currentTimeMillis();
		System.out.println("Merge Sort: "+(endTime-startTime));
		
		// Quick Sort
		Quicksort quick = new Quicksort();
		startTime = System.currentTimeMillis();
		quick.quicksort(rawData_Quick, 0, size);
		endTime = System.currentTimeMillis();
		System.out.println("Quick Sort: "+(endTime-startTime));
		
		// Heap Sort
		Heapsort heap = new Heapsort();
		startTime = System.currentTimeMillis();
		heap.heapsort(rawData_Heap, size);
		endTime = System.currentTimeMillis();
		System.out.println("Heap Sort: "+(endTime-startTime));
		
	}

}

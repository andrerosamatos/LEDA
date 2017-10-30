package sorting.simpleSorting;

import java.rmi.dgc.Lease;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		leftIndex = 0;
		while (leftIndex < array.length - 1) {
			T next = array[leftIndex + 1];
			for (rightIndex = leftIndex; rightIndex > 1; rightIndex--) {
				if(next.compareTo(array[rightIndex]) < 0) {
					Util.swap(array, rightIndex, rightIndex + 1);
				}
			}
			leftIndex++;
		}
	}
}


//for (rightIndex = 2; rightIndex < array.length; rightIndex++) {
//	T key = array[rightIndex];
//	leftIndex = rightIndex - 1;
//	while (leftIndex > 0 && array[leftIndex].compareTo(key) >= 1) {
//		array[leftIndex + 1] = array[leftIndex];
//		leftIndex = leftIndex - 1;
//	}
//	array[leftIndex + 1] = key;
//	
//}
package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int posicaoPivo = separar(array, leftIndex, rightIndex);
			sort(array, leftIndex, posicaoPivo - 1);
			sort(array, posicaoPivo + 1, rightIndex);
		}
	}

	private int separar(T[] array, int leftIndex, int rightIndex) {
		T pivo = array[leftIndex];
		int i = leftIndex + 1;
		int f = rightIndex;
		while (i <= f) {
			if (array[i].compareTo(pivo) <= 0)
				i++;
			else if (pivo.compareTo(array[f]) < 0)
				f--;
			else {
				Util.swap(array, i, f);
				i++;
				f--;
			}
		}
		array[leftIndex] = array[f];
		array[f] = pivo;
		return f;
	}
}

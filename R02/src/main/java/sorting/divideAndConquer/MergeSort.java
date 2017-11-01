package sorting.divideAndConquer;

import java.util.ArrayList;
import java.util.List;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		        int meio;
		        if (leftIndex < rightIndex) {
		            meio = (leftIndex + rightIndex) / 2;
		            sort(array, leftIndex, meio);
		            sort(array, meio + 1, rightIndex);
		            intercala(array, leftIndex, meio, rightIndex);
		        }
		    }

		    public void intercala(T[] array, int leftIndex, int meio, int rightIndex) {
		        int i, j, k;
		        T vetorB[] = array[][array.length];
		        for (i = leftIndex; i < meio; i++) {
		            vetorB[i] = (int) array[i];
		        }
		        for (j = meio + 1; j < rightIndex; j++) {
		            vetorB[rightIndex + meio + 1 - j] = (int) array[j];
		        }
		        i = leftIndex;
		        j = rightIndex;
		        for (k = leftIndex; k < rightIndex; k++) {
		            if (vetorB[i] <= vetorB[j]) {
		                array[k] = vetorB[i];
		                i = i + 1;
		            } else {
		                array[k] = vetorB[j];
		                j = j - 1;
		            }
		        }
	}



}

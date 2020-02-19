package sorting;

/**
 * Sort an array containing integers in ascending order
 * (arranged from smallest to largest) using the insertion sort algorithm.
 */
public class InsertionSort implements Sort {

	@Override
	public int[] sort(int[] unsorted) {
		insertionSort(unsorted, 0, unsorted.length - 1);
		return unsorted;
	}

	/**
	 * Sort a part of the provided array between the two indexes.
	 * @param array the array we want to sort.
	 * @param low the lower index of the part we want to sort.
	 * @param high the higher index of the part we want to sort.
	 */
	private void insertionSort(int[] array, int low, int high){
		//throw error if indexes are illegal
		if (high <= low){
			throw new IllegalArgumentException("The starting index needs to be lower than the stop index");
		}

		//start sort on the second element and sort to the last element
		for (int i = low + 1; i < high; i++){
			//the inner loop check all items in the range of the outer loop and swaps them so that smaller ones are
			//to the left of larger ones
			for (int j = i; j > 0 && smaller(array[j], array[j - 1]); j-- ) {
				swap(array, j, j - 1);
			}
		}

	}

	/**
	 * Swap place of two elements in an array.
	 *
	 * @param array the array we want to swap elements within.
	 * @param i the first element we want to swap.
	 * @param j the second element we want to swap.
	 */
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * Check if one integer is smaller than another.
	 *
	 * @param a the initial integer.
	 * @param b the integer to compare a's size to.
	 */
	private static boolean smaller(int a, int b){
		return (a - b) < 0;
	}
}
package sorting;

/**
 * Sort an array containing integers in ascending order
 * (arranged from smallest to largest) using the Drake sort algorithm.
 */
public class DrakeSort implements Sort {

	@Override
	public int[] sort(int[] unsorted) {
		drakeSort(unsorted, 0, unsorted.length - 1);
		return unsorted;
	}

	/**
	 * Sort a part of the provided array between the two indexes.
	 * @param array the array we want to sort.
	 * @param low the lower index of the part we want to sort.
	 * @param high the higher index of the part we want to sort.
	 */
	private void drakeSort(int[] array, int low, int high){
		
	}
}
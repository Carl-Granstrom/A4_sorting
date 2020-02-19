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

		//this check requires N compares, we could also just ignore negative values and return a sorted array of only
		//the positive values, but it seems unsafe.
		for (int i : array) {
			if (i < 0) {
				throw new IllegalArgumentException("Array must not contain negative numbers");
			}
		}

		int highest = findHigh(array, low, high);	//find the highest number in the array
		int[] countArray = new int[highest + 1];

		for (int i = low; i <= high; i++){		//for each integer in the array to be sorted
			countArray[array[i]]++;				//increment the index of the counter at correct array position
		}

		//transfer the sorted numbers into the initial array at correct index positions
		for (int i = low; i <= high; i++){
			for (int j = 0; j < countArray.length; j++){
				while (countArray[j] > 0) {
					array[i] = j;
					countArray[j]--;	//decrement counter at index j
					i++;				//skip to next index in outer loop
				}
			}
		}

	}

	/**
	 * Find the highest value in an array of positive integers.
	 * @param array the array to be sorted.
	 * @param low the starting index to start searching for the highest number.
	 * @param high the index to stop searching for the highest number
	 * @return the highest number found
	 */
	private int findHigh(int[] array, int low, int high){
		int highest = 0;
		//loop through the array to find the largest value
		for (int a = low; a <= high; a++){
			if (a > highest){
				highest = a;
			}
		}
		return highest;
	}
}
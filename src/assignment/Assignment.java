package assignment;

public class Assignment {

	public static void main(String[] args) {
		final int nums[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		System.out.println(helicalPrintArray(nums));
	}

	/**
	 * Given a 2D array, traverses the given array in a helical path then prints the
	 * numbers along this path.
	 * 
	 * @param nums 2D array of integer numbers
	 */
	public static String helicalPrintArray(int[][] nums) {

		// create a stringbuffer to collect each element of the array as string pieces.
		StringBuffer resultString = new StringBuffer();

		// check whether the input array is null or empty. it it is return only empty
		// string.
		if (nums == null || nums.length == 0 || nums[0].length == 0)
			return "";

		// determine the firstRow as 0, firstColumn as 0, lastRow as (R-1) and
		// lastColumn as (C-1) variables, where R and C are number of Rows and Columns
		// respectively.
		int numberOfRows = nums.length;
		int numberOfColumns = nums[0].length;
		int firstRow = 0;
		int firstColumn = 0;
		int lastRow = numberOfRows - 1;
		int lastColumn = numberOfColumns - 1;

		// initial direction is Right which 'R' stands for.
		Character direction = 'R';

		// go in the while loop and stay in until firstRow meets LastRow and firstColumn
		// meets lastColumn. 2D array shrinks.
		while (firstRow <= lastRow && firstColumn <= lastColumn) {

			// if direction is Right;
			if (direction.equals('R')) {

				// get elements of firstRow from firstColumn to lastColumn.
				for (int i = firstColumn; i <= lastColumn; i++) {
					resultString.append(nums[firstRow][i] + ",");
				}
				// increment firstRow by 1 in order to not meet this row again.
				firstRow++;
				// change the direction to Down.
				direction = 'D';

				// if direction is Down;
			} else if (direction.equals('D')) {

				// get elements of lastColumn from firstRow to lastRow.
				for (int i = firstRow; i <= lastRow; i++) {
					resultString.append(nums[i][lastColumn] + ",");
				}
				// decrement lastColumn by 1 in order to not meet this column again.
				lastColumn--;
				// change the direction to Left.
				direction = 'L';

				// if direction is Left;
			} else if (direction.equals('L')) {

				// get elements of lastRow from lastColumn to firstColumn.
				for (int i = lastColumn; i >= firstColumn; i--) {
					resultString.append(nums[lastRow][i] + ",");
				}
				// decrement lastRow by 1 in order to not meet this row again.
				lastRow--;
				// change the direction to Up.
				direction = 'U';

				// if direction is Up;
			} else if (direction.equals('U')) {

				// get elements of firstColumn from lastRow to firstRow.
				for (int i = lastRow; i >= firstRow; i--) {
					resultString.append(nums[i][firstColumn] + ",");
				}
				// increment firstColumn by 1 in order to not meet this column again.
				firstColumn++;
				// change the direction to Right.
				direction = 'R';
			}
		}
		// remove last comma ',' sign from the end of the string and return it.
		return resultString.toString().substring(0, resultString.length() - 1);
	}
}

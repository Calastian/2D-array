import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArrayAssignmentTest {

	ArrayAssignment aa = new ArrayAssignment();

	@Test
	public void testShowEmptyMap() {
		boolean[][] emptyMap = new boolean[0][0];
		String result = aa.showMap(emptyMap);
		assertEquals("Expected the empty string, found: " + result.replace("\n", "\\n"), "", result);
	}

	@Test
	public void testShowRegularMap() {
		boolean[][] regularMap = { { true, false }, { false, true } };
		String result = aa.showMap(regularMap);
		assertEquals("Expected: X \\n X\\n, found: " + result.replace("\n", "\\n"), "X \n X\n", result);
	}

	@Test
	public void testShowIrregularMap() {
		boolean[][] irregularMap = { { true, false, false, true }, { false, true } };
		String result = aa.showMap(irregularMap);
		assertEquals("Expected: X  X\\n X\\n, found: " + result.replace("\n", "\\n"), "X  X\n X\n", result);
	}

	@Test
	public void testShowFilledMap() {
		boolean[][] filledMap = { { true, true, true }, { true, true, true }, { true, true, true } };
		String result = aa.showMap(filledMap);
		assertEquals("Expected: XXX\\nXXX\\nXXX\\n, found: " + result.replace("\n", "\\n"), "XXX\nXXX\nXXX\n", result);
	}

	@Test
	public void testShowUnfilledMap() {
		boolean[][] unfilledMap = { { false, false, false }, { false, false, false }, { false, false, false } };
		String result = aa.showMap(unfilledMap);
		assertEquals("Expected:    \\n   \\n   \\n, found: " + result.replace("\n", "\\n"), "   \n   \n   \n", result);
	}

	@Test
	public void testCreateMines() {
		// NOTE: We do this 100 times, since, if duplicate indices
		// are accidentally allowed, we would generally see it by then
		for (int repetitions = 0; repetitions < 100; repetitions++) {
			boolean[][] minesMap = aa.createMines();
			
			assertNotNull("createMines should not return null", minesMap);
			
			int trueCount = 0;
			for (boolean[] element : minesMap) {
				for (int j = 0; j < element.length; j++) {
					if (element[j]) {
						trueCount++;
					}
				}
			}

			assertEquals("Expected exactly 10 true elements, found " + trueCount, 10, trueCount);
		}
	}

	@Test
	public void testFindAveragesEmpty() {
		double[][] input = new double[0][0];

		double[] result = aa.findAverages(input);

		assertNotNull("createMines should not return null", result);
		
		assertEquals("The result should have length " + input.length + " but instead has length " + result.length, 0,
				result.length);
	}

	@Test
	public void testFindAveragesRegular() {
		double[] averages = { 4.1, 2.3, 4.2 };
		double[][] input = { { 2.1, 1.3, 8.9 }, { 1.5, 2.3, 3.1 }, { 4.5, 4.1, 4.0 } };

		double[] result = aa.findAverages(input);

		assertNotNull("The result of findAverages should not be null", result);
		
		assertEquals("Array should have length " + input.length + ", instead has length: " + result.length,
				input.length, result.length);

		for (int i = 0; i < input.length; i++) {
			assertTrue("Average should be " + averages[i] + " but instead was computed as " + result[i],
					Math.abs(averages[i] - result[i]) < 0.001);
		}
	}

	@Test
	public void testFindAveragesWithEmptyRow() {
		double[] averages = { 4.1, 0, 4.2 };
		double[][] input = { { 2.1, 1.3, 8.9 }, { 1.5, 2.3, 3.1 }, { 4.5, 4.1, 4.0 } };
		input[1] = new double[0];

		double[] result = aa.findAverages(input);

		assertNotNull("The result of findAverages should not be null", result);
		
		assertEquals("Array should have length " + input.length + ", instead has length: " + result.length,
				input.length, result.length);

		for (int i = 0; i < input.length; i++) {
			assertTrue("Average should be " + averages[i] + " but instead was computed as " + result[i],
					Math.abs(averages[i] - result[i]) < 0.001);
		}
	}

	@Test
	public void testFindAveragesIrregular() {
		double[] averages = { 4.1, 2.7, 4.3 };
		double[][] input = { { 2.1, 1.3, 8.9 }, { 1.5, 2.3, 3.1, 3.9 }, { 4.5, 4.1 } };

		double[] result = aa.findAverages(input);

		assertNotNull("The result of findAverages should not be null", result);
		
		assertEquals("Array should have length " + input.length + ", instead has length: " + result.length,
				input.length, result.length);

		for (int i = 0; i < input.length; i++) {
			assertTrue("Average should be " + averages[i] + " but instead was computed as " + result[i],
					Math.abs(averages[i] - result[i]) < 0.001);
		}
	}

	@Test
	public void testNoDuplicatesRegular() {
		int[][] input = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		boolean result = aa.noDuplicates(input);

		assertEquals("The array contains no duplicates, but this method returned " + result, true, result);
	}

	@Test
	public void testNoDuplicatesRegularWithDupes() {
		int[][] input = { { 1, 2, 3 }, { 4, 5, 5 }, { 7, 8, 9 } };

		boolean result = aa.noDuplicates(input);

		assertEquals("The array contains duplicates, but this method returned " + result, false, result);
	}

	@Test
	public void testNoDuplicatesIregular() {
		int[][] input = { { 1, 2 }, { 4, 5, 6 }, { 7, 8, 9, 10, 11 } };

		boolean result = aa.noDuplicates(input);

		assertEquals("The array contains no duplicates, but this method returned " + result, true, result);
	}

	@Test
	public void testNoDuplicatesIregularWithDupes() {
		int[][] input = { { 1, 2 }, { 4, 5, 5 }, { 7, 8, 9, 10, 11 } };

		boolean result = aa.noDuplicates(input);

		assertEquals("The array contains duplicates, but this method returned " + result, false, result);
	}

	@Test
	public void testNoDuplicatesWithEmptyInput() {
		int[][] input = new int[0][0];

		boolean result = aa.noDuplicates(input);

		assertEquals("An empty array contains no duplicates by default, but this method returned " + result, true,
				result);
	}

	@Test
	public void testNoDuplicatesRegularWithEmptyRow() {
		int[][] input = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		input[0] = new int[0];

		boolean result = aa.noDuplicates(input);

		assertEquals("The array contains no duplicates, but this method returned " + result, true, result);
	}

	@Test
	public void testNoDuplicatesRegularWithDupesAndEmptyRow() {
		int[][] input = { { 1, 2, 3 }, { 4, 5, 5 }, { 7, 8, 9 } };
		input[0] = new int[0];

		boolean result = aa.noDuplicates(input);

		assertEquals("The array contains duplicates, but this method returned " + result, false, result);
	}

}

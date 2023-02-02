import java.util.Random;
/**
 * This class includes several different, unrelated homework methods.
 * 
 * @author Christian Novgrod
 * @version 1.0
 *
 */
public class ArrayAssignment {
	
	/**
	 * Return a String visualizing the contents of map.
	 * 
	 * The resulting String will include an X for each true value in map, and
	 * a blank space for each false value in map. A newline should be added
	 * at the end of each row in the map. For instance, a map with the values
	 * [ [ true, false ], [ false, true ] ] would result in "X \n X\n", which
	 * would print as:
	 * 
	 * X 
	 *  X
	 * 
	 * @param map includes true in each location where an X will be printed
	 * 
	 * @return a visualization of the map, with X for each true value and blank
	 * 		   for each false value and with rows ended with newlines
	 */
	public String showMap(boolean[][] map)
    {
        String str = "";

        for ( int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                if (map[i][j])
                {
                    str += ("X");

                }
                else{
                    str += (" ");
                }
            }
            str += "\n";
        }
		
		return str; 
    }
    // Remove this once you have a real return value! 
	/**
	 * Creates a 10x10 boolean array with exactly 10 true values. These 10
	 * true values are placed randomly throughout the array, so the locations
	 * of these values will potentially differ each time this method is called.
	 * 
	 * @return a 10x10 boolean array with exactly 10 true values
	 */
    public boolean[][] createMines()
    {
        
        // These variables store 2D array lengths & the count for the loop.
        Random ran = new Random();
        boolean[][] mine = new boolean[10][10];

       int row = 10;
       int col = 10; 
       int count = 0; 
       //This while loop creates the mines throught the 2D array.
       while(count < 10)
       {
            int rRow = ran.nextInt(row);
            int rCol = ran.nextInt(col);
            if (!mine[rRow][rCol])
            {
                mine[rRow][rCol] = true;
                count++;
            }
       }                                      
    	return mine; 
    }

    /**
     * Computes the average of each row in the input array list. The average
     * of a row of length 0 is 0.0.
     * 
     * @param list The numbers to average
     * 
     * @return the average of each row in the input array
     */
    public double[] findAverages(double[][] list)
    {
        // TODO: code here

    	return null; // Remove this once you have a real return value!
    }

    /**
     * Returns true if the array contains no duplicate integers, or false otherwise.
     * By default, an empty array, with 0 rows and columns, contains no duplicates.
     * 
     * @param array the array to check for duplicates
     * 
     * @return true where there are no duplicates, false otherwise
     */
    public boolean noDuplicates(int[][] array)
    {
        // TODO: code here
    	
        return false; // Just a default, replace with actual value (which may be false)
    }
}

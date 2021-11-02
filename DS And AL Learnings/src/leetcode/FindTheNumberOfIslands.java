package leetcode;

/*
 * 2 Nov 2021
 */

/*
 * https://leetcode.com/problems/number-of-islands/
 */

public class FindTheNumberOfIslands {
	
	static int ROW,COL;
	
	public static void main(String[] args) {
		
		char grid[][] = {{'1','1','1','1','0'},
						 {'1','1','0','1','0'},
						 {'1','1','0','0','0'},
						 {'0','0','0','0','0'}};
		
		int islands = numOfIslands(grid);
		System.out.println(islands);
	}
	
	static int numOfIslands(char grid[][]) {
		
		int count = 0;
		
		ROW = grid.length;
		if(ROW ==0) {
			return 0;
		}
		COL = grid[0].length;
		
		for(int i = 0; i < ROW; i++) {
			for(int j = 0; j < COL; j++) {
				if(grid[i][j] == '1') {
					DFSMarking(grid, i, j);
					++count;
				}
			}
		}
		
		return count;
	}
	
	 /**
     * Marks the given site as visited, then checks adjacent sites.
     * 
     * Or, Marks the given site as water, if land, then checks adjacent sites.
     * 
     * Or, Given one coordinate (i,j) of an island, obliterates the island
     * from the given grid, so that it is not counted again.
     * 
     * @param i, the row index of the given grid
     * @param j, the column index of the given grid
     */
	
	static void DFSMarking(char[][] grid,int i, int j) {
		if(i < 0 || j < 0 || i >= ROW || j >= ROW || grid[i][j] != '1') {
			System.out.println("Not Done : "+i + " "+ j );
			return;
		}
		
		// Mark the site as visited
		grid[i][j] = '0';
		System.out.println("Done : "+i + " "+ j );
		// Check all adjacent sites
		DFSMarking(grid, i + 1, j);
	    DFSMarking(grid, i - 1, j);
	    DFSMarking(grid, i, j + 1);
	    DFSMarking(grid, i, j - 1);
		
	}
}

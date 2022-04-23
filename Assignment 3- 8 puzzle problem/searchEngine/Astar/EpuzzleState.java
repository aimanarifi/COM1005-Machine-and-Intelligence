import java.util.ArrayList;

public class EpuzzleState extends SearchState {
	
	private int[][] puzzleLayout;
	
	public EpuzzleState(int[][] puzzleLayout, Search searcher) {
		EpuzzleSearch puzzSearcher = (EpuzzleSearch) searcher;
		this.puzzleLayout = puzzleLayout;
		localCost = 1;
		this.estRemCost = calcEstRemCost(searcher, puzzleLayout, puzzSearcher.getTarget(), puzzSearcher.getRemCostCalcMethod());
	}
	
    public int[][] getPuzzleLayout(){
    	return puzzleLayout;
    }
    
    /**
     * calculate remaining cost from the current layout to the target layout
     * @param searcher 
     * @param s - current layout
     * @param t - target layout
     * @param costMethod - either Manhattan or Hamming
     * @return estimated remaining cost
     */
    public int calcEstRemCost(Search searcher, int[][] s, int[][] t, String costMethod) {
    	EpuzzleSearch puzzSearcher = (EpuzzleSearch) searcher;
    	return puzzSearcher.getPuzzGen().estRemCostMethod(s, t, costMethod);
    }
    
    /**
    * goalPredicate takes a SearchNode & returns a boolean if it's a goal
    */
    public boolean goalPredicate(Search searcher) {
    	EpuzzleSearch puzzleNode = (EpuzzleSearch) searcher;
    	
    	//compare number in all positions
    	int[][] target = puzzleNode.getTarget();
    	for(int i = 0; i < target.length; i++) {
    		for (int j = 0; j < target[0].length ; j++) {
    			if (puzzleLayout[i][j] != target[i][j]) { return false;}
    		}
    	}
    	return true;
    }

    /** getSuccessors returns an ArrayList of states which are successors to the
    * current state in a given search
    */
    public ArrayList<SearchState> getSuccessors(Search searcher){
    	
    	EpuzzleSearch puzzleSearcher = (EpuzzleSearch) searcher;
    	int row = 0;
    	int col = 0;
    	for (int i = 0; i < puzzleSearcher.getPuzzleLayout().length; i++) {
    		for (int j = 0; j < puzzleSearcher.getPuzzleLayout().length; j++) {
    			if (puzzleLayout[i][j] == 0) {
    				row = i;
    				col = j;
    			}
    		}
    	}
    	
    	ArrayList<EpuzzleState> puzStateList = new ArrayList<EpuzzleState>();
    	ArrayList<SearchState> puzSearchStateList = new ArrayList<SearchState>();
    	
    	//Swap places with number above
    	if ( row > 0 ) {
    		int[][] newLayout = swapNumber(row , col , row-1 , col);
    		puzStateList.add(new EpuzzleState(newLayout,searcher));
    	}
    	//Swap places with number below
    	if ( row < puzzleSearcher.getPuzzleLayout().length - 1) {
    		int[][] newLayout = swapNumber(row , col , row+1 , col);
    		puzStateList.add(new EpuzzleState(newLayout,searcher));
    	}
    	//Swap places with number on the left
    	if ( col > 0 ) {
    		int[][] newLayout = swapNumber(row , col , row , col-1);
    		puzStateList.add(new EpuzzleState(newLayout,searcher));
        }
    	//Swap places with number on the right
        if ( col < puzzleSearcher.getPuzzleLayout().length - 1) {
    		int[][] newLayout = swapNumber(row , col , row , col+1);
    		puzStateList.add(new EpuzzleState(newLayout,searcher));
        }
        
    	for (EpuzzleState state: puzStateList) {
    		puzSearchStateList.add(state);
    	}
    		
    	return puzSearchStateList;
    }

    /**
     * Check if it the same state
     * @param puzzleState
     */
    public boolean sameState(SearchState puzzleState) {
    	int[][] otherPuzzleLayout = ((EpuzzleState)puzzleState).getPuzzleLayout();
    	//compare number in all positions
    	for(int i = 0; i < otherPuzzleLayout.length; i++) {
    		for (int j = 0; j < otherPuzzleLayout.length ; j++) {
    			if (this.puzzleLayout[i][j] != otherPuzzleLayout[i][j]) { return false;}
    		}
    	}
    	return true;
    }
    
    /**
     * Swap 0 (blank) position with the selected position
     * @param row - row of the position
     * @param col - column of the position
     * @return new puzzle layout
     */
    public int[][] swapNumber(int row1, int col1, int row2, int col2){
    	//create new copy of the puzzle
		int[][] tempLayout = new int[this.getPuzzleLayout().length][];
		for( int i = 0; i < this.getPuzzleLayout().length; i++) {
			tempLayout[i] = getPuzzleLayout()[i].clone();
		}	
    	tempLayout[row1][col1] = tempLayout[row2][col2];
    	tempLayout[row2][col2] = 0;
		return tempLayout;
    }
    
    public String toString() {
    	String output = "\n";
    	for(int[] row: this.getPuzzleLayout()) {
    		output = output + "+---+---+---+\n|";
    		for(int col: row) {
    			if(col != 0) {
    			output = output + " " + col + " |";
    			}
    			else {
    				output = output + "   |";
    			}
    		}
    		output = output + "\n";
    	}
    	output = output + "+---+---+---+";
    	return output;
    }

}

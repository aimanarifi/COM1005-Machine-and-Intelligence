import java.util.ArrayList;

public class EpuzzleState extends SearchState {
	
	//State propertie(s)
	private int[][] puzzleLayout;
	
	//Constructor(s)
	public EpuzzleState(int[][] puzzleLayout) {
		this.puzzleLayout = puzzleLayout;
	}
	
	//Accessor method(s)
    public int[][] getPuzzleLayout(){
    	return puzzleLayout;
    }
    
    /**
    * goalPredicate takes a SearchNode & returns a boolean if it's a goal
    */

    public boolean goalPredicate(Search searcher) {
    	EpuzzleSearch puzzleNode = (EpuzzleSearch) searcher;
    	
    	//compare number in all positions
    	int[][] target = puzzleNode.getTarget();
    	for(int i = 0; i <= 3; i++) {
    		for (int j = 0; j <= 3; j++) {
    			if (puzzleLayout[i][j] != target[i][j]) { return false;}
    		}
    	}
    	
    	return true;
    }

    /** getSuccessors returns an ArrayList of states which are successors to the
    * current state in a given search
    */
    public ArrayList<SearchState> getSuccessors(Search searcher){
    	
    	int row = 0;
    	int col = 0;
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; i < 3; j++) {
    			if (puzzleLayout[i][j] == 0) {
    				row = i;
    				col = j;
    			}
    		}
    	}
    	
    	ArrayList<EpuzzleState> puzStateList = new ArrayList<EpuzzleState>();
    	ArrayList<SearchState> puzSearchStateList = new ArrayList<SearchState>();
    	
    	if ( row - 1 != -1 ) {
        	if ( col - 1 != -1 ) {
        		int[][] newLayout = this.copyLayout();
        		newLayout[row][col] = newLayout[row - 1][col - 1];
        		newLayout[row - 1][col - 1] = 0;
        		puzStateList.add(new EpuzzleState(newLayout));
        	}
        	if ( col + 1 != 3 ) {
        		int[][] newLayout = this.copyLayout();
        		newLayout[row][col] = newLayout[row - 1][col + 1];
        		newLayout[row - 1][col + 1] = 0;
        		puzStateList.add(new EpuzzleState(newLayout));
        	}
    	}
    	
    	if ( row + 1 != 3 ) {
        	if ( col - 1 != -1 ) {
        		int[][] newLayout = this.copyLayout();
        		newLayout[row][col] = newLayout[row + 1][col - 1];
        		newLayout[row + 1][col - 1] = 0;
        		puzStateList.add(new EpuzzleState(newLayout));
        	}
        	if ( col + 1 != 3 ) {
        		int[][] newLayout = this.copyLayout();
        		newLayout[row][col] = newLayout[row + 1][col + 1];
        		newLayout[row + 1][col + 1] = 0;
        		puzStateList.add(new EpuzzleState(newLayout));	
        	}
    	}
    	
    	for (EpuzzleState state: puzStateList) {
    		puzSearchStateList.add(state);
    	}
    		
    	return puzSearchStateList;
    }

    /**
    * sameState: is this state identical to a given one?
    */
    public boolean sameState(SearchState n2) {
    	int[][] n2layout = ((EpuzzleState)n2).getPuzzleLayout();
    	//compare number in all positions
    	for(int i = 0; i <= 3; i++) {
    		for (int j = 0; j <= 3; j++) {
    			if (this.puzzleLayout[i][j] != n2layout[i][j]) { return false;}
    		}
    	}
    	return true;
    }
    
    public int[][] copyLayout(){
		int[][] tempLayout = new int[this.puzzleLayout.length][];
		for( int i = 0; i < this.puzzleLayout.length; i++) {
			tempLayout[i] = puzzleLayout[i].clone();
		}
		return tempLayout;
    }
	
    public String toString() {
    	String output = "";
    	for(int[] row: this.getPuzzleLayout()) {
    		output = output + "+-+-+-+\n|";
    		for(int col: row) {
    			output = output + col + "|";
    		}
    		output = output + "\n";
    	}
    	output = output + "+-+-+-+";
    	return output;
    }
}

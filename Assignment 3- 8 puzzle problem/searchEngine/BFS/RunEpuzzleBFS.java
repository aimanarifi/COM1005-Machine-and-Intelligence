
public class RunEpuzzleBFS {
	public static void main(String[] arg) {
			
		//Specify seed and diff
		int seed = 1;
		int difficulty = 6;
		
		//Search execution
		EpuzzGen puzz = new EpuzzGen(seed);
		
		int[][] puzzleStartingLayout = puzz.puzzGen(difficulty);
		EpuzzleState startingState = new EpuzzleState(puzzleStartingLayout);
		EpuzzleSearch searcher = new EpuzzleSearch( puzzleStartingLayout, puzz.tar);
		
		//Print output
		System.out.print(searcher.runSearch(startingState, "breadthFirst"));
  }
}

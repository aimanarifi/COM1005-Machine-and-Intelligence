public class RunEpuzzleAStar {
	
	public static void main(String[] arg) {
			
		//Specify seed and diff
		int seed = 1;
		int difficulty = 6;
		String remCostCalcMethod = "manhattan";
		
		//Search execution
		EpuzzGen puzz = new EpuzzGen(seed);
		
		int[][] puzzleStartingLayout = puzz.puzzGen(difficulty);
		EpuzzleSearch searcher = new EpuzzleSearch( puzzleStartingLayout, puzz.tar, puzz, remCostCalcMethod);
		EpuzzleState startingState = new EpuzzleState(puzzleStartingLayout, searcher);
		
		//Print output
		System.out.print(searcher.runSearch(startingState, "AStar"));
	}
	
}


public class EpuzzleSearch extends Search {
	
	private int[][] puzzleLayout;
	private int[][] target = puzzleStarter.tar;
	
	//Constructor(s)
	public EpuzzleSearch(int[][] startingLayout, int[][] target) {
		puzzleLayout = startingLayout;
		this.target = target;
	}
	
	//Accessor(s)
	public int[][] getPuzzleLayout() {
		return puzzleLayout;
	}
	
	public int[][] getTarget() {
		return target;
	}
}

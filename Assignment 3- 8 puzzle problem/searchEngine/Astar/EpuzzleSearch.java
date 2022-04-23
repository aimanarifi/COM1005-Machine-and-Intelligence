public class EpuzzleSearch extends Search {
	
	private int[][] puzzleLayout;
	private int[][] target;
	private EpuzzGen puzzleGen;
	private String remCostCalcMethod;
	
	//Constructor(s)
	public EpuzzleSearch(int[][] startingLayout, int[][] target, EpuzzGen puzzG, String m) {
		puzzleLayout = startingLayout;
		this.target = target;
		puzzleGen = puzzG;
		remCostCalcMethod = m;
	}
	
	//Accessor(s)
	public int[][] getPuzzleLayout() {
		return puzzleLayout;
	}
	
	public int[][] getTarget() {
		return target;
	}
	
	public EpuzzGen getPuzzGen() {
		return puzzleGen;
	}
	
	public String getRemCostCalcMethod() {
		return remCostCalcMethod;
	}
	
}

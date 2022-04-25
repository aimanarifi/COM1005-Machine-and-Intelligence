public class EpuzzleSearch extends Search {
	
	private int[][] puzzleLayout;
	private int[][] target;
	private EpuzzGen puzzGen;
	private String remCostCalcMethod;
	
	//Constructor(s)
	public EpuzzleSearch(int[][] startingLayout, int[][] target, EpuzzGen puzzGen, String m) {
		puzzleLayout = startingLayout;
		this.target = target;
		this.puzzGen = puzzGen;
		remCostCalcMethod = m;
	}
	
	//Accessor(s)
	public int[][] getPuzzleLayout() {
		return puzzleLayout;
	}
	
	public int[][] getTarget() {
		return target;
	}
	
	public String getRemCostCalcMethod() {
		return remCostCalcMethod;
	}
	
}

import java.util.Random;

public class EpuzzleSearch extends Search {
	
	private EpuzzGen puzzleStarter;
	private EpuzzleState puzzleState;
	private int[][] puzzleLayout;
	private int[][] target = puzzleStarter.tar;
	private int difficulty = 0;
	
	//Constructor(s)
	public EpuzzleSearch() {
		Random rand = new Random();
		while (difficulty < 6) {
			difficulty = rand.nextInt(12);
		}
		
		puzzleStarter = new EpuzzGen();
		puzzleLayout = puzzleStarter.puzzGen(difficulty);
	}
	
	public EpuzzleSearch(int seed) {
		Random rand = new Random();
		while (difficulty < 6) {
			difficulty = rand.nextInt(12);
		}
		puzzleStarter = new EpuzzGen(seed);
		puzzleLayout = puzzleStarter.puzzGen(difficulty);
	}
	
	//Accessor(s)
	public int[][] getTarget() {
		return target;
	}
	
	public EpuzzleState getPuzzleState(){
		return puzzleState;
	}
	
	public int[][] getPuzzleLayout(){
		return getPuzzleState().getPuzzleLayout();
	}
}

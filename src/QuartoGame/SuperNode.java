package QuartoGame;

import java.util.ArrayList;

public class SuperNode {
	private Board gameState;
	private boolean isMax;
	private ArrayList<SuperNode> children;
	private boolean isLeaf;
	
	public SuperNode(Board gameState, boolean isMax){
		this.gameState = gameState;
		this.isMax = isMax;
	}
	
	public Piece getPiece(int depth){
		return null;
	}
	
	public int getValue(int depth){
		return 0;
	}
}

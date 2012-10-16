package QuartoGame;

import java.util.Scanner;

public abstract class Player {
	public enum PlayerType{RANDOM, NOVICE, HUMAN, MINIMAX3, MINIMAX4};
	private long timeSpendt;
	protected PlayerType playerType;
	protected int playerID;
	
	public Player(PlayerType pType, int id){
		this.playerType = pType;
		this.playerID = id;
	}
	
	public int getPlayerID() {
		return playerID;
	}
	
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	
	public long getTimeSpent(){
		return timeSpendt;
	}
	
	public Piece doPickPiece(Board board, Scanner scanner, boolean doMiniMax){
		long clockStart = System.currentTimeMillis();
		Piece piece = pickPiece(board, scanner, doMiniMax);
		timeSpendt += System.currentTimeMillis() - clockStart;
		return piece;
	}
	
	public void doPlacePiece(Board board, Piece piece, Scanner scanner, boolean doMiniMax, boolean wrongPick){
		long clockStart = System.currentTimeMillis();
		placePiece(board, piece, scanner, doMiniMax, wrongPick);
		timeSpendt += System.currentTimeMillis() - clockStart;
	}
	
	protected abstract Piece pickPiece(Board board, Scanner scanner, boolean doMiniMax);
	protected abstract void placePiece(Board board, Piece piece, Scanner scanner, boolean doMiniMax, boolean wrongPick);
}

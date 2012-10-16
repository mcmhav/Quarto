package QuartoGame;

import java.util.Scanner;

public class SuperPlayer extends Player{

	public SuperPlayer(PlayerType pType, int id) {
		super(pType, id);
	}

	@Override
	protected Piece pickPiece(Board board, Scanner scanner, boolean doMiniMax) {
		
		switch (playerType) {
		case RANDOM:
			return randomPickPiece(board, scanner, doMiniMax);
		case NOVICE:
			return novicePickPiece(board, scanner, doMiniMax);
		case MINIMAX3:
			return minmaxPickPiece(board, scanner, doMiniMax);
		case HUMAN:
			return humanPickPiece(board, scanner, doMiniMax);
		}
		return null;
	}
	
	@Override
	protected void placePiece(Board board, Piece piece, Scanner scanner,
			boolean doMiniMax, boolean wrongPick) {
		
		switch (playerType) {
		case RANDOM:
			randomPlacePiece(board, piece, scanner, doMiniMax, wrongPick);
		case NOVICE:
			novicePlacePiece(board, piece, scanner, doMiniMax, wrongPick);
		case MINIMAX3:
			minmaxPlacePiece(board, piece, scanner, doMiniMax, wrongPick);
		case HUMAN:
			humanPlacePiece(board, piece, scanner, doMiniMax, wrongPick);
		}
		
	}
	
	private Piece randomPickPiece(Board board, Scanner scanner, boolean doMiniMax){
		return board.getRemainingPieces().get((int) Math.floor(Math.random() * board.getRemainingPieces().size()));
	}
	
	private Piece novicePickPiece(Board board, Scanner scanner, boolean doMiniMax){
		
		return null;
	}
	
	private Piece minmaxPickPiece(Board board, Scanner scanner, boolean doMiniMax){
		return null;
	}
	
	private Piece humanPickPiece(Board board, Scanner scanner, boolean doMiniMax){
		return null;
	}
	
	private void randomPlacePiece(Board board, Piece piece, Scanner scanner,
			boolean doMiniMax, boolean wrongPick) {
		int place = board.getFreePlaces().get((int) Math.floor(Math.random() * board.getFreePlaces().size()));
		board.placePiece(place, piece);
	}
	
	private void novicePlacePiece(Board board, Piece piece, Scanner scanner,
			boolean doMiniMax, boolean wrongPick) {
		
	}
	
	private void minmaxPlacePiece(Board board, Piece piece, Scanner scanner,
			boolean doMiniMax, boolean wrongPick) {
		
	}
	
	private void humanPlacePiece(Board board, Piece piece, Scanner scanner,
			boolean doMiniMax, boolean wrongPick) {
		
	}
}

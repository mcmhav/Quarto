package QuartoGame;

import java.util.ArrayList;


public class Node2 {

	private Board board;
	private Piece givenPiece;
	private Piece pickedPiece;
	private int placementIndex;
	private int value;
	private boolean max;
	private ArrayList<Node2> children;
	private Node2 parent;
	private boolean terminal;
	private boolean root;
	
	public Node2(Board board, boolean maxOrMin, Node2 parent, Piece given, boolean root, int placement){
		this.board = board;
		this.value = 0;
		this.max = maxOrMin;
		this.children = new ArrayList<Node2>();
		this.parent = parent;
		this.terminal = false;
		this.givenPiece = given;
		this.pickedPiece = null;
		this.root = root;
		this.placementIndex = placement;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public double getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isMax() {
		return max;
	}

	public void setMax(boolean max) {
		this.max = max;
	}

	public ArrayList<Node2> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Node2> children) {
		this.children = children;
	}

	public Node2 getParent() {
		return parent;
	}

	public void setParent(Node2 parent) {
		this.parent = parent;
	}
	
	
	public int evaluateNode(){
		if(!isMax() && this.board.checkForWinner(false)){
			this.setValue(100);
		}
		else if(isMax() && this.board.checkForWinner(false)){
			this.setValue(-100);
		}
		else{
			this.setValue(0);
		}
		return this.value;
	}

	public boolean isTerminal() {
		return this.terminal;
	}

	public void setTerminal() {
		if(this.board.checkForWinner(false) || this.board.getFreePlaces().size()==0){
			this.terminal = true;
		}
	}

	public Piece getPickedPiece() {
		return pickedPiece;
	}

	public void setPickedPiece(Piece pickedPiece) {
		this.pickedPiece = pickedPiece;
	}

	public Piece getGivenPiece() {
		return givenPiece;
	}

	public void setGivenPiece(Piece givenPiece) {
		this.givenPiece = givenPiece;
	}

	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}
	
	public int alphabetaprun(int depth, int min, int max){
		this.setTerminal();

		if(depth == 0 || this.isTerminal()){

			return this.evaluateNode();

		}
		else{

			if(this.isMax()){

				int value = min;

				int size = this.board.getFreePlaces().size();

				for (int i = 0; i < size; i++) {

					Board newBoard = new Board();
					newBoard.setBoard(this.board.getBoard());
					newBoard.setPieces(this.board.getPieces());

					int placementIndex = newBoard.getFreePlaces().get(i);	
					ArrayList<Piece> rem = new ArrayList<Piece>();
					rem.addAll(newBoard.getRemainingPieces());
					newBoard.placePiece(newBoard.getFreePlaces().get(i), this.getGivenPiece());

					for(Piece p: rem){

						Node2 newNode = new Node2(newBoard, false, this, p, false, placementIndex);
						newNode.setPickedPiece(p);
						this.getChildren().add(newNode);
						int tempVal = newNode.alphabetaprun(depth-1, value, max);
						if(tempVal > value){
							value = tempVal;
							this.setValue(value);

						}
						if(value >= max){
							return value;
						}
					}
				}
				return value;
			}
			else{
				int value = max;

				int size = this.board.getFreePlaces().size();

				for (int i = 0; i < size; i++) {

					Board newBoard = new Board();
					newBoard.setBoard(this.board.getBoard());
					newBoard.setPieces(this.board.getPieces());

					int placementIndex = newBoard.getFreePlaces().get(i);

					ArrayList<Piece> rem = new ArrayList<Piece>();
					rem.addAll(newBoard.getRemainingPieces());
					newBoard.placePiece(newBoard.getFreePlaces().get(i), this.getGivenPiece());

					for(Piece p: rem){
						Node2 newNode = new Node2(newBoard, true, this, p, false, placementIndex);
						newNode.setPickedPiece(p);
						this.getChildren().add(newNode);
						int tempVal = newNode.alphabetaprun(depth-1, min, value);
						if(tempVal < value){
							value = tempVal;
							this.setValue(value);

						}
						if(value <= min){

							return value;
						}
					}
				}
				return value;
			}
		}
	}

	public int getPlacementIndex() {
		return placementIndex;
	}

	public void setPlacementIndex(int placementIndex) {
		this.placementIndex = placementIndex;
	}
	
}

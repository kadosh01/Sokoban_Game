package levelLoader;


public class Player{
	public int _x;
	public int _y;
	private Cell[][] board;
	
	public Player(int x,int y, Cell[][] board){
		this._x=x;
		this._y=y;
		this.board= board;
	}
	
	public void setLocation(int x, int y){
		this._x=x;
		this._y=y;
	}
		
	public void move(Cell destination){
		board[_x][_y].set_hasPlayer(false);
		setLocation(destination._x, destination._y);
		board[destination._x][destination._y].set_hasPlayer(true);
	}
	
	public void push(Cell playerd, Cell boxd){
		board[_x][_y].set_hasPlayer(false);
		setLocation(playerd._x, playerd._y);
		board[playerd._x][playerd._y].set_hasPlayer(true);
		board[playerd._x][playerd._y].set_hasBox(false);
		board[boxd._x][boxd._y].set_hasBox(true);		
	}
	public void undo(Cell playerd, Cell boxd,Cell floor){
		board[_x][_y].set_hasPlayer(false);
		setLocation(playerd._x, playerd._y);
		board[playerd._x][playerd._y].set_hasPlayer(true);
		board[floor._x][floor._y].set_hasBox(false);
		board[boxd._x][boxd._y].set_hasBox(true);
	}
}

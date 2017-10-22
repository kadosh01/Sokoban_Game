package levelLoader;

public class Box {
	public int x;
	public int y;
	
	
	public Box(int x, int y){
		this.x=x;
		this.y=y;
		
	}

	
	public boolean canMove(Cell[][] board, int next_x, int next_y){
		if(board[next_x][next_y].isEmptyFloor()){
			board[next_x][next_y].set_hasBox(true);
			board[x][y].set_hasBox(false);
			return true;
		}
		return false;
	}
}

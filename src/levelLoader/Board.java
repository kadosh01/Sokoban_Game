package levelLoader;


import java.util.HashMap;
import java.util.Stack;



public class Board {
	
	public Cell[][] board;
	public Player player;
	public int steps=0;
	public boolean push_R=false;
	public boolean push_L=false;
	public boolean up=false;
	public boolean down=false;
	public boolean w_r=false;
	public boolean w_l=false;
	public Stack<HashMap<String, int[]>> und=new Stack<>();
	
	
	public Board(Cell[][] board) {
		this.board=board;
		if(board[0][0]!=null){
		for(int i=0; i<board.length; i++)
			for(int j=0; j<board[i].length; j++){
				if(board[i][j].hasPlayer()){
					player= new Player(i, j, board);
				}	
			}
		}
	}
	
	
	public void move(String action){
		switch(action){
		case "UP":
		{
			int[] p=new int[2];
			int[] b=new int[4];
			HashMap<String, int[]> hp =new HashMap<>();
			HashMap<String, int[]> hb =new HashMap<>();
			
			if((player._x-1>=0 & player._y< board[player._x].length) && board[player._x-1][player._y].isEmptyFloor()){
				player.move(board[player._x-1][player._y]);
				steps++;
				motionset("up");
				p[0]=player._x+1;p[1]=player._y;
				hp.put("move", p);
				und.push(hp);
				
				return;
			}
			
			if((player._x-1>= 0 & player._y< board[player._x].length) && board[player._x-1][player._y].hasBox())
				if(player._x-2>=0 && board[player._x-2][player._y].isEmptyFloor()){
					player.push(board[player._x-1][player._y], board[player._x-2][player._y]);
					steps++;
					motionset("up");
					p[0]=player._x+1;p[1]=player._y; b[0]=player._x; b[1]=player._y;b[2]=player._x-1;b[3]=player._y;
					hp.put("move", p);
					hb.put("push", b);
					und.push(hp);
					und.push(hb);
				}
		
		}
		break;
		case "DOWN":
		{
			int[] p=new int[2];
			int[] b=new int[4];
			HashMap<String, int[]> hp =new HashMap<>();
			HashMap<String, int[]> hb =new HashMap<>();
			if((player._x+1<board.length && player._y< board[player._x].length) && board[player._x+1][player._y].isEmptyFloor()){
				player.move(board[player._x+1][player._y]);
				steps++;
				motionset("down");
				p[0]=player._x-1;p[1]=player._y;
				hp.put("move", p);
				und.push(hp);
				return;
			}
			
			if((player._x+1<board.length && player._y< board[player._x].length) && board[player._x+1][player._y].hasBox())
				if(player._x+2>=0 && board[player._x+2][player._y].isEmptyFloor()){
					player.push(board[player._x+1][player._y], board[player._x+2][player._y]);
					steps++;
					motionset("down");
					p[0]=player._x-1;p[1]=player._y; b[0]=player._x; b[1]=player._y;b[2]=player._x+1;b[3]=player._y;
					hp.put("move", p);
					hb.put("push", b);
					und.push(hp);
					und.push(hb);
				}
				
		}
		break;
		case "RIGHT":
		{
			int[] p=new int[2];
			int[] b=new int[4];
			HashMap<String, int[]> hp =new HashMap<>();
			HashMap<String, int[]> hb =new HashMap<>();
			if((player._x< board.length && player._y+1< board[player._x].length) && board[player._x][player._y+1].isEmptyFloor()){
				player.move(board[player._x][player._y+1]);
				steps++;
				motionset("w_r");
				p[0]=player._x;p[1]=player._y-1;
				hp.put("move", p);
				und.push(hp);
				return;
			}
			
			if((player._x<board.length && player._y+1< board[player._x].length) && board[player._x][player._y+1].hasBox())
				if(player._y+2< board[player._y].length && board[player._x][player._y+2].isEmptyFloor()){
					player.push(board[player._x][player._y+1], board[player._x][player._y+2]);
					steps++;
					motionset("push_R");
					p[0]=player._x;p[1]=player._y-1; b[0]=player._x; b[1]=player._y;b[2]=player._x;b[3]=player._y+1;
					hp.put("move", p);
					hb.put("push", b);
					und.push(hp);
					und.push(hb);
					
				}
		}
		break;
		case "LEFT":
		{
			int[] p=new int[2];
			int[] b=new int[4];
			HashMap<String, int[]> hp =new HashMap<>();
			HashMap<String, int[]> hb =new HashMap<>();
				if((player._x< board.length && player._y-1>=0) & board[player._x][player._y-1].isEmptyFloor()){
				player.move(board[player._x][player._y-1]);
				steps++;
				motionset("w_l");
				p[0]=player._x;p[1]=player._y+1;
				hp.put("move", p);
				und.push(hp);
				return;
			}
			
			if((player._x< board.length && player._y-1>0) & board[player._x][player._y-1].hasBox())
				if(player._y-2>0 && board[player._x][player._y-2].isEmptyFloor()){
					player.push(board[player._x][player._y-1], board[player._x][player._y-2]);
					steps++;
					motionset("push_L");
					p[0]=player._x;p[1]=player._y+1; b[0]=player._x; b[1]=player._y;b[2]=player._x;b[3]=player._y-1;
					hp.put("move", p);
					hb.put("push", b);
					und.push(hp);
					und.push(hb);
				}
		}
		break;
		}
	}
	
	public boolean isOver(){
		boolean win=true;
		for(int i=0; i<board.length & win; i++)
			for(int j=0; j<board[i].length & win; j++)
				if(board[i][j].hasBox() & !board[i][j].isStorage()){
					win=false;
				}
		
		return win;
		
	}
	
	public String toString(){
		String s="";
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(board[i][j].hasBox() & board[i][j].isStorage()) s=s+'*';
				if(board[i][j].hasBox()& !board[i][j].isStorage()) s=s+'$';
				if (board[i][j].hasPlayer()) s=s+'@';
				if(board[i][j].isEmptyFloor())s=s+' ';
				if(!board[i][j].isFloor()) s=s+'#';
	}
			s=s+"\n";
		}
		return s;
	}
	
	public void motionset(String s){
		push_R=false;
		push_L=false;
		up=false;
		down=false;
		w_r=false;
		w_l=false;
		
		switch (s) {
		case "push_R":
			push_R=true;
			break;

		case "push_L":
			push_L=true;
			break;
		
		case "up":
			up=true;
			break;
		case "down":
			down=true;
			break;
		case "w_r":
			w_r=true;
			break;
		case "w_l":
			w_l=true;
			break;
		}
	}
	
	public void cloneBoard(Cell[][] other){
		for(int i=0; i<other.length; i++)
			for(int j=0; j<other[i].length; j++)
				board[i][j]= other[i][j].clone();				
	}
}

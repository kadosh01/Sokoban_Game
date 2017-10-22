package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import java.awt.event.ActionEvent;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

import levelLoader.*;

import javax.swing.SwingConstants;


import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.Dialog.ModalExclusionType;


public class Game extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel buttonPane;
	private Board game;
	private Cell[][] board;
	private boolean over;
	private JLabel score;
	private JMenuBar menuBar;
	private JButton btnUndo;
	private JButton btnMenu;
	
	


	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Game(int level) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 797, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JButton restart= new JButton("restart");
		restart.setFont(new Font("Super Mario 256", Font.PLAIN, 11));
		restart.setBackground(SystemColor.menu);
		menuBar.add(restart);
		
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							Game replay = new Game(level);
							replay.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		btnUndo = new JButton("undo");
		btnUndo.setFont(new Font("Super Mario 256", Font.PLAIN, 11));
		btnUndo.setBackground(SystemColor.menu);
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!game.und.isEmpty()){
				HashMap<String, int[]> a=game.und.pop();
				if(a.containsKey("move")){
					int[] p=a.get("move");
					game.player.move(game.board[p[0]][p[1]]);
				}
				else{ if(a.containsKey("push")){
					HashMap<String, int[]> b=game.und.pop();
					int[] p=a.get("push");
					if(b.containsKey("move")){
						int[] bp=b.get("move");
						game.player.undo(game.board[bp[0]][bp[1]], game.board[p[0]][p[1]], game.board[p[2]][p[3]]);
					}
					
				}
				}
				}
				if(game.steps>0){
					game.steps--;
					score.setText(""+game.steps);
				}
				contentPane.removeAll();
				fill();
				revalidate();
				repaint();
				contentPane.setFocusable(true);
				contentPane.requestFocusInWindow();
			}
		});
		menuBar.add(btnUndo);
		
		btnMenu = new JButton("menu");
		btnMenu.setFont(new Font("Super Mario 256", Font.PLAIN, 11));
		btnMenu.setBackground(SystemColor.menu);
		menuBar.add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							Menu frame= new Menu();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		// set layout
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout(0, 0));
		
		buttonPane= new JPanel();
		container.add(buttonPane,BorderLayout.NORTH);
		container.add(contentPane,BorderLayout.CENTER);
		
		setContentPane(container);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonPane.setBackground(SystemColor.control);
		
		Label label = new Label("                ");
		label.setEnabled(false);
		label.setFocusable(false);
		label.setFocusTraversalKeysEnabled(false);
		buttonPane.add(label);
		
		JLabel lblSteps = new JLabel("X");
		lblSteps.setIcon(new ImageIcon(Game.class.getResource("/resources/mario/steps.png")));
		lblSteps.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblSteps.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSteps.setFocusable(false);
		lblSteps.setFocusTraversalKeysEnabled(false);
		lblSteps.setInheritsPopupMenu(false);
		lblSteps.setVerifyInputWhenFocusTarget(false);
		lblSteps.setRequestFocusEnabled(false);
		lblSteps.setForeground(Color.BLACK);
		lblSteps.setFont(new Font("Super Mario 256", Font.BOLD, 17));
		lblSteps.setBackground(SystemColor.menu);
		buttonPane.add(lblSteps);
		
		score = new JLabel("0");
		score.setFont(new Font("Super Mario 256", Font.BOLD, 17));
		buttonPane.add(score);
		
		LevelLoader levelloader= new LevelLoader();
		try {
			if (!levelloader.load("levels.txt"))
				throw new IllegalArgumentException("can't load levels");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		over=false;
		board= levelloader.get(level);
		game= new Board(board);
		int rows= 1;
		int cols= 1;
		if(rows<board.length)
			rows= board.length;
		if(cols<board[0].length)
			cols= board[0].length;
		contentPane.setLayout(new GridLayout(rows, cols));
		fill();
		contentPane.setFocusable(true);
		contentPane.requestFocusInWindow();
		// keylistener
		contentPane.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
            	if(!over){
         		   switch (e.getKeyCode()) {
         	        case 37://LEFT KEY
         	            game.move("LEFT");
         	            score.setText(""+game.steps);
         	            contentPane.removeAll();
         	            fill();
         	            revalidate();
         	            repaint();         	            
         	            gameover();
         	            break;
         	        case 38://UP KEY
         	            game.move("UP");
        	            score.setText(""+game.steps);
         	            contentPane.removeAll();
         	            fill();
         	            revalidate();
         	            repaint();
         	            gameover();
         	            break;
         	        case 39://RIGHT KEY
         	            game.move("RIGHT");
         	      
        	            score.setText(""+game.steps);
         	            contentPane.removeAll();
         	            fill();
         	            revalidate();
         	            repaint();
         	            gameover();
         	            break;
         	        case 40://DOWN KEY
         	            game.move("DOWN");
        	            score.setText(""+game.steps);
         	            contentPane.removeAll();
         	            fill();
         	            revalidate();
         	            repaint();
         	            gameover();
         	            break;
                     default: break; 
                 }
         		}
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }
        });
		pack();
		
		
	}
	// fill the board
	private void fill(){
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				
					if(board[i][j].hasBox() & !board[i][j].isStorage()) contentPane.add(new JLabel(new ImageIcon(Menu.class.getResource("/resources/mario/box.png"))));
					else if(board[i][j].hasPlayer() && !game.push_R & !game.push_L & !game.up & !game.down & !game.w_l & !game.w_r) contentPane.add(new JLabel(new ImageIcon(Menu.class.getResource("/resources/mario/PL.png"))));
					else if(board[i][j].hasPlayer() && game.push_R & !game.push_L & !game.up & !game.down & !game.w_l & !game.w_r) contentPane.add(new JLabel(new ImageIcon(Menu.class.getResource("/resources/mario/PUSHR.png"))));
					else if(board[i][j].hasPlayer() && !game.push_R & game.push_L & !game.up & !game.down & !game.w_l & !game.w_r) contentPane.add(new JLabel(new ImageIcon(Menu.class.getResource("/resources/mario/PUSHL.png"))));
					else if(board[i][j].hasPlayer() && !game.push_R & !game.push_L & game.up & !game.down & !game.w_l & !game.w_r) contentPane.add(new JLabel(new ImageIcon(Menu.class.getResource("/resources/mario/PB.png"))));
					else if(board[i][j].hasPlayer() && !game.push_R & !game.push_L & !game.up & game.down & !game.w_l & !game.w_r) contentPane.add(new JLabel(new ImageIcon(Menu.class.getResource("/resources/mario/PD.png"))));
					else if(board[i][j].hasPlayer() && !game.push_R & !game.push_L & !game.up & !game.down & game.w_l & !game.w_r) contentPane.add(new JLabel(new ImageIcon(Menu.class.getResource("/resources/mario/PL.png"))));
					else if(board[i][j].hasPlayer() && !game.push_R & !game.push_L & !game.up & !game.down & !game.w_l & game.w_r) contentPane.add(new JLabel(new ImageIcon(Menu.class.getResource("/resources/mario/PR.png"))));
					else if(board[i][j].isStorage() & !board[i][j].hasBox())contentPane.add(new JLabel(new ImageIcon(Menu.class.getResource("/resources/mario/storage.png"))));
					else if(board[i][j].isStorage() & board[i][j].hasBox())contentPane.add(new JLabel(new ImageIcon(Menu.class.getResource("/resources/mario/boxonstorage.png"))));
					else if(!board[i][j].hasBox() && !board[i][j].hasPlayer() && !board[i][j].isStorage() & !board[i][j].isFloor())
						contentPane.add(new JLabel(new ImageIcon(Menu.class.getResource("/resources/mario/wall.png"))));
				
					else if(board[i][j].isEmptyFloor()) contentPane.add(new JLabel(new ImageIcon(Menu.class.getResource("/resources/mario/floor.png"))));
			}
		}
			pack();
			
	}
	
	public void gameover(){
		if(game.isOver()){
			over=true;
			Icon a=new ImageIcon(Menu.class.getResource("/resources/mario/win.png"));
			//JOptionPane.showMessageDialog(null, "Well Done!!"+"\n"+"You win this game with "+game.steps+" steps.");
			JOptionPane.showMessageDialog(null, "Well Done!!"+"\n"+"You win this game with "+game.steps+" steps.", "Win", JOptionPane.INFORMATION_MESSAGE, a);
			Menu menu=new Menu();
			setVisible(false);
			menu.setVisible(true);
		}
	}
	
	
}

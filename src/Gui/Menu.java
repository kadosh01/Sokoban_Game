package Gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.awt.Toolkit;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Sokoban by yosi & ava");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/resources/mario/steps.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(487, 150, 797, 580);
		setSize(800, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// level button
		JButton levels = new JButton("", new ImageIcon(Menu.class.getResource("/resources/levels.png")));
		levels.setBorderPainted(false);
		levels.setContentAreaFilled(false);
		levels.setBackground(new Color(255, 255, 204));
		levels.setIconTextGap(1);
		
		levels.setBounds(174, 204, 122, 59);
		contentPane.add(levels);
		
		levels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Levels frame = new Levels();
							frame.setVisible(true);
							setVisible(false);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		// new game button
		JButton newgame = new JButton("", new ImageIcon(Menu.class.getResource("/resources/game.png")));
		newgame.setBorderPainted(false);
		newgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							contentPane.setVisible(false);
							setVisible(false);
							Game frame = new Game(0);
							frame.setVisible(true);
							//JFrame a= new JFrame("");
							//a.setVisible(true);
							
							//frame.getFocusableWindowState();
							
							
						} catch (Exception e) {
							System.out.println(e.getMessage());;
						}
					}
				});
			}
		});
		newgame.setIconTextGap(0);
		newgame.setContentAreaFilled(false);
		newgame.setBounds(174, 146, 122, 59);
		contentPane.add(newgame);
		//Background photo
		JLabel backround = new JLabel("");
		backround.setBounds(5, 5, 774, 516);
		backround.setFocusable(false);
		backround.setIcon(new ImageIcon(Menu.class.getResource("/resources/mario/background.png")));
		contentPane.add(backround);
		
	
	}
	
	
}

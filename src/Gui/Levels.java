package Gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class Levels extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public boolean close=false;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Levels() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(487, 150, 797, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton level2 = new JButton("");
		level2.setBorderPainted(false);
		level2.setIgnoreRepaint(true);
		level2.setHorizontalTextPosition(SwingConstants.CENTER);
		level2.setContentAreaFilled(false);
		level2.setIcon(new ImageIcon(Levels.class.getResource("/resources/mario/2.png")));
		level2.setBounds(303, 109, 70, 73);
		level2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							Game frame = new Game(1);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			
		});
		contentPane.add(level2);
		
		JButton level3 = new JButton("");
		level3.setBorderPainted(false);
		level3.setIcon(new ImageIcon(Levels.class.getResource("/resources/mario/3.png")));
		level3.setContentAreaFilled(false);
		level3.setBounds(426, 109, 70, 73);
		level3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							Game frame = new Game(2);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			
		});
		contentPane.add(level3);
		contentPane.add(level3);
		
		JButton level4 = new JButton("");
		level4.setBorderPainted(false);
		level4.setIcon(new ImageIcon(Levels.class.getResource("/resources/mario/4.png")));
		level4.setContentAreaFilled(false);
		level4.setBounds(552, 109, 70, 73);
		level4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							Game frame = new Game(3);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			
		});
		contentPane.add(level4);
		contentPane.add(level4);
		
		JButton level5 = new JButton("");
		level5.setBorderPainted(false);
		level5.setIcon(new ImageIcon(Levels.class.getResource("/resources/mario/5.png")));
		level5.setContentAreaFilled(false);
		level5.setBounds(193, 232, 70, 73);
		level5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							Game frame = new Game(4);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			
		});
		contentPane.add(level5);
		contentPane.add(level5);
		
		JButton level6 = new JButton("");
		level6.setBorderPainted(false);
		level6.setIcon(new ImageIcon(Levels.class.getResource("/resources/mario/6.png")));
		level6.setContentAreaFilled(false);
		level6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							Game frame = new Game(5);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			
		});
		level6.setBounds(307, 232, 70, 73);
		contentPane.add(level6);
		
		JButton level7 = new JButton("");
		level7.setBorderPainted(false);
		level7.setIcon(new ImageIcon(Levels.class.getResource("/resources/mario/7.png")));
		level7.setContentAreaFilled(false);
		level7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							Game frame = new Game(6);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			
		});
		level7.setBounds(424, 232, 70, 73);
		contentPane.add(level7);
		
		JButton level8 = new JButton("");
		level8.setBorderPainted(false);
		level8.setIcon(new ImageIcon(Levels.class.getResource("/resources/mario/8.png")));
		level8.setContentAreaFilled(false);
		level8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							Game frame = new Game(7);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			
		});
		level8.setBounds(539, 232, 70, 73);
		contentPane.add(level8);
		
		JButton level1 = new JButton("");
		level1.setBorderPainted(false);
		level1.setContentAreaFilled(false);
		level1.setIcon(new ImageIcon(Levels.class.getResource("/resources/mario/1.png")));
		level1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							Game frame = new Game(0);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		level1.setBounds(181, 109, 70, 73);
		contentPane.add(level1);
		
		JButton home = new JButton("");
		home.setBorderPainted(false);
		home.setIcon(new ImageIcon(Levels.class.getResource("/resources/mario/HOME.png")));
		home.setContentAreaFilled(false);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							Menu frame = new Menu();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}			
		});
		home.setBounds(359, 368, 77, 73);
		contentPane.add(home);
		
		// set background
		JLabel backround = new JLabel("");
		backround.setBounds(5, 5, 774, 516);
		backround.setFocusable(false);
		backround.setIcon(new ImageIcon(Menu.class.getResource("/resources/mario/levelwin.png")));
		contentPane.add(backround);
	}
}

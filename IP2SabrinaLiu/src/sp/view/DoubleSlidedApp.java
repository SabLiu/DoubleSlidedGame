package sp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sp.controller.FlipController;
import sp.controller.ResetController;
import sp.model.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class DoubleSlidedApp extends JFrame {

	private JPanel contentPane;
	PuzzleView panel;
	Model model; 
	int moves; 
	JLabel loseLabel; 
	JLabel winLabel;
	JLabel movesLabel;

	public PuzzleView getDrawingPanel() {return panel;}
	
	
	
	public DoubleSlidedApp(Model m) {
		this.model = m;
		setTitle("Double Slided App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		panel = new PuzzleView(m);
		
		//make controllers testable 
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new FlipController(DoubleSlidedApp.this, m).flipTileToEmpty(e);
				DoubleSlidedApp.this.repaint();
			}
		});
		
		//create pretty labels
		JLabel lblMoveCounter = new JLabel("Move Counter: ");
		lblMoveCounter.setFont(new Font("Calibri", Font.PLAIN, 30));
		
		JLabel numMovesLabel = new JLabel("0");
		numMovesLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
		this.movesLabel = numMovesLabel;
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new ResetController(this, model));
		btnReset.setFont(new Font("Calibri", Font.PLAIN, 45));
		
		//show to humiliate losers
		JLabel loseLabel = new JLabel("YOU LOSE!");
		loseLabel.setVisible(false);
		loseLabel.setFont(new Font("Calibri", Font.PLAIN, 50));
		this.loseLabel = loseLabel;
		//show to congratulate winners
		JLabel winLabel = new JLabel("YOU WIN!");
		winLabel.setVisible(false);
		winLabel.setFont(new Font("Calibri", Font.PLAIN, 50));
		this.winLabel = winLabel;
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addComponent(lblMoveCounter, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numMovesLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(loseLabel, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
						.addComponent(winLabel, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
					.addGap(70))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(loseLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(winLabel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(numMovesLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblMoveCounter, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	// called when a tile is clicked. 
	public void updateMovesCounter() { 
		moves++; 
		movesLabel.setText(" " + moves);
	}
	
	//called from FlipController when conditions are met
	public void showLoseLabel () {
		loseLabel.setVisible(true);
	}
	public void showWinLabel () {
		winLabel.setVisible(true);
	}
	// called from ResetController to reset fields and labels
	public void reset() {
		this.moves = 0;
		movesLabel.setText(" " + moves);
		loseLabel.setVisible(false);
		winLabel.setVisible(false);
		this.repaint();
	}
}

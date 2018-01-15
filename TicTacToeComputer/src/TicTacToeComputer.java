//Franklin Smith, Project 2, Part 2, HUMAN VS COMPUTER

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import javax.swing.*;
import java.util.Random;

public class TicTacToeComputer extends JPanel{
	static int num = 0;
	private JButton[] buttons = new JButton[9];
		
		
	public TicTacToeComputer() {
		setLayout(new GridLayout(3,3));
		startGame();
	}
		
	public TicTacToeComputer(TicTacToeComputer obj) {
		startGame();
	}

		
	public void startGame() {
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setSize(10, 10);
			buttons[i].setBackground(Color.yellow);
			buttons[i].setText(" ");
			buttons[i].addActionListener(new Listener());
			add(buttons[i]);
		
				
		}

			
	}
		
	public class Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg) {
			JButton clicked = (JButton)arg.getSource();
			int idx = new Random().nextInt(buttons.length);
			Font myFont = new Font("Serif",Font.BOLD,70);
			clicked.setFont(myFont);
			if(num % 2 == 0 && clicked.getText().equals(" ") && checkStatus() == false){
			    clicked.setText("X");
			    clicked.setForeground(Color.blue);
				num++;
			}
			else if(num % 2 == 1 && checkStatus() == false){
				while(buttons[idx].getText() != " ") {
					idx = new Random().nextInt(buttons.length);
				}
				buttons[idx].setFont(myFont);
				buttons[idx].setText("O");
				buttons[idx].setForeground(Color.red);
				num++;
				
			}
			else if(num == 9 && checkStatus()== false) {
				JOptionPane.showMessageDialog(null, "TIE, PREPARE TO FIGHT AGAIN!");
			}

	
				
				
	}
			

	}
	
		
	public boolean checkStatus() {
	    //horizontal check
		if(buttons[0].getText().equals(buttons[1].getText()) &&
		   buttons[1].getText().equals(buttons[2].getText()) &&
		   buttons[0].getText() != " " ) {
		    if(buttons[0].getText().equals("X"))
		    	JOptionPane.showMessageDialog(null, "X WINS!!!");
		    else
		    	JOptionPane.showMessageDialog(null, "O WINS!!!");
		    return true;  
		}
		else if(buttons[3].getText().equals(buttons[4].getText()) &&
		 	    buttons[4].getText().equals(buttons[5].getText()) &&
		 	    buttons[3].getText() != " " ) {
		    if(buttons[3].getText().equals("X"))
		    	JOptionPane.showMessageDialog(null, "X WINS!!!");
		    else
		    	JOptionPane.showMessageDialog(null, "O WINS!!!");
		    return true;
		}
		else if(buttons[6].getText().equals(buttons[7].getText()) &&
		 	    buttons[7].getText().equals(buttons[8].getText()) &&
		 	    buttons[6].getText() != " " ) {
		    if(buttons[6].getText().equals("X"))
		    	JOptionPane.showMessageDialog(null, "X WINS!!!");
		    else
		    	JOptionPane.showMessageDialog(null, "O WINS!!!");
		    return true;
		}
		//vertical check
		else if(buttons[0].getText().equals(buttons[3].getText()) &&
		 	    buttons[3].getText().equals(buttons[6].getText()) &&
		 	    buttons[0].getText() != " " ) {
		    if(buttons[0].getText().equals("X"))
		    	JOptionPane.showMessageDialog(null, "X WINS!!!");
		    else
		    	JOptionPane.showMessageDialog(null, "O WINS!!!");
		    return true;
		}
		else if(buttons[1].getText().equals(buttons[4].getText()) &&
		 	    buttons[4].getText().equals(buttons[7].getText()) &&
		 	    buttons[1].getText() != " " ) {
		    if(buttons[1].getText().equals("X"))
		    	JOptionPane.showMessageDialog(null, "X WINS!!!");
		    else
		    	JOptionPane.showMessageDialog(null, "O WINS!!!");
		    return true;
		}
		else if(buttons[2].getText().equals(buttons[5].getText()) &&
		 	    buttons[5].getText().equals(buttons[8].getText()) &&
		 	    buttons[2].getText() != " " ) {
		    if(buttons[2].getText().equals("X"))
		    	JOptionPane.showMessageDialog(null, "X WINS!!!");
		    else
		    	JOptionPane.showMessageDialog(null, "O WINS!!!");
		    return true;
		}
		//diagnol check
		else if(buttons[0].getText().equals(buttons[4].getText()) &&
		 	    buttons[4].getText().equals(buttons[8].getText()) &&
		 	    buttons[0].getText() != " " ) {
		    if(buttons[0].getText().equals("X"))
		    	JOptionPane.showMessageDialog(null, "X WINS!!!");
		    else
		    	JOptionPane.showMessageDialog(null, "O WINS!!!");
		    return true;
		}
		else if(buttons[2].getText().equals(buttons[4].getText()) &&
		 	    buttons[4].getText().equals(buttons[6].getText()) &&
		 	    buttons[2].getText() != " " ) {
		    if(buttons[2].getText().equals("X"))
		    	JOptionPane.showMessageDialog(null, "X WINS!!!");
		    else
		    	JOptionPane.showMessageDialog(null, "O WINS!!!");
		    return true;
		}
		else
		    return false;
		    
	}
		
	public void clearGame() {
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setText("");
				
		}
	}
		
	public static void main(String[] args) {
		JFrame jf = new JFrame("Tic Tac Toe HUMAN VS COMPUTER!");
		Container pane = jf.getContentPane();
		TicTacToeComputer game = new TicTacToeComputer();
		JPanel rest = new JPanel();
		JButton restart = new JButton("RESTART");
		JTextArea playByPlay = new JTextArea("GOOD LUCK!",5,6);
		playByPlay.append("IF 3 X'S IN A ROW, X WINS!");
		playByPlay.append("IF 3 O'S IN A ROW, O WINS!");
		rest.add(restart);
		rest.add(playByPlay);
		pane.add(game,BorderLayout.CENTER);
		pane.add(rest,BorderLayout.SOUTH);
		pane.add(playByPlay,BorderLayout.EAST);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setSize(900,900);
		jf.setVisible(true);
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				game.clearGame();
					
				
			}
			
	    });
		TicTacToeComputer newGame = new TicTacToeComputer(game);
	}
}






package GUI;
import Compiler.Scanner;
import Data.Functions;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * the main window of dbms
 * @author Google, Stack Overflow, Ullman, et al and Alberto
 *
 */
public class Window extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

    private int window_height = 600;
    private int window_width = 600;
    JTextArea output = new JTextArea();
    JTextArea input = new JTextArea();
    JButton run = new JButton("Run");
	
    /**
     * the constructor
     */
	public Window(){
		super("Mini DBMS");
		Container window = getContentPane();
		window.setLayout(null);
		input.setEditable(true);
		output.setEditable(false);
		
		JScrollPane top = new JScrollPane(output,
                 ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 		JScrollPane bottom = new JScrollPane(input,
                 ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 		run.addActionListener(this);
 		
 		top.setBounds(20, 20, 550, 400);
 		bottom.setBounds(20, 450, 500, 100);
 		run.setBounds(530, 500, 60, 20);
 		window.add(top);
 		window.add(bottom);
 		window.add(run);
 		
 		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 		this.setBounds(50, 50, window_width, window_height);
 		this.setResizable(false);
 		this.setVisible(true);
 		
 		Functions.setWindow(this);
        
	
	}

	/**
	 * action listener
	 */
	public void actionPerformed(ActionEvent arg0) {
		String inText = input.getText();
		input.setText("");
		String outText = output.getText()+"\n"+inText;
		output.setText(outText);
		
		Scanner.scan(inText);
		
		//input.removeAll();
	}
	/**
	 * print message on the text plane
	 * @param s
	 */
	public void print(String s){
		String out = output.getText()+"\n"+s;
		output.setText(out);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window w = new Window();
	}

}

//CP1340 Lab 5 GUI and Swing
//Student: Cade Molloy - 20175269
//Due Date: November 29th, 2022
//Prof: Branko Cirovic

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CConverter extends JFrame implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == calculate) {
			
			String Amount = cobalt.getText().toString();
			double amount = Double.parseDouble(Amount);
			
			String Years = years.getText().toString();
			int years = Integer.parseInt(Years);
			
			for(int n=1; n<=years; n++) 
				amount -= (amount * 0.12); 	
                result.setText("" + amount);
	
		} else if(event.getSource() == exit) 
			dispose();
	}
	
	public CConverter() {
	
		cobaltLabel = new JLabel();
		cobaltLabel.setSize(200, 20);
		cobaltLabel.setLocation(100, 10);
		cobaltLabel.setText("Amount of Cobalt 60:");
		
		cobalt = new JTextField();
		cobalt.setSize(100, 20);
		cobalt.setLocation(300, 10);
		 
		yearsLabel = new JLabel();
		yearsLabel.setSize(200, 20);
		yearsLabel.setLocation(100, 50);
		yearsLabel.setText("Number of Years:");
		
		years = new JTextField();
		years .setSize(100, 20);
		years .setLocation(300, 50);
		
		calculate = new JButton();
		calculate.setLocation(150, 90);
		calculate.setSize(100, 20);
		calculate.addActionListener(this);
		calculate.setText("Calculate");
		
		exit = new JButton();
		exit.setSize(100, 20);
		exit.setLocation(270, 90);
		exit.addActionListener(this);
		exit.setText("Exit");
		
		resultLabel = new JLabel();
		resultLabel.setSize(100, 20);
		resultLabel.setLocation(100, 140);
		resultLabel.setText("Cobalt Left:");
		
		result = new JLabel("");
		result.setSize(100, 40);
		result.setLocation(200, 130);
		
		container = getContentPane();
		container.setLayout(null);
		container.add(cobaltLabel);
		container.add(cobalt);
		container.add(yearsLabel);
		container.add(years);
		container.add(calculate);
		container.add(exit);
		container.add(resultLabel);
		container.add(result);
		
		setTitle("Cobalt Converter");
		setBounds(100, 100, 500, 220);
		setVisible(true);
	}
	
	private JLabel cobaltLabel;
	private JTextField cobalt;
	private JLabel result;
	private JLabel resultLabel;
	private JLabel yearsLabel;
	private JTextField years;
	private JButton calculate;
	private JButton exit;
	private Container container;
	
	public static void main(String[] args) throws Exception{
		CConverter cobaltConverter = new CConverter();
	}
}
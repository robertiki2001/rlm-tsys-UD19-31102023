package Ej1;

import java.awt.event.*;
import javax.swing.*;

public class ej1 extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label;
	private JTextField textField;
	private JButton button;
	
	public ej1 (){

		setTitle("Saludador");
		setBounds(600,450,400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		label = new JLabel("Escribe un nombre para saludar");
		label.setBounds(100,30,200,20);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(50,80,300,30);
		contentPane.add(textField);
		
		button = new JButton("Saludar!");
		button.setBounds(120,140,130,40);
		contentPane.add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hola "+textField.getText()+"!");
			}
		});	
		setVisible(true);
	}
	
}

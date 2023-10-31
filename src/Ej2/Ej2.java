package Ej2;
import javax.swing.*;
import java.awt.event.*;

public class Ej2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JComboBox<String> peliculasComboBox;
    private JButton button;
    private JLabel label1;
    private JLabel label2;

    public Ej2() {

    	setTitle("Películas");
        setBounds(600, 450, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        label1 = new JLabel("Escribe el título de una película");
        label1.setBounds(43, 53, 200, 20);
        contentPane.add(label1);

        textField = new JTextField();
        textField.setBounds(45, 91, 146, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        button = new JButton("Añadir película");
        button.setBounds(43, 135, 136, 23);
        contentPane.add(button);

        label2 = new JLabel("Películas");
        label2.setBounds(260, 53, 86, 20);
        contentPane.add(label2);

        peliculasComboBox = new JComboBox<>();
        peliculasComboBox.setBounds(232, 90, 114, 22);
        contentPane.add(peliculasComboBox);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nuevaPelicula = textField.getText();
                if (!nuevaPelicula.isEmpty()) {
                    peliculasComboBox.addItem(nuevaPelicula);
                    textField.setText("");
                }
            }
        });

        setVisible(true);
    }
}

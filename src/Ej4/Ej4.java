package Ej4;

import java.awt.event.*;
import javax.swing.*;

public class Ej4 extends JFrame{
	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel label1;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonSuma;
    private JButton buttonResta;
    private JButton buttonMultiplicacion;
    private JButton buttonDivision;
    private JButton buttonIgual;
    private JButton buttonBorrar;
    private JTextField operando1;
    private JTextField operando2;
    private JTextField calculo;
    private JTextField resultado;
    private String ultimoSigno = "";
    private boolean ingresandoOperando1 = true; 


	
	public Ej4() {
	    
	    setTitle("Calculadora");
        setBounds(600, 450, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        label1 = new JLabel("MINI CALCULADORA");
        label1.setBounds(116, 12, 200, 20);
        contentPane.add(label1);
        
        button1 = new JButton("1");
        button1.setBounds(76, 42, 77, 58);
        contentPane.add(button1);
        
        button2 = new JButton("2");
        button2.setBounds(152, 42, 77, 58);
        contentPane.add(button2);
        
        button3 = new JButton("3");
        button3.setBounds(228, 42, 77, 58);
        contentPane.add(button3);
        
        button4 = new JButton("4");
        button4.setBounds(76, 99, 77, 58);
        contentPane.add(button4);
        
        button5 = new JButton("5");
        button5.setBounds(152, 99, 77, 58);
        contentPane.add(button5);
        
        button6 = new JButton("6");
        button6.setBounds(228, 99, 77, 58);
        contentPane.add(button6);        
       
        button7 = new JButton("7");
        button7.setBounds(76, 156, 77, 58);
        contentPane.add(button7);
        
        button8 = new JButton("8");
        button8.setBounds(152, 156, 77, 58);
        contentPane.add(button8);
               
        button9 = new JButton("9");
        button9.setBounds(228, 156, 77, 58);
        contentPane.add(button9);
        
        button0 = new JButton("0");
        button0.setBounds(0, 42, 77, 58);
        contentPane.add(button0);
        
        buttonMultiplicacion = new JButton("x");
        buttonMultiplicacion.setBounds(304, 82, 58, 44);
        contentPane.add(buttonMultiplicacion);
        
        buttonResta = new JButton("-");
        buttonResta.setBounds(304, 127, 58, 44);
        contentPane.add(buttonResta);
        
        buttonSuma = new JButton("+");
        buttonSuma.setBounds(304, 170, 58, 44);
        contentPane.add(buttonSuma);
        
        buttonDivision = new JButton("÷");
        buttonDivision.setBounds(304, 44, 58, 44);
        contentPane.add(buttonDivision);
        
        buttonBorrar = new JButton("⌫");
        buttonBorrar.setBounds(304, 0, 58, 44);
        contentPane.add(buttonBorrar);
        
        buttonIgual = new JButton("=");
        buttonIgual.setBounds(304, 217, 58, 44);
        contentPane.add(buttonIgual);
        
        operando1 = new JTextField();
        operando1.setColumns(10);
        operando1.setBounds(26, 229, 51, 20);
        contentPane.add(operando1);
        
        calculo = new JTextField();
        calculo.setColumns(10);
        calculo.setBounds(86, 229, 51, 20);
        contentPane.add(calculo);
        
        resultado = new JTextField();
        resultado.setColumns(10);
        resultado.setBounds(208, 229, 51, 20);
        contentPane.add(resultado);
        
        operando2 = new JTextField();
        operando2.setColumns(10);
        operando2.setBounds(147, 229, 51, 20);
        contentPane.add(operando2);
       
        // ActionListener para botones numericos
        ActionListener numButtonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                String buttonText = clickedButton.getText();
                if (resultado.getText().isEmpty()) {
                    String currentText = ingresandoOperando1 ? operando1.getText() : operando2.getText();
                    if (ingresandoOperando1) {
                        operando1.setText(currentText + buttonText);
                    } else {
                        operando2.setText(currentText + buttonText);
                    }
                } else {
                    // Si ya hay un resultado, comienza un nuevo calculo
                    operando1.setText(buttonText);
                    operando2.setText("");
                    resultado.setText("");
                    ingresandoOperando1 = true;
                }

            }
        };

        // ActionListener para los signos de calculo
        ActionListener operacionButtonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                String operationText = clickedButton.getText();
                String currentCalculoText = calculo.getText();
                if (!currentCalculoText.equals(operationText)) {
                    // Agrega el signo solo si no está presente
                    calculo.setText(currentCalculoText + operationText);
                }
                ultimoSigno = operationText;
                ingresandoOperando1 = false; // Cambia al ingreso del segundo operando
            }
        };

        // ActionListener para el boton de igual
        buttonIgual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtiene los operandos y el operador
                double num1 = Double.parseDouble(operando1.getText());
                double num2 = Double.parseDouble(operando2.getText());
                String operador = ultimoSigno;

                // Realiza la operación correspondiente
                double resultadoCalculo = 0.0;
                if (operador.equals("+")) {
                    resultadoCalculo = num1 + num2;
                } else if (operador.equals("-")) {
                    resultadoCalculo = num1 - num2;
                } else if (operador.equals("x")) {
                    resultadoCalculo = num1 * num2;
                } else if (operador.equals("÷")) {
                    if (num2 != 0) {
                        resultadoCalculo = num1 / num2;
                    } else {
                        resultado.setText("Error: División por cero");
                        return;
                    }
                }

                // Muestra el resultado en el campo de 'resultado'
                resultado.setText(Double.toString(resultadoCalculo));
                // Limpia los campos para un nuevo cálculo
                operando1.setText("");
                operando2.setText("");
                calculo.setText("");
                ingresandoOperando1 = true;
            }
        });
        // ActionListener para borrar ultimo numero de los textField
        buttonBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ingresandoOperando1) {
                    // Si estamos ingresando el operando1, borra el ultimo digito de operando1
                    String operando1Text = operando1.getText();
                    if (!operando1Text.isEmpty()) {
                        operando1.setText(operando1Text.substring(0, operando1Text.length() - 1));
                    }
                } else {
                    // Si estamos ingresando el operando2, borra el ultimo digito de operando2
                    String operando2Text = operando2.getText();
                    if (!operando2Text.isEmpty()) {
                        operando2.setText(operando2Text.substring(0, operando2Text.length() - 1));
                    }
                }
            }
        });

        
        // ActionListener para botones numéricos
        button0.addActionListener(numButtonListener);
        button1.addActionListener(numButtonListener);
        button2.addActionListener(numButtonListener);
        button3.addActionListener(numButtonListener);
        button4.addActionListener(numButtonListener);
        button5.addActionListener(numButtonListener);
        button6.addActionListener(numButtonListener);
        button7.addActionListener(numButtonListener);
        button8.addActionListener(numButtonListener);
        button9.addActionListener(numButtonListener);
        
        // ActionListener para botones de operación
        buttonSuma.addActionListener(operacionButtonListener);
        buttonResta.addActionListener(operacionButtonListener);
        buttonMultiplicacion.addActionListener(operacionButtonListener);
        buttonDivision.addActionListener(operacionButtonListener);

        
        setVisible(true);
        
	}
}

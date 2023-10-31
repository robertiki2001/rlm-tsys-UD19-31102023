package Ej3;

import java.awt.event.*;
import javax.swing.*;

public class Ej3 extends JFrame{
	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton button;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JRadioButton rbutton1;
    private JRadioButton rbutton2;
    private JRadioButton rbutton3;
    private JCheckBox ckBox1;
    private JCheckBox ckBox2;
    private JCheckBox ckBox3;
    private JSlider slider1;
    
    private JLabel resultLabel;
    private String sistemaOperativoSeleccionado;
    private String especialidadesSeleccionadas;
    private int horasDedicadas;

    
    public Ej3() {
    	
    	setTitle("Encuesta");
        setBounds(600, 450, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        label1 = new JLabel("Elige un sistema operativo");
        label1.setBounds(10, 11, 200, 20);
        contentPane.add(label1);
        
        rbutton1 = new JRadioButton("Windows");
        rbutton1.setBounds(20, 38, 109, 23);
        contentPane.add(rbutton1);
        
        rbutton2 = new JRadioButton("Mac");
        rbutton2.setBounds(20, 64, 109, 23);
        contentPane.add(rbutton2);
        
        rbutton3 = new JRadioButton("Linux");
        rbutton3.setBounds(20, 90, 109, 23);
        contentPane.add(rbutton3);
        
        ButtonGroup tipo = new ButtonGroup();
        tipo.add(rbutton1);
        tipo.add(rbutton2);
        tipo.add(rbutton3);
        
        label2 = new JLabel("Elige tu especialidad");
        label2.setBounds(178, 14, 181, 14);
        contentPane.add(label2);
        
        ckBox1 = new JCheckBox("Programación");
        ckBox1.setBounds(169, 38, 150, 23);
        contentPane.add(ckBox1);
        
        ckBox2 = new JCheckBox("Diseño gráfico");
        ckBox2.setBounds(169, 64, 150, 23);
        contentPane.add(ckBox2);
        
        ckBox3 = new JCheckBox("Administración");
        ckBox3.setBounds(169, 90, 150, 23);
        contentPane.add(ckBox3);
        
        slider1 = new JSlider(JSlider.HORIZONTAL, 0, 10, 0); 
        slider1.setBounds(66, 162, 200, 26);
        contentPane.add(slider1);
        
        label3 = new JLabel("Horas dedicadas al ordenador (entre 0 i 10)");
        label3.setBounds(68, 135, 251, 20);
        contentPane.add(label3);
        
        button = new JButton("Enviar formulario");
        button.setBounds(87, 211, 176, 26);
        contentPane.add(button);
        
        resultLabel = new JLabel("");
        resultLabel.setBounds(10, 240, 380, 20);
        contentPane.add(resultLabel);
        
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				if (rbutton1.isSelected()) {
		            sistemaOperativoSeleccionado = "Windows";
		        } else if (rbutton2.isSelected()) {
		            sistemaOperativoSeleccionado = "Mac";
		        } else if (rbutton3.isSelected()) {
		            sistemaOperativoSeleccionado = "Linux";
		        }

		        especialidadesSeleccionadas = "";
		        
		        if (ckBox1.isSelected()) {
		            especialidadesSeleccionadas += "Programación ";
		        }
		        if (ckBox2.isSelected()) {
		            especialidadesSeleccionadas += "Diseño gráfico ";
		        }
		        if (ckBox3.isSelected()) {
		            especialidadesSeleccionadas += "Administración ";
		        }

		        horasDedicadas = slider1.getValue();

		        String resultados = "Sistema operativo: " + sistemaOperativoSeleccionado+"\n"
		                + "Especialidades: " + especialidadesSeleccionadas+"\n"
		                + "Horas dedicadas: " + horasDedicadas;
		    
 			 JOptionPane.showMessageDialog(null,resultados);
 			 
			}
		});		

        setVisible(true);
	
    }
}

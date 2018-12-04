package view;

import java.awt.EventQueue;

import java.awt.TextField;




import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

import controller.Controller;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;

import controller.Controller;
import model.Model;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import contract.IView;
import contract.IController;
import contract.IModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class DesignedFrame extends JFrame  implements IView{

	
	private static final long serialVersionUID = 1L;
	
	/** Initalisation de nos frames et différentes Label et Panel */
	
	public JFrame frame;
	public JFrame frameCourbe;
	private JTextField textField;
	Controller controller;
	IModel model;
	JLabel lblNewLabel_1, label, label_1, label_2, label_3, label_4, label_6;
	JTextPane textPane;
	Button button;
	
	
	/** Constructeur de la classe, qui nous permet d'initialiser notre interface*/
	
	public DesignedFrame(IModel model) {
		this.model = model;
		this.setTitle("Pimp My Fridge");
		this.initialize();
}


	/** Initialisation des éléments de notre interface */
	
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pimp My Fridge");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tele-Marines", Font.PLAIN, 21));
		lblNewLabel.setBounds(145, 13, 274, 54);
		panel.add(lblNewLabel);
		
		
		JLabel lblIntrfaceDeControle = new JLabel("Int\u00E9rface de controle du frigo");
		lblIntrfaceDeControle.setForeground(Color.BLACK);
		lblIntrfaceDeControle.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblIntrfaceDeControle.setBounds(119, 58, 400, 50);
		panel.add(lblIntrfaceDeControle);
		
		JLabel label_3 = new JLabel("Point de rosée : ");
		label_3.setForeground(Color.WHITE);

		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(12, 367, 149, 50);
		panel.add(label_3);
		
		JLabel lblTempratureExtrieure = new JLabel("Temp\u00E9rature ext\u00E9rieure :");
		lblTempratureExtrieure.setForeground(Color.WHITE);
		lblTempratureExtrieure.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTempratureExtrieure.setBounds(12, 175, 149, 50);
		panel.add(lblTempratureExtrieure);
		
		JLabel lblTempratureIntrieure = new JLabel("Temp\u00E9rature int\u00E9rieure :");
		lblTempratureIntrieure.setForeground(Color.WHITE);
		lblTempratureIntrieure.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTempratureIntrieure.setBounds(12, 241, 149, 50);
		panel.add(lblTempratureIntrieure);
		
		JLabel lblStatut = new JLabel("Statut :");
		lblStatut.setForeground(Color.WHITE);
		lblStatut.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStatut.setBounds(12, 493, 149, 50);
		panel.add(lblStatut);
		
		label_4 = new JLabel("\"\"");
		label_4.setForeground(Color.CYAN);

		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		label_4.setBounds(224, 493, 295, 50);
		panel.add(label_4);		
		
		
		JLabel lblTauxDhumidit = new JLabel("Taux d'humidit\u00E9 : ");
		lblTauxDhumidit.setForeground(Color.WHITE);

		lblTauxDhumidit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTauxDhumidit.setBounds(12, 304, 149, 50);
		panel.add(lblTauxDhumidit);
		
		JLabel lblCondensation = new JLabel("Condensation : ");
		lblCondensation.setForeground(Color.WHITE);
		lblCondensation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCondensation.setBounds(12, 556, 149, 50);
		panel.add(lblCondensation);
		
		label_6 = new JLabel("\"\"");
		label_6.setForeground(Color.CYAN);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(224, 556, 295, 50);
		panel.add(label_6);
		
		JLabel lblConsigne = new JLabel("Consigne :");
		lblConsigne.setForeground(Color.WHITE);
		lblConsigne.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConsigne.setBounds(12, 430, 149, 50);
		panel.add(lblConsigne);
		
		button = new Button("+");
		button.setActionCommand("label_2 + 1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRealConsigne((model.getRealConsigne() + 1 ));
	        	textPane.setText(String.valueOf((Integer.valueOf(model.getRealConsigne()))));
	        	textPane.repaint();
			}
		});
		button.setBounds(184, 431, 24, 24);
		panel.add(button);
		
		Button button_1 = new Button("-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRealConsigne((model.getRealConsigne() - 1 ));
				
	        	textPane.setText(String.valueOf((Integer.valueOf(model.getRealConsigne()))));
	        	textPane.repaint();

			}
		});
		button_1.setBounds(184, 461, 24, 24);
		panel.add(button_1);
		
		lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setBounds(224, 192, 295, 16);
		panel.add(lblNewLabel_1);
		
		label = new JLabel("0");
		label.setForeground(Color.CYAN);
		label.setBounds(224, 258, 295, 16);
		panel.add(label);
		
		label_1 = new JLabel("0");
		label_1.setForeground(Color.CYAN);
		label_1.setBounds(224, 321, 143, 16);
		panel.add(label_1);
		
		label_2 = new JLabel("0");
		label_2.setForeground(Color.CYAN);
		label_2.setBounds(224, 384, 295, 16);
		panel.add(label_2);
		
		textPane = new JTextPane();
		textPane.setBounds(224, 447, 39, 22);
		panel.add(textPane);
		textPane.setText(String.valueOf(model.getRealConsigne()));
		
		
	}
	


	/** Fonction qui nous permet d'update en temps réel nos valeurs au sein de l'interface */

	public void update() {
		
		lblNewLabel_1.setText(( model.getTmpInt()+" °C       " + ((Float.valueOf(model.getTmpInt()))*1.8+32) + " °F"));		
	    label.setText((model.getTmpExt()+" °C       " + ((Float.valueOf(model.getTmpExt()))*1.8+32) + " °F"));
		label_1.setText((model.gethumidite()+" %       "));
		label_2.setText((model.getpointDeRosee()+" °C       " + ((Float.valueOf(model.getpointDeRosee()))*1.8+32) + " °F"));
		label_4.setText(model.getStatut());
		label_6.setText((model.getConden()));
		lblNewLabel_1.repaint();
		label.repaint();
		label_1.repaint();
		label_2.repaint();			
		label_4.repaint();
		label_6.repaint();
		
		
		}
	

	 
			}

package controller;
import contract.IController;

import contract.IDrawable;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

import javax.swing.text.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.*;

import gnu.io.*;

import model.Model;
import view.DesignedCourbe;
import view.DesignedFrame;
import view.GUIHelper;
import contract.IModel;
import contract.IView;



public class Controller implements IController{

	
	/** La vue */

    private IView view;
	
	/** Le model */
    
	private IModel model;
	
	/** Le Graphique */

	IDrawable drawable;
	
	
	/** Constructeur du controller. */

	public Controller(IModel model, IView view)  throws InterruptedException {
	
		this.model = model;
		this.view = view;
		
		
		/** Initialisation de la connexion à l'arduino */
		
		SerialPortEvent oEvent;
		CommPortIdentifier serialPortId;
		Enumeration enumComm;
		enumComm = CommPortIdentifier.getPortIdentifiers();
		enumComm = CommPortIdentifier.getPortIdentifiers();


		Thread t = new Thread() {
			public void run() {
				// the following line will keep this app alive for 1000 seconds,
				// waiting for events to occur and responding to them (printing incoming
				// messages to console).
				try {
					Thread.sleep(1000000);
				} catch (InterruptedException ie) {
				}
			}
		};
		t.start();
		while (enumComm.hasMoreElements()) {
			serialPortId = (CommPortIdentifier) enumComm.nextElement();
			if (serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				System.out.println(serialPortId.getName());
			}
		}

		System.out.println("Port opened successfully");
		
			}
	
	
	
	/** Fonction Play qui nous permet d'initialiser le model et la vue et nous permet de l'update **/
	
	public void play() throws InterruptedException {
		
		/** Récupération des premières valeurs envoyées */
		
		this.model.initialize();	  
		TimeUnit.SECONDS.sleep(1);
		model.close();
		
		/** Initialisation de la courbe */
		
	    DesignedCourbe jc = new DesignedCourbe();
		jc.setBackground(Color.WHITE);
		jc.setPreferredSize(new Dimension(800,400)); 
		GUIHelper.showOnFrame(jc,"test");
		while(true)
			{
			this.model.initialize();	           //Ouverture de la connexion à l'arduino et récupération des valeurs
			TimeUnit.SECONDS.sleep(1);

			model.close();            // Fermeture de la connexion à l'arduino
			view.update();           // Update de la vue
			
			System.out.println(model.getTmpExt()+ "\t"  + model.gethumidite() + "\t" +model.getTmpInt()+ "\t" +model.getTmpIntRond());
			jc.setX(model.getTmpIntRond());      // Update de la courbe
			jc.setI( (jc.getI()+ 1));         // Update de la courbe
			System.out.println(model.getRealConsigne());
			writeConsigne();        // Ecriture de la consigne au sein de l'arduino
			jc.refresh();      // Refresh de la courbe
			}
			}


	/** Getter de notre model */

	@Override
	public IModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	/** Getter de notre vue */
	
	public IView getView() {
		return view;
	}
	
	/** Fonction qui nous permet de récupérer notre nouvelle consigne au sein de l'arduino**/
	
	public  void writeConsigne() {
		 
		final String chemin = "C:\\Users\\nicol\\Desktop\\Projet_PMF\\Param.h";
		final File fichier1 = new File(chemin);
		fichier1.delete();
       final File fichier =new File(chemin); 
       try {
           fichier.toPath();
           // creation d'un writer (un écrivain)
           final FileWriter writer = new FileWriter(fichier);
           try {
               writer.write("#ifndef PARAM_H_INCLUDED \n");
               writer.write("#define PARAM_H_INCLUDED \n \n");
               writer.write("#define consigne ");
               System.out.print("Samit " +model.getRealConsigne());
               writer.write(String.valueOf(model.getRealConsigne()));
               writer.write("\n \n");
               writer.write("#endif");
           } finally {
               // quoiqu'il arrive, on ferme le fichier
               writer.close();
           }
       } catch (Exception e) {
           System.out.println("Impossible de creer le fichier");
       }
   
	}

}

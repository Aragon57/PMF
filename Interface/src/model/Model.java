package model;

import java.util.*;



import contract.IController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;
import controller.Controller;
import view.DesignedFrame;
import contract.IController;
import contract.IView;
import contract.IModel;

public class Model  implements SerialPortEventListener, IModel {

	/** Initialisation de nos différentes variables */
	 
	public String tmpInt = "0";
	private IController controller;
	public	String humidite = "0";
	public String tmpExt = "0";
	public String pointDeRosee = "0";
	public String statut ="";
	public int consigne;
	public int realConsigne = consigne;
	public int tmpIntRond;
	public String conden ="";
	public int tmpExtRond;
		private IModel model;
	private IView view;
	SerialPort serialPort;
	
	
	/** Le port que l'on utilise pour récupérer nos données. */
	
	private static final String PORT_NAMES[] = { "COM8", // Windows
	};

	private BufferedReader input;
	private OutputStream output;
	private static final int TIME_OUT = 2000;
	private static final int DATA_RATE = 9600;


	// change les valeurs


	/** Getter et Setter de nos différentes variables */

	public String getStatut() {
		return statut;
	}
	
	public  String getTmpInt() {
		return tmpInt;
	}

	public void setTmpInt(String tmpInt) {
		this.tmpInt = tmpInt;

	}

	public String getpointDeRosee() {
		return pointDeRosee;
	}

	public void setPointDeRosee(String pointDeRosee) {
		this.pointDeRosee = pointDeRosee;
	}

	
	public String getTmpExt() {
		return tmpExt;
	}

	public void setTmpExt(String tmpExt) {
		this.tmpExt = tmpExt;
	}

	public String gethumidite() {
		return humidite;
	}

	public void sethumidite(String humidite) {
		this.humidite = humidite;

	}
	
	public String getConden() {
		return conden;
	}
	
	public void setConden(String conden) {
		this.conden = conden;
	}	public int getRealConsigne() {
		return realConsigne;
	}

	public void setRealConsigne(int realConsigne) {
		this.realConsigne = realConsigne;
	}

	public int getTmpIntRond() {
		return tmpIntRond;
	}

	public void setTmpIntRond(int tmpIntRond) {
		this.tmpIntRond = tmpIntRond;
	}
	
	public void cons() {
		realConsigne = consigne;
	}
	
	public int getTmpExtRond() {
		return tmpExtRond;
	}

	public void setTmpExtRond(int tmpExtRond) {
		this.tmpExtRond = tmpExtRond;
	}



	
	/** Initialisation de la connexion à l'arduino */
	
	public void initialize() {
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		// First, Find an instance of serial port as set in PORT_NAMES.

		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}
		}

		if (portId == null) {
			System.out.println(" Could not find COM port. ");
			return;
		}

		try {
			serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			// open the streams
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();

			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
	}
	
	/** Fonction qui nous permet de fermer la connexion à l'arduino*/

	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	/** Fonction qui nous permet de récupérer les données envoyées par l'arduino, stocké dans les différentes variables */
	
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine = null;
				if (input.ready()) {
					inputLine = input.readLine();

					String list[] = new String[8];
					list = inputLine.split(";");
					this.tmpInt = (list[0]);
					this.tmpExt = (list[1]);
					this.humidite= (list[2]);
					this.pointDeRosee = (list[3]);
					this.statut = list[4];
					this.consigne = Integer.valueOf(list[5]);
					this.conden = (list[6]);
					this.tmpIntRond = (Integer.valueOf(list[7]));

					close();
				}

			} catch (Exception e) {
				System.err.println(e.toString());

			}
		}
		// Ignore all the other eventTypes, but you should consider the other ones.
	}

	@Override
	public IModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	


	
	

}

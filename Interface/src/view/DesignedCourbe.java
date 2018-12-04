package view;


import java.awt.*;
import javax.swing.*;

import contract.IController;
import contract.IDrawable;
import contract.IModel;

public class DesignedCourbe extends JPanel implements IDrawable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IModel model;
	IController controller;
	int x ;
	int i =0;
	int l = 1;

	

	
	/** Initialisation de la courbe et du plan */
	
	public void paint(Graphics g) {
		
			super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.GRAY);
		g.fillRect(0,0,800,400);
		g.setColor(Color.BLUE);
		g.fillRect(0, 200, 800, 1);
		
		g.setColor(Color.RED);

		int Tab[] = new int[800];
		i = i+1;

		Tab[i] = getX();

		/** Boucle qui nous permet d'afficher chaque valeur de la courbe */
		
		for (i = 0 ; i < l ; i++) {
			
			g.fillRect(i, (100- (Tab[i] )), 10, 1);

		}
		
		
	
		
		
	}
	
	/** Fonction d'update de la courbe en temps réel */
	
	 public void refresh() {
		 l++;
		 i++;
		 this.repaint();
		System.out.println("Resfrsh");
	}

	 
	 /** Getter et setter des coordonnées des points de la courbe */

	 public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

	

}
                
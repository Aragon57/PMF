package main;

import gnu.io.*;



import model.Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Enumeration;

import javax.swing.JFrame;

import controller.Controller;
import view.DesignedCourbe;
import view.DesignedFrame;
import view.GUIHelper;
import contract.IView;
import contract.IModel;
import contract.IController;
import view.DesignedFrame;

public class main {

	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		/** Instanciation du model de la vue et du controller */
		
		final IModel model = new Model();
    	final IView view = new DesignedFrame(model);
        final Controller controller = new Controller(model, view);
    
        /** Appel de la fonction play qui nous permet de lancer notre interface */
         
		controller.play();

	}

}

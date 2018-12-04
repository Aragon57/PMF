package contract;

import contract.IModel;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Lo�c
 * @version 1.0
 * @see IOrderPerformer
 */
public interface IController {
	

	IModel getModel();
	
	IView getView();
	

}

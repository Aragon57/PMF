package contract;

public interface IModel {
	
	IModel getModel();
	String getTmpExt();
	String getTmpInt();
	String gethumidite();
	String getpointDeRosee();
	String getStatut();
	void initialize();
	void close();
	int getRealConsigne();
	void setRealConsigne(int consigne);
	void cons();
	String getConden();
	int getTmpIntRond();
	int getTmpExtRond();
}

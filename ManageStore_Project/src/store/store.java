package store;

/**
 * @author Thomas
 *
 */
/**
 *  Interface entre la classe userIHM1 et la classe DAO StoreDAO
 * Les m�thodes GET et SET permettent de passer les param�tres � la classe
 * Les variables publiques permettent �galement de passer les param�tres 
 * Les m�thodes n'ont pas de param�tres, il faut donc passer les param�tres � la classe avant d'executer les m�thodes
 *
 */



public class store {
	public int StoreId;
	public String StoreName;
	public String StoreLocation;

	
	public int GetStoreId()
	{
		return(StoreId);
	}
	
	public void SetStoreId(int StoreId)
	{

		this.StoreId=StoreId;
	}
	public String GetStoreName()
	{
		return(StoreName);
	}
	
	public void SetStoreName(String StoreName)
	{

		this.StoreName=StoreName;
	}
	
	public String GetStoreLocation()
	{
		return(StoreLocation);
	}
	public void SetStorelocation(String StoreLocation)
	{
		this.StoreLocation=StoreLocation;
	}
	/**
	 *  M�thode permettant cr�er un magasin
	 *  Il faut avoir pr�alablement pass� � la classe les propri�t�s n�cessaires
	 *  SetStoreName (Obligatoire)
	 *  SetStoreLocation
	 */
	public boolean CreateStore() 
	{
		if (StoreName!="" )
		{
			storeDAO storeDAO =new storeDAO();
			return(storeDAO.DAOCreateStore(StoreName,StoreLocation));
		}
		else
		{
			return(false);
		}
	}
	
	/**
	 *  M�thode permettant de mettre � jour un magasin
	 *  Il faut avoir pr�alablement pass� � la classe les propri�t�s n�cessaires
	 *  SetStoreName (Obligatoire)
	 *  StoreName (Obligatire)
	 */
	public boolean UpdateStore() 
	{
		if (StoreName!="" || StoreId>0 )
		{
		storeDAO storeDAO =new storeDAO();
		return(storeDAO.DAOUpdateStore(StoreId,StoreName,StoreLocation));
		}
		else
		{
			return(false);
		}
		
	}
	/**
	 *  M�thode permettant de supprimer un magasin
	 *  Il faut avoir pr�alablement pass� � la classe les propri�t�s n�cessaires
	 *  SetStoreID (Obligatoire)
	 */	
	public boolean DeleteStore() {
		if (StoreId>0 )
		{
			storeDAO storeDAO =new storeDAO();
			return(storeDAO.DAODeleteStore(StoreId));
		}
		else
		{
			return(false);
		}
	}
	
	public Object[][] ListStore() {
		

		Object [][] donnees=new String[10][5];
		storeDAO storeDAO =new storeDAO();
		return(storeDAO.DAOListStore());

	}
}

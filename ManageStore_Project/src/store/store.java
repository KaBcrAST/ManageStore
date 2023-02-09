package store;

/**
 * @author Thomas
 *
 */
/**
 *  Interface entre la classe userIHM1 et la classe DAO StoreDAO
 * Les méthodes GET et SET permettent de passer les paramètres à la classe
 * Les variables publiques permettent également de passer les paramètres 
 * Les méthodes n'ont pas de paramétres, il faut donc passer les paramètres à la classe avant d'executer les méthodes
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
	 *  Méthode permettant créer un magasin
	 *  Il faut avoir préalablement passé à la classe les propriétés nécessaires
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
	 *  Méthode permettant de mettre à jour un magasin
	 *  Il faut avoir préalablement passé à la classe les propriétés nécessaires
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
	 *  Méthode permettant de supprimer un magasin
	 *  Il faut avoir préalablement passé à la classe les propriétés nécessaires
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

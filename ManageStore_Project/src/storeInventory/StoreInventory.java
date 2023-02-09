package storeInventory;

import store.storeDAO;


/**
 *  Interface entre la classe userIHM1 et la classe DAO StoreInventoryDAO
 * Les m�thodes GET et SET permettent de passer les param�tres � la classe
 * Les variables publiques permettent �galement de passer les param�tres 
 * Les m�thodes n'ont pas de param�tres, il faut donc passer les param�tres � la classe avant d'executer les m�thodes
 *
 */
public class StoreInventory {

	public int pisID;
	public String StoreId;
	public int ProductId;
	public int Quantity;
	public String UnitDescription;
	
	public void SetStoreId(String StoreId )
	{
		this.StoreId=StoreId;
	}
	public String GetStoreId()
	{
		return(StoreId);
	}

	public void SetProductId(int ProductId )
	{
		this.ProductId=ProductId;
	}
	public int GetProductId()
	{
		return(ProductId);
	}
	
	public void SetQuantity(int Quantity )
	{
		this.Quantity=Quantity;
	}
	public int GetQuantity()
	{
		return(Quantity);
	}
	
	public void SetUnitDescription(int UnitDescription )
	{
		this.UnitDescription=UnitDescription;
	}
	public int GetUnitDescription()
	{
		return(UnitDescription);
	}
	/**
	 *  M�thode permettant de lister les produits en magasin
	 */
	
	public Object[][] ListProductInStore()
	{

		Object [][] donnees=new String[10][5];
		StoreInventoryDAO StoreInventoryDAO =new StoreInventoryDAO();
		return(StoreInventoryDAO.DAOListProductInStore(StoreId));

	}
	/**
	 *  M�thode permettant de lister les produits qui ne sont pas en magasin
	 */
	public Object[][] ListProductNotInStore() 
	{
		Object [][] donnees=new String[10][5];
		StoreInventoryDAO StoreInventoryDAO =new StoreInventoryDAO();
		return(StoreInventoryDAO.DAOListProductNotInStore(StoreId));

	}
	
	/**
	 *  M�thode permettant d'ajouter un prosuit dans l'inventaire du magasin
	 * 	SetStoreId (Obligatoire)
	 *  SetProductId (Obligatoire)
	 */
	
	public boolean AddProductInStore()
	{
		StoreInventoryDAO storeInventoryDAO =new StoreInventoryDAO();
		storeInventoryDAO.DAOPutProductInStore(StoreId, ProductId);
		return(true);
	}
	/**
	 *  M�thode permettant de supprimer un produit dans l'inventaire du magasin
	 * 	SetStoreId (Obligatoire)
	 *  SetProductId (Obligatoire)
	 */	
	public boolean RemoveProductInStore()
	{
		StoreInventoryDAO storeInventoryDAO =new StoreInventoryDAO();
		storeInventoryDAO.DAORemoveProductInStore(ProductId, StoreId);
		return(true);
	}
	/**
	 *  M�thode permettant de mettre � jour les quantit�s d'un artile dans l'inventaire
	 * 	SetStoreId (Obligatoire)
	 *  SetProductId (Obligatoire)
	 * 	SetProductQuantity (Obligatoire)
	 */	
	
	public boolean UpdateProductQuantityInStore()
	{
		StoreInventoryDAO storeInventoryDAO =new StoreInventoryDAO();
		storeInventoryDAO.DAOUpdateQuantityInStore(StoreId, ProductId, Quantity);
		return(true);

	}
	
	
	

}

package storeInventory;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
/**
 * Classe qui permet d'accéder au requéte SQL à executer
 * Cette classe permet de manipuler les données de la  table storeinventory (create, read, update, delete)
 *
 */
public class StoreInventoryDAO {
	public Connection con;
	
	/**
	 *  Méthode permettant de mettre un produit dans l'inventaire du magasin
	 *  Il faut avoir préalablement passé à la classe les propriétés nécessaires
	 *  SetStoreID
	 *  SetProductID
	 *  SetQuantity
	 */
	public boolean DAOPutProductInStore(String StoreId, int ProductId) 
	{
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		int nbValues=0;
		String values= StoreId +","+ProductId+",0";
		String Query="INSERT INTO productinstore (StoreId,ProductId,Quantity) VALUES(" +values+")";

		nbValues=dao.DAOExecuteQuery(con, Query);
		if (nbValues==1)
				{
					return(true);
				}
		return(false);
	}
	/**
	 *  Méthode permettant de mettre à jour la quantité d'un produit l'inventaire du magasin
	 *  Il faut avoir préalablement passé à la classe les propriétés nécessaires
	 *  SetStoreID
	 *  SetProductID
	 *  SetQuantity
	 */
	
	public boolean DAOUpdateQuantityInStore(String StoreId,int ProductId, int Quantity) 
		{
			dao.DAO dao=new dao.DAO();
			con=dao.DAOconnect();
			int nbValues=0;
			String P0=" WHERE StoreId="+StoreId +" AND ProductId="+ProductId +"";
			String P1=" Quantity="+Quantity;
			String Query="UPDATE productinstore SET "+P1+P0;	
			

			nbValues=dao.DAOExecuteQuery(con, Query);
			if (nbValues==1)
					{
						return(true);
					}
			return(false);
		}

	/**
	 *  Méthode permettant de supprimer un produit de  l'inventaire du magasin
	 *  Il faut avoir préalablement passé à la classe les propriétés nécessaires
	 *  SetStoreID
	 *  SetProductID
	 */
	public boolean DAORemoveProductInStore(int ProductId, String storeID) {
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		int nbValues=0;
		String Query="DELETE FROM productinstore WHERE ProductId="+ProductId+" AND storeID="+storeID;	
		nbValues=dao.DAOExecuteQuery(con, Query);

		if (nbValues==1)
		{
			return(true);
		}
		return(false);
	}
		
	/**
	 *  Méthode permettant de lister les produits de  l'inventaire du magasin
	 *  Il faut avoir préalablement passé à la classe les propriétés nécessaires
	 *  SetStoreID
	 */
	
	public Object[][] DAOListProductInStore(String StoreId ) {
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		ResultSet rs;
		String [][] donnees=new String[101][4];
		
		String Query= 
		"SELECT product.productid, product.productname, quantity,Unitdescription from product, productInStore, store,uniteofmeasure " +
		" WHERE store.storeid=productInStore.storeid "+
		"AND product.productid=productInStore.productid "+
		"AND product.UnitID=uniteofmeasure.UnitID "+
		"AND productInStore.storeid="+StoreId;
		System.out.println(Query);
		rs=dao.DAOSelect(con, Query);
		int i=0;

		try
		{
			while (rs.next())
			
			{
				donnees[i][0]=rs.getString("productid");
				donnees[i][1]=rs.getString("productName");
				donnees[i][2]=rs.getString("quantity");
				donnees[i][3]=rs.getString("Unitdescription");
				i++;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return(donnees);
	}
	/**
	 *  Méthode permettant de lister les produits qui ne sont pas dans  l'inventaire du magasin
	 *  Il faut avoir préalablement passé à la classe les propriétés nécessaires
	 *  SetStoreID
	 *  Cette méthode ne permettra pas de mettre 2 fois le même produit en inventaire
	 *  La clause SQL NOT IN permet de faire cela
	 */	
	public Object[][] DAOListProductNotInStore(String StoreId ) {
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		ResultSet rs;
		String [][] donnees=new String[101][3];
		
		String Query= 
				"SELECT product.productId, product.productname from product"+
				" WHERE product.productId NOT IN "+
				"(SELECT productInStore.ProductId from productInStore WHERE productInStore.storeid=" + StoreId +")";
		
		System.out.println(Query);
		rs=dao.DAOSelect(con, Query);
		int i=0;

		try
		{
			while (rs.next())
			
			{
				donnees[i][0]=rs.getString("productId");
				donnees[i][1]=rs.getString("productName");
				//donnees[i][2]=rs.getString("");
				i++;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return(donnees);
	}


}

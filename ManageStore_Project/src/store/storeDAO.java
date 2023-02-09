package store;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
/**
 * Classe qui permet d'accéder au requéte SQL à executer
 * Cette classe permet de manipuler les données des tables store (create, read, update, delete)
 *
 */
public class storeDAO {
	public Connection con;
	

	/**
	 *  Méthode de création d'un magasin execute nécessite un insert avec les paramètres issus des méthodes get et set de la classe store

	 *  SetStoreName
	 *  SetStoreLocation
	 */ 
	public boolean DAOCreateStore(String StoreName, String StoreLocation) 
	{
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		int nbValues=0;
		String values= "'"+StoreName +"','"+StoreLocation+"'";
		String Query="INSERT INTO store (StoreName,StoreLocation) VALUES(" +values+")";

		nbValues=dao.DAOExecuteQuery(con, Query);
		if (nbValues==1)
				{
					return(true);
				}
		return(false);
	}
	/**
	 *  Méthode de mise à our d'un magasin execute nécessite un update avec les paramètres issus des méthodes get et set de la classe store
	 *  SetStoreID
	 *  SetStoreName
	 *  SetStoreLocation
	 */ 
	
	public boolean DAOUpdateStore(int StoreId,String StoreName, String StoreLocation) 
		{
			dao.DAO dao=new dao.DAO();
			con=dao.DAOconnect();
			int nbValues=0;
			String P0=" WHERE StoreId="+StoreId;
			String P1="StoreName='"+StoreName +"',";
			String P2="StoreLocation='"+StoreLocation +"'";
			String Query="UPDATE store SET "+P1+P2+P0;	
			

			nbValues=dao.DAOExecuteQuery(con, Query);
			if (nbValues==1)
					{
						return(true);
					}
			return(false);
		}
	/**
	 *  Méthode de suppression d'un magasin  un delete avec les paramètres issus des méthodes get et set de la classe store
	 *  SetStoreID
	 */ 
	
	public boolean DAODeleteStore(int StoreId) {
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		int nbValues=0;
		String Query="DELETE FROM store WHERE StoreId="+StoreId;	
		nbValues=dao.DAOExecuteQuery(con, Query);

		if (nbValues==1)
		{
			return(true);
		}
		return(false);
	}
		
	
	public Object[][] DAOListStore() {
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		ResultSet rs;
		String [][] donnees=new String[101][3];
		String Query="SELECT StoreId, StoreName,StoreLocation from store";	

		rs=dao.DAOSelect(con, Query);
		int i=0;

		try
		{
			while (rs.next())
			
			{
				donnees[i][0]=rs.getString("StoreId");
				donnees[i][1]=rs.getString("StoreName");
				donnees[i][2]=rs.getString("StoreLocation");
				i++;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return(donnees);
	}

}
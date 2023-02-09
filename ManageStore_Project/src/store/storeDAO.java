package store;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
/**
 * Classe qui permet d'acc�der au requ�te SQL � executer
 * Cette classe permet de manipuler les donn�es des tables store (create, read, update, delete)
 *
 */
public class storeDAO {
	public Connection con;
	

	/**
	 *  M�thode de cr�ation d'un magasin execute n�cessite un insert avec les param�tres issus des m�thodes get et set de la classe store

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
	 *  M�thode de mise � our d'un magasin execute n�cessite un update avec les param�tres issus des m�thodes get et set de la classe store
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
	 *  M�thode de suppression d'un magasin  un delete avec les param�tres issus des m�thodes get et set de la classe store
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
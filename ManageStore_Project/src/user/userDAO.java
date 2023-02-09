package user;

import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Classe qui permet d'accéder au requéte SQL à executer
 * Cette classe permet de manipuler les données des tables product (create, read, update, delete)
 *
 */




public class userDAO {
	public Connection con;
	

	public boolean DAOSingIn() {
		return(true);
	
	}

	/**
	 *  Méthode de création d'un compte execute nécessite un insert avec les paramètres issus des méthodes get et set de la classe product
	 */ 
	
	
	public boolean DAOCreateAccount(String UserMail, String UserName, String UserSurname, String UserPassword, String UserPseudo,String RoleId,String StoreId ) 
	{
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		int nbValues=0;
		
        BasicFunction.BasicFunction B=new BasicFunction.BasicFunction();
        String hashedPassword=B.hashPassword(UserPassword);
		
		String values= "'"+UserMail +"','"+UserName+"','"+UserSurname+"','"+hashedPassword+"','"+UserPseudo+ "',"+RoleId+","+StoreId;
		String Query="INSERT INTO user (UserMail,UserName,UserSurname,UserPassword,UserPseudo,RoleId, StoreId) VALUES(" +values+")";

		nbValues=dao.DAOExecuteQuery(con, Query);
		if (nbValues==1)
		{
			return(true);
		}
		return(false);
	}
	
	/**
	 *  Méthode de mise, à jour d'un compte nécessite un insert avec les paramètres issus des méthodes get et set de la classe product
	 */ 
	
	public boolean DAOUpdateAccount(int UserId,String UserMail, String UserName, String UserSurname, String UserPassword, String UserPseudo, String RoleId, String StoreId) 
	{
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		int nbValues=0;
		String P0="UserMail='"+UserMail +"',";
		String P1="UserName='"+UserName +"',";
		String P2="UserSurname='"+UserSurname +"',";
		
        BasicFunction.BasicFunction B=new BasicFunction.BasicFunction();
        String hashedPassword=B.hashPassword(UserPassword);

		
		String P3="UserPassword='"+hashedPassword +"',";
		String P4="UserPseudo='"+UserPseudo +"',";
		String P5="RoleId="+RoleId +", ";
		String P6="StoreId="+StoreId +" ";		
		String P7="WHERE UserId="+UserId;
		String Query="UPDATE user SET "+P0+P1+P2+P3+P4+P5+P6+P7;	

		nbValues=dao.DAOExecuteQuery(con, Query);
		if (nbValues==1)
				{
					return(true);
				}
		return(false);
	}
	
	/**
	 *  Méthode de suppression d'un compte
	 */ 
	public boolean DAODeleteAccount(int UserId) {
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		int nbValues=0;
		
		String Query="DELETE FROM user WHERE UserId="+UserId;

		nbValues=dao.DAOExecuteQuery(con, Query);

		if (nbValues==1)
		{
			return(true);
		}
		return(false);
	}
		
	/**
	 *  Méthode de création d'un produit execute nécessite un insert avec les paramètres issus des méthodes get et set de la classe product
	 */ 
	public Object[][] DAOListAccount() {
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		ResultSet rs;
		String [][] donnees=new String[101][9];
		String Query="SELECT UserId, UserMail, UserName,UserSurname,UserPassword,UserPseudo,RoleId,user.StoreID, storename from user, store where store.storeid=user.storeid	";	

		rs=dao.DAOSelect(con, Query);
		int i=0;

		try
		{
			while (rs.next())
			
			{
				donnees[i][0]=rs.getString("UserId");
				donnees[i][1]=rs.getString("UserMail");
				donnees[i][2]=rs.getString("UserName");
				donnees[i][3]=rs.getString("UserSurname");
				donnees[i][4]=rs.getString("UserPseudo");
				donnees[i][5]=rs.getString("UserPassword");	
				donnees[i][6]=rs.getString("RoleId");
				donnees[i][7]=rs.getString("StoreId");	
				donnees[i][8]=rs.getString("StoreName");
				i++;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return(donnees);
	}
	public Object[][] DAOListEmployeesInStore(String StoreId) {
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		ResultSet rs;
		String [][] donnees=new String[101][4];
		String Query="SELECT UserId, UserName,UserSurname from user,store where store.storeid=user.storeid and user.storeid="+StoreId;	

		rs=dao.DAOSelect(con, Query);
		int i=0;

		try
		{
			while (rs.next())
			
			{
				donnees[i][0]=rs.getString("UserId");
				donnees[i][1]=rs.getString("UserName");
				donnees[i][2]=rs.getString("UserSurname");
				i++;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return(donnees);
	}

}
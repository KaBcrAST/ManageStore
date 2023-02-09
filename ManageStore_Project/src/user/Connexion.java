package user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Arrays;

public class Connexion {
	
	
	/**
	 * D�claration des propri�t�s de la classe Connexion
	 */ 
	public String Login;
	public String Password;
	public String RoleId;
	public String StoreName;
	public Connection con;
	
	/**
	 * M�thode pour obtenir la valeur de la propri�t� Login
	 */ 
	public String GetLogin() {
		return(Login);
	}
	
	/**
	 * M�thode pour d�finir la valeur de la propri�t� Login
	 */ 
	public void SetLogin(String Login) {
		this.Login = Login;
	}
	
	/**
	 * M�thode pour obtenir la valeur de la propri�t� Password
	 */
	public String GetPassword() {
		return(Password);
	}
	
	/**
	 * M�thode pour d�finir la valeur de la propri�t� Password
	 */ 
	public void SetPassword(String Password) {
		this.Password = Password;
	}
	
	/**
	 * M�thode pour �tablir une connexion � la base de donn�es
	 */ 
	public boolean connect() {
		dao.DAO connexiondao = new dao.DAO();
		con = null;
		con = connexiondao.DAOconnect();
		return(true);
	}
	
	/**
	 * M�thode pour v�rifier les informations de connexion d'un utilisateur
	 */ 
	public boolean signin() {
	    dao.DAO sign = new dao.DAO();
	    con = null;
	    con = sign.DAOconnect();
	    ResultSet rs;
	    String Query = "SELECT UserMail, RoleId, user.StoreId, store.storename, UserPassword FROM User, store WHERE store.storeId=user.storeid and UserMail = '" + Login + "'";
	    System.out.println(Query);
	    rs = sign.DAOSelect(con, Query);
	    
	    try {
	        if (rs.next()) {
	            Login = rs.getString("userMail");
	            RoleId = rs.getString("RoleId");
	            StoreName = rs.getString("storename");
	            String PasswordBDD = rs.getString("UserPassword").toString();
	            BasicFunction.BasicFunction B = new BasicFunction.BasicFunction();
	            String TypedPassword = B.hashPassword(Password);
	
	            if (PasswordBDD.compareTo(TypedPassword) == 0) {
	                return(true);
	            } else {
	                return(false);
	            }
	        } else {
	            return(false);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return(false);
	    }
	}
}
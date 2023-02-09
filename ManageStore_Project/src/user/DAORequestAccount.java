package user;

import static javax.swing.JOptionPane.showMessageDialog;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Classe qui permet d'accéder de faire une soumission de demande d'ouverture de compte
 *
 */
public class DAORequestAccount {
	public Connection con;
	/**
	 * Méthode qui permet d'intégrer dans la whitelist les email demandant une création de compte
	 * Elle vérifie avant tout que la demande n'est pas déjà faite
	 *
	 */
	
	public Boolean DAORequestForAnAccount(String Email, String Name, String Surname)
	{
		
		dao.DAO dao=new dao.DAO();
		con =dao.DAOconnect();
		String Query = "Select * from listofemail where usermail='"+Email+"'";
		ResultSet rs=null;
		rs=dao.DAOSelect(con, Query);
		Boolean bExist=false;
		try 
		{
			if (rs.next())
			{
				bExist=true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			bExist=false;
		
		}
		
		if (!bExist)
		{
			Query = "Insert into listofemail (Usermail, Name, Surname,WhiteList) values('"+Email+"','"+Name+"','"+Surname+"',"+false+")";
			System.out.println(Query);
			con =dao.DAOconnect();
			int i = dao.DAOExecuteQuery(con, Query);
			if (i==1)
			{
				showMessageDialog(null, "Request for an account submited");
			}
			else
			{
				showMessageDialog(null, "Request for an account not submited");				
			}
		}
		else
		{
			showMessageDialog(null, "Request for an account not submited");
		}

		return(true);
	}

}

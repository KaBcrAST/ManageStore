package emailists;
import java.sql.Connection;


import java.sql.ResultSet;

/**
 * Classe qui permet d'accéder au requéte SQL à executer
 * Cette classe permet de manipuler les données des tables listofemail et user, pour pemettre d'ouvir uou fermer un compte utilisateur 
 * La demande de création de compte est placé dans le table listeofemail dans le BlackList (WhiteList=false).
 * La création du compte se fait en basculant l'utilisateur en whitelist ((WhiteList=false) qui déclenche un insert dans la table des users avec un mot de passe par défaut égal au nom de l'utilisateut
 * et en le ratachant au magasin central. 
 * 
 * En cas de suppression du compte, l'utilisatuer est supprimé de la table user et replacé blacklist ( dans listofemail ) (WhiteList=false)
 * Les variables publiques permettent également de passer les paramètres 
 * Les méthodes n'ont pas de paramétres, il faut donc passer les paramètres à la classe avant d'executer les méthodes
 * 
 * La classe n'accéde pas directement à la bas ede données, ais le fait par le biais de la classe DAO
 *
 */

public class ListOfEmailDAO {
	public Connection con;
	
	/**
	 * DAODeleteAccount repositionne l'email utilisateur dans la blacklist et supprime les infos de la table user
	 */	
	public boolean DAODeleteAccount(String eMail) 
	{

		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		int nbValues;
		String P0=" WHERE UserMail='"+eMail+"'";

		String P1="WhiteList=false";

		String Query="UPDATE listofemail SET "+P1+P0;	

		if (eMail!="")
		{
			nbValues=dao.DAOExecuteQuery(con, Query);
			con=dao.DAOconnect();

			Query="DELETE FROM USER Where UserMail='" +eMail+"'";
			nbValues=dao.DAOExecuteQuery(con, Query);
		}

		return(true);
	}
	/**
	 * DAOCreateAccount positionne l'email utilisateur dans la whitelist (whitelist=true)  et crée le compte utilisateur
	 * L'utilisateur est rattaché au magasin central et possède le proil "utilisateur
	 */		
	public boolean DAOCreateAccount(int EmailID, String eMail, String Name, String SurName,String StoreId) 
	{
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		int nbValues=0;
		String P0=" WHERE EmailID="+EmailID;

		String P1="WhiteList=true";
        BasicFunction.BasicFunction B=new BasicFunction.BasicFunction();
        String hashedPassword=B.hashPassword(Name);
        System.out.println(hashedPassword);
		String Query="UPDATE listofemail SET "+P1+P0;	

		if (EmailID!=0)
		{
			nbValues=dao.DAOExecuteQuery(con, Query);	
			Query="INSERT INTO USER (UserMail, UserName, UserSurname, Userpseudo,UserPassword, RoleID,StoreId) VALUES ('"+eMail+"','" +Name+"','"+SurName+"','"+Name+"','"+hashedPassword+"',"+"2,"+StoreId+")";

			con=dao.DAOconnect();
			nbValues=dao.DAOExecuteQuery(con, Query);
		}
		if (nbValues==1)
		{
				return(true);
		}

		return(false);
	}

	/**
	 * DAOListOfEmail permet de lister la whitelist (Whitelist = true) ou de lister la blacklist (Withelist=false)
	 * 
	 */	
	
	public Object[][] DAOListOfEmail(Boolean WList) {
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		ResultSet rs;
		String [][] donnees=new String[101][5];
		String Query="SELECT EmailId, UserMail,Name, Surname from listofemail where WhiteList="+WList;	

		rs=dao.DAOSelect(con, Query);
		int i=0;

		try
		{
			while (rs.next())
			
			{
				donnees[i][0]=rs.getString("EmailId");
				donnees[i][1]=rs.getString("UserMail");
				donnees[i][2]=rs.getString("Name");
				donnees[i][3]=rs.getString("Surname");
				i++;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return(donnees);
	}

}

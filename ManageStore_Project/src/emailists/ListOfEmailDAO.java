package emailists;
import java.sql.Connection;


import java.sql.ResultSet;

/**
 * Classe qui permet d'acc�der au requ�te SQL � executer
 * Cette classe permet de manipuler les donn�es des tables listofemail et user, pour pemettre d'ouvir uou fermer un compte utilisateur 
 * La demande de cr�ation de compte est plac� dans le table listeofemail dans le BlackList (WhiteList=false).
 * La cr�ation du compte se fait en basculant l'utilisateur en whitelist ((WhiteList=false) qui d�clenche un insert dans la table des users avec un mot de passe par d�faut �gal au nom de l'utilisateut
 * et en le ratachant au magasin central. 
 * 
 * En cas de suppression du compte, l'utilisatuer est supprim� de la table user et replac� blacklist ( dans listofemail ) (WhiteList=false)
 * Les variables publiques permettent �galement de passer les param�tres 
 * Les m�thodes n'ont pas de param�tres, il faut donc passer les param�tres � la classe avant d'executer les m�thodes
 * 
 * La classe n'acc�de pas directement � la bas ede donn�es, ais le fait par le biais de la classe DAO
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
	 * DAOCreateAccount positionne l'email utilisateur dans la whitelist (whitelist=true)  et cr�e le compte utilisateur
	 * L'utilisateur est rattach� au magasin central et poss�de le proil "utilisateur
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

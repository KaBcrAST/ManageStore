package role;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;

/**
 * Classe qui permet d'acc�der au requ�te SQL � executer
 * Cette classe permet de manipuler les donn�es de la  tables role (create, read, update, delete 

 *
 */

public class RoleDAO {
	public Connection con;
	

	public boolean DAOSingIn() {
		return(true);
	
	}
	
	/**
	 *  M�thode permettant de cr�er un r�le
	 *  Il faut avoir pr�alablement pass� � la classe les propro�t�s n�cessaires
	 *  SetRoleID
	 *  SetRoleDescription
	 */
	
	public boolean DAOCreateRole(String Roledescription, int RoleId ) 
	{
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		int nbValues=0;
		String values= "'"+Roledescription +"',"+RoleId;
		String Query="INSERT INTO product (Roledescription,RoleId) VALUES(" +values+")";

		nbValues=dao.DAOExecuteQuery(con, Query);
		if (nbValues==1)
				{
					return(true);
				}
		return(false);
	}

	/**
	 *  M�thode permettant de mettre � jour un r�le
	 *  Il faut avoir pr�alablement pass� � la classe les propro�t�s n�cessaires
	 *  SetRoleID
	 *  SetRoleDescription
	 */
	
	public boolean DAOUpdateRole(int RoleId,String Roledescription) 
		{
			dao.DAO dao=new dao.DAO();
			con=dao.DAOconnect();
			int nbValues=0;
			String P0=" WHERE ProductId="+RoleId;
			String P1="ProductName='"+Roledescription +"',";
			String Query="UPDATE product SET "+P1+P0;	
			

			nbValues=dao.DAOExecuteQuery(con, Query);
			if (nbValues==1)
					{
						return(true);
					}
			return(false);
		}

	/**
	 *  M�thode pour lister les r�les
	 *  retourne un tableau de type objet � 2 dimensions [ligne][colonne de la base de donn�es]
	 * 
	 *  Colonne de la base de donn�es :
	 *  0 RoleId
	 *  1 Roledescription
	 *  2 RoleValue
	 *  
	 */ 	
	public Object[][] DAOListRole() {
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		ResultSet rs;
		String [][] donnees=new String[101][3];
		String Query="SELECT RoleId, Roledescription,RoleValue from role";	

		rs=dao.DAOSelect(con, Query);
		int i=0;

		try
		{
			while (rs.next())
			
			{
				donnees[i][0]=rs.getString("RoleId");
				donnees[i][1]=rs.getString("Roledescription");
				donnees[i][2]=rs.getString("RoleValue");
				i++;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return(donnees);
	}

}

	

	
	

package product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;



	
public class UniteOfMeasureDAO {
	public Connection con;
	
	/**
	 *  La m�thode DAOListUnitOfMeasure() renvoie un tableau � deux dimensions d'objets qui contiendra les donn�es sur les unit�s de mesure.
	 */ 
	public Object[][] DAOListUnitOfMeasure() {
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		ResultSet rs;
		String [][] donnees=new String[101][2];
		String Query="SELECT UnitID,Unitdescription from uniteofmeasure";	

		rs=dao.DAOSelect(con, Query);
		int i=0;

		try
		{
			while (rs.next())
			
			{
				donnees[i][0]=rs.getString("UnitID");
				donnees[i][1]=rs.getString("Unitdescription");

				
				i++;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return(donnees);
	}

	
}

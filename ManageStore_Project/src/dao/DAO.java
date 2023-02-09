package dao;

import java.sql.*;
/**
 *  Classe qui contient les méthodes de base pour accéder à la base de données
 *	connection
 *	Selection
 *	Execution d'une requéte
 */

public class DAO {
	public String connectString="jdbc:mariadb://localhost:3306/thomas"; 
	public String Login="root";
	public String Password="root";

	
	/**
	 *  Méthode permettant de se connecter à la base de données
	 */
	
	public Connection DAOconnect()
	{
		Connection con=null;
		try 
		{
			con = DriverManager.getConnection(connectString, Login, Password);
			return(con);
		}
		catch (Exception e) {
			e.printStackTrace();
			return(con);
		
		}

	}
	
	/**
	 *  Méthode permettant d'executer une requéte (insert, update ou delete
	 */
	public int DAOExecuteQuery(Connection con, String Query)
	{
		PreparedStatement ps=null;
		int NbValuesReturned=0;
		
		try 
		{
			ps=con.prepareStatement(Query);

			NbValuesReturned=ps.executeUpdate();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			return(0);
		
		}
		try
		{
		con.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return(NbValuesReturned);


	}
	/**
	 *  Méthode permettant d'executer une requéte (select)
	 */
	public ResultSet DAOSelect(Connection con, String Query)
	{
		PreparedStatement ps=null;
		int NbValuesReturned=0;
		ResultSet rs=null;
		
		try 
		{
			ps=con.prepareStatement(Query);
			rs=ps.executeQuery();

		}
		catch (Exception e) {
			e.printStackTrace();
			return(rs);
		
		}
		try
		{
		con.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return(rs);
	}
	

	
	

}	
	

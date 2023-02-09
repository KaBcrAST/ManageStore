package dao;

import java.sql.*;
/**
 *  Classe qui contient les m�thodes de base pour acc�der � la base de donn�es
 *	connection
 *	Selection
 *	Execution d'une requ�te
 */

public class DAO {
	public String connectString="jdbc:mariadb://localhost:3306/thomas"; 
	public String Login="root";
	public String Password="root";

	
	/**
	 *  M�thode permettant de se connecter � la base de donn�es
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
	 *  M�thode permettant d'executer une requ�te (insert, update ou delete
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
	 *  M�thode permettant d'executer une requ�te (select)
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
	

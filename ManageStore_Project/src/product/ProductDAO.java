package product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;

/**
 * Classe qui permet d'accéder au requéte SQL à executer
 * Cette classe permet de manipuler les données des tables product (create, read, update, delete)
 *
 */
public class ProductDAO {
	public Connection con;
	

	public boolean DAOSingIn() {
		return(true);
	
	}
	/**
	 *  Méthode de création d'un produit execute nécessite un insert avec les paramètres issus des méthodes get et set de la classe product
	 */ 
	boolean DAOCreateProduct(String ProductName,String Productdescription, int ProductPrice , String UnitID ) 
	{
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		int nbValues=0;
		String values= "'"+ProductName +"','"+Productdescription+"',"+ProductPrice+"," + UnitID;
		String Query="INSERT INTO product (ProductName,Productdescription,ProductPrice,UnitID) VALUES(" +values+")";
		System.out.println(Query);

		nbValues=dao.DAOExecuteQuery(con, Query); 
		if (nbValues==1)
				{
					return(true);
				}
		return(false);
	}
	/**
	 *  Méthode de mise à jour  d'un produit execute nécessite un update avec les paramètres issus des méthodes get et set de la classe product
	 */ 	
	public boolean DAOUpdateProduct(int ProductId,String ProductName,String Productdescription, int ProductPrice, String UnitID) 
		{
			dao.DAO dao=new dao.DAO();
			con=dao.DAOconnect();
			int nbValues=0;
			String P0=" WHERE ProductId="+ProductId;
			String P1="ProductName='"+ProductName +"',";
			String P2="ProductPrice="+ProductPrice +",";
			String P3="Productdescription='"+Productdescription+"',";
			String P4="UnitID="+UnitID;
			String Query="UPDATE product SET "+P1+P2+P3+P4+P0;
			
			System.out.println(Query);
			nbValues=dao.DAOExecuteQuery(con, Query);
			if (nbValues==1)
					{
						return(true);
					}
			return(false);
		}
	/**
	 *  Méthode de suppression  d'un produit execute nécessite un update avec les paramètres issus des méthodes get et set de la classe product
	 */ 	

	public boolean DAODeleteProduct(int ProductId) {
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		int nbValues=0;
		String Query="DELETE FROM product WHERE ProductId="+ProductId;	

		nbValues=dao.DAOExecuteQuery(con, Query);
		
		if (nbValues==1)
		{
			return(true);
		}
		return(false);
	}

	/**
	 *  Méthode pour lister les produits
	 *  retourne un tableau de type objet à 2 dimensions [ligne][colonne de la base de données]
	 * 
	 *  Colonne de la base de données :
	 *  0 ProductId
	 *  1 ProductName
	 *  2 ProductPrice
	 *  3 UnitID
	 *  
	 */ 	

	
	public Object[][] DAOListProduct() {
		dao.DAO dao=new dao.DAO();
		con=dao.DAOconnect();
		ResultSet rs;
		String [][] donnees=new String[101][5];
		String Query="SELECT ProductId, ProductName,ProductPrice,product.UnitID, Unitdescription from product, uniteofmeasure where product.UnitID=uniteofmeasure.UnitID";	

		rs=dao.DAOSelect(con, Query);
		int i=0;

		try
		{
			while (rs.next())
			
			{
				donnees[i][0]=rs.getString("ProductId");
				donnees[i][1]=rs.getString("ProductName");
				donnees[i][2]=rs.getString("ProductPrice");
				donnees[i][3]=rs.getString("UnitID");
				donnees[i][4]=rs.getString("Unitdescription");

				
				i++;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return(donnees);
	}

}

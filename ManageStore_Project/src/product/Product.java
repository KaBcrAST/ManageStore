package product;

/**
 *  Interface entre la classe userIHM1 et la classe DAO ProductDAO
 * Les m�thodes GET et SET permettent de passer les param�tres � la classe
 * Les variables publiques permettent �galement de passer les param�tres 
 * Les m�thodes n'ont pas de param�tres, il faut donc passer les param�tres � la classe avant d'executer les m�thodes
 *
 */


public class Product {
	public int ProductId;
	public String ProductName;
	public int ProductPrice;
	public String UnitID;
	public String Productdescription;
	
	public int GetProductId()
	{
		return(ProductId);
	}
	
	public void SetProductId(int ProductId)
	{
		this.ProductId=ProductId;
	}
	public String GetProductName()
	{
		return(ProductName);
	}
	
	public void SetProductName(String ProductName)
	{
		this.ProductName=ProductName;
	}
	
	public int GetProductPrice()
	{
		return(ProductPrice);
	}
	public void SetProductPrice(int ProductPrice)
	{
		this.ProductPrice=ProductPrice;
	}
	
	public String GetUnitID()
	{
		return(UnitID);
	}
	public void SetUnitID(String UnitID)
	{
		this.UnitID=UnitID;
	}
	public String GetProductdescription()
	{
		return(Productdescription);
	}
	
	public void SetProductdescription(String Productdescription)
	{ 
		this.Productdescription=Productdescription;
	}
	/**
	 *  M�thode permettant de cr�er un produit
	 *  Il faut avoir pr�alablement pass� � la classe les propro�t�s n�cessaires
	 *  SetProductName
	 *  SetProductdescription
	 *  SetProductPrice
	 *  SetUnitID
	 */

	public boolean CreateProduct() 
	{

		ProductDAO ProductDAO =new ProductDAO();
		return(ProductDAO.DAOCreateProduct(ProductName,Productdescription,ProductPrice,UnitID));
	
	}
	
	/**
	 *  M�thode permettant de mettre � jour un produit
	 *  Il faut avoir pr�alablement pass� � la classe les propri�t�s n�cessaires
	 *  SetProductID
	 *  SetProductName (Obligatoire)
	 *  SetProductdescription
	 *  SetProductPrice
	 *  SetUnitID
	 */
	public boolean UpdateProduct() 
	{
		ProductDAO ProductDAO =new ProductDAO();
		return(ProductDAO.DAOUpdateProduct(ProductId,ProductName,Productdescription,ProductPrice,UnitID));
	}
	/**
	 *  M�thode permettant de supprimer un produit
	 *  Il faut avoir pr�alablement pass� � la classe les propri�t�s n�cessaires
	 *  SetProductID
	 */
	public boolean DeleteProduct() {
		ProductDAO ProductDAO =new ProductDAO();
		return(ProductDAO.DAODeleteProduct(ProductId));
	}
	
	/**
	 *  M�thode permettant de lister les produits
	 */
	
	public Object[][] ListProduct() {
		

		Object [][] donnees=new String[101][5];
		ProductDAO ProductDAO =new ProductDAO();
		return(ProductDAO.DAOListProduct());

	}
}

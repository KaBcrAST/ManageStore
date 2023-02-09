package product;

/**
 *  Interface entre la classe userIHM1 et la classe DAO ProductDAO
 * Les méthodes GET et SET permettent de passer les paramètres à la classe
 * Les variables publiques permettent également de passer les paramètres 
 * Les méthodes n'ont pas de paramétres, il faut donc passer les paramètres à la classe avant d'executer les méthodes
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
	 *  Méthode permettant de créer un produit
	 *  Il faut avoir préalablement passé à la classe les proproétés nécessaires
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
	 *  Méthode permettant de mettre à jour un produit
	 *  Il faut avoir préalablement passé à la classe les propriétés nécessaires
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
	 *  Méthode permettant de supprimer un produit
	 *  Il faut avoir préalablement passé à la classe les propriétés nécessaires
	 *  SetProductID
	 */
	public boolean DeleteProduct() {
		ProductDAO ProductDAO =new ProductDAO();
		return(ProductDAO.DAODeleteProduct(ProductId));
	}
	
	/**
	 *  Méthode permettant de lister les produits
	 */
	
	public Object[][] ListProduct() {
		

		Object [][] donnees=new String[101][5];
		ProductDAO ProductDAO =new ProductDAO();
		return(ProductDAO.DAOListProduct());

	}
}

package role;

import product.ProductDAO;

/**
 *  Interface entre la classe userIHM1 et la classe DAO RoleDAO
 * Les méthodes GET et SET permettent de passer les paramètres à la classe
 * Les variables publiques permettent également de passer les paramètres 
 * Les méthodes n'ont pas de paramétres, il faut donc passer les paramètres à la classe avant d'executer les méthodes
 *
 */
public class Role {
	public int RoleId;
	public String Roledescription;
	public int RoleValue;


	
	public int GetRoleId()
	{
		return(RoleId);
	}
	
	public void SetRoleId(int RoleId)
	{
		this.RoleId=RoleId;
	}
	public String GetRoledescription()
	{
		return(Roledescription);
	}
	
	public void SetRoledescription(String Roledescription)
	{
		this.Roledescription=Roledescription;
	}
	
	public int GetRoleValue()
	{
		return(RoleValue);
	}
	
	public void SetRoleValue(int RoleValue)
	{
		this.RoleValue=RoleValue;
	}
	
	/**
	 *  Méthode permettant de lister les role
	 */
	public Object[][] ListRole() {
		

		Object [][] donnees=new String[10][5];
		RoleDAO RoleDAO =new RoleDAO();
		return(RoleDAO.DAOListRole());

	}
	
	/**
	 *  Méthode permettant de mettre à jour un rôle
	 *  Il faut avoir préalablement passé à la classe les propriétés nécessaires
	 *  SetRoleID (Obligatoire)
	 *  SetRoledescription (Obligatoire)
	 */
	

	public boolean UpdateRole() 
	{
		RoleDAO RoleDAO =new RoleDAO();
		return(RoleDAO.DAOUpdateRole(RoleId,Roledescription));
	}
	
	
}

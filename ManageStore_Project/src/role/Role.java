package role;

import product.ProductDAO;

/**
 *  Interface entre la classe userIHM1 et la classe DAO RoleDAO
 * Les m�thodes GET et SET permettent de passer les param�tres � la classe
 * Les variables publiques permettent �galement de passer les param�tres 
 * Les m�thodes n'ont pas de param�tres, il faut donc passer les param�tres � la classe avant d'executer les m�thodes
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
	 *  M�thode permettant de lister les role
	 */
	public Object[][] ListRole() {
		

		Object [][] donnees=new String[10][5];
		RoleDAO RoleDAO =new RoleDAO();
		return(RoleDAO.DAOListRole());

	}
	
	/**
	 *  M�thode permettant de mettre � jour un r�le
	 *  Il faut avoir pr�alablement pass� � la classe les propri�t�s n�cessaires
	 *  SetRoleID (Obligatoire)
	 *  SetRoledescription (Obligatoire)
	 */
	

	public boolean UpdateRole() 
	{
		RoleDAO RoleDAO =new RoleDAO();
		return(RoleDAO.DAOUpdateRole(RoleId,Roledescription));
	}
	
	
}

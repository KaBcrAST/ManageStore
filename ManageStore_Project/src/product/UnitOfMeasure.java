package product;

/**
 *  Interface entre la classe userIHM1 et la classe DAO UnitOfMeasureDAO
 * Les m�thodes GET et SET permettent de passer les param�tres � la classe
 * Les variables publiques permettent �galement de passer les param�tres 
 * Les m�thodes n'ont pas de param�tres, il faut donc passer les param�tres � la classe avant d'executer les m�thodes
 *
 */

public class UnitOfMeasure {
	public int UnitID;
	public String UnitDescription;

	/**
	 *  M�thode permettant de lister les type de mesures
	 */
	
	public Object[][] ListUnit() 
	{
		
	
		Object [][] donnees=new String[101][5];
		UniteOfMeasureDAO UnitDAO =new UniteOfMeasureDAO();
		return(UnitDAO.DAOListUnitOfMeasure());
	
	}


}

package product;

/**
 *  Interface entre la classe userIHM1 et la classe DAO UnitOfMeasureDAO
 * Les méthodes GET et SET permettent de passer les paramètres à la classe
 * Les variables publiques permettent également de passer les paramètres 
 * Les méthodes n'ont pas de paramétres, il faut donc passer les paramètres à la classe avant d'executer les méthodes
 *
 */

public class UnitOfMeasure {
	public int UnitID;
	public String UnitDescription;

	/**
	 *  Méthode permettant de lister les type de mesures
	 */
	
	public Object[][] ListUnit() 
	{
		
	
		Object [][] donnees=new String[101][5];
		UniteOfMeasureDAO UnitDAO =new UniteOfMeasureDAO();
		return(UnitDAO.DAOListUnitOfMeasure());
	
	}


}

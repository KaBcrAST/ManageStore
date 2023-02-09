package user;

/**
 *  Interface entre la classe IHMRequestAccount et la classe DAO RequestAccountDAO
 * Les méthodes GET et SET permettent de passer les paramètres à la classe
 * Les variables publiques permettent également de passer les paramètres 
 * Les méthodes n'ont pas de paramétres, il faut donc passer les paramètres à la classe avant d'executer les méthodes
 *
 */
public class RequestAccount {
	public String Name;
	public String Surname;
	public String email;
	
	/**
	 * Méthode qui permet d'intégrer dans la whitelist les email demandant une création de compte
	 * Elle vérifie avant tout que la demande n'est pas déjà faite
	 * Il est nécessaire de renseigner les get et set suivants :
	 * SetEmail
	 * SetName
	 * SetSurname
	 */
	public Boolean RequestForAnAccount()
	{
		DAORequestAccount daor=new DAORequestAccount();
		Boolean bOk=daor.DAORequestForAnAccount(email, Name, Surname);
		return(bOk);
	}
	

}

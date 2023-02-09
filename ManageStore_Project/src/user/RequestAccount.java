package user;

/**
 *  Interface entre la classe IHMRequestAccount et la classe DAO RequestAccountDAO
 * Les m�thodes GET et SET permettent de passer les param�tres � la classe
 * Les variables publiques permettent �galement de passer les param�tres 
 * Les m�thodes n'ont pas de param�tres, il faut donc passer les param�tres � la classe avant d'executer les m�thodes
 *
 */
public class RequestAccount {
	public String Name;
	public String Surname;
	public String email;
	
	/**
	 * M�thode qui permet d'int�grer dans la whitelist les email demandant une cr�ation de compte
	 * Elle v�rifie avant tout que la demande n'est pas d�j� faite
	 * Il est n�cessaire de renseigner les get et set suivants :
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

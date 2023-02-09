package BasicFunction;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *  Classe qui contient quelques fonctions de base
 *
 */
public class BasicFunction {
	

	/**
	 * Méthde qui permet de vérifier la conformité du paramétre email à une expression rgulière pour un email
	 * 
	 */
	
	public boolean isValidEmailAdress(String email) {
		String regex = "^.+@.+\\..+$";
        return email.matches(regex);
    }

	/**
	 * Méthde qui permet de vérifier d'encrypter la chaine password en SHA-256
	 */

    public String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        md.update(password.getBytes());
        byte[] digest = md.digest();
        return Base64.getEncoder().encodeToString(digest);
    }
	/**
	 * Méthode interne de transformation nécesaire à la fonction hashPassword
	 * 
	 */
    private static String bytesToHex(byte[] b) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
            'B', 'C', 'D', 'E', 'F' };
        StringBuffer buffer = new StringBuffer();
        for (int j = 0; j < b.length; j++) {
          buffer.append(hexDigits[(b[j] >> 4) & 0x0f]);
          buffer.append(hexDigits[b[j] & 0x0f]);
        }
        return buffer.toString();
      }
    

    
}

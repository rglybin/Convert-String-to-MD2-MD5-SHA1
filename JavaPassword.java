

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JavaPassword {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String salt = "RandomStringForExtraSecurity@#$!%^&*(*)1234567890";
		String unecryptedPassword = "test1234";
		System.out.println("Unencrypted Password: " + unecryptedPassword);
		
		MessageDigest messageDigest=null;
		try {
			messageDigest = MessageDigest.getInstance("SHA1");
			//messageDigest = MessageDigest.getInstance("MD5");
			//messageDigest = MessageDigest.getInstance("MD2");
			messageDigest.update((unecryptedPassword).getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String encryptedPassword = (new BigInteger(messageDigest.digest())).toString(16);
		System.out.println("Encrypted Password: " + encryptedPassword);
	}

}

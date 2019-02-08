package src.Others;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;

//Encryption
//https://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
//https://www.geeksforgeeks.org/sha-256-hash-in-java/
//https://www.baeldung.com/sha-256-hashing-java
public class Security {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {

		String passwordToHash = "password";
		byte[] salt = getSalt();

		String securePassword = getSecurePassword(passwordToHash, salt);
		System.out.println(securePassword); // Prints 83ee5baeea20b6c21635e4ea67847f66

		String regeneratedPassowrdToVerify = getSecurePassword(passwordToHash, salt);
		System.out.println(regeneratedPassowrdToVerify); // Prints 83ee5baeea20b6c21635e4ea67847f66
	}

	private static String getSecurePassword(String passwordToHash, byte[] salt) {
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(salt);
			// Get the hash's bytes
			byte[] bytes = md.digest(passwordToHash.getBytes());
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	// Add salt
	private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
		// Always use a SecureRandom generator

		printAllProviders();
		// algorithm, provider name
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

		System.out.println(sr);
		// Create array for salt
		byte[] salt = new byte[16];
		// Get a random salt
		sr.nextBytes(salt);

		// return salt
		return salt;
	}

	private static void printAllProviders() {
		boolean failure = false;

		for (Provider p : java.security.Security.getProviders()) {
			System.out.print(p.getName() + " ");
			if (p.getVersion() != 10.0d) {
				System.out.println("failed. " + "Version received was " + p.getVersion());
				failure = true;
			} else {
				System.out.println("passed.");
			}
		}

	}
}

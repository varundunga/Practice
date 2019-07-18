package encryption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.Cipher;

public class Rsa {
	

		 
		    public static void rsaEnc(String plainText) throws Exception {
		        		 
		        // Generate public and private keys using RSA
		        Map<String, Object> keys = getRSAKeys();
		 
		        PrivateKey privateKey = (PrivateKey) keys.get("private");
		        PublicKey publicKey = (PublicKey) keys.get("public");
		        System.out.println(privateKey);
		        System.out.println(publicKey);
		 
		        String encryptedText = encryptMessage(plainText, privateKey);
		       // String descryptedText = decryptMessage(encryptedText, publicKey);
		 
		        System.out.println("input:" + plainText);
		        System.out.println("encrypted:" + encryptedText);
		        //System.out.println("decrypted:" + descryptedText);
		 
		    }
		 
		    // Get RSA keys. Uses key size of 2048.
		    private static Map<String,Object> getRSAKeys() throws Exception {
		        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		        keyPairGenerator.initialize(512);
		        KeyPair keyPair = keyPairGenerator.generateKeyPair();
		        PrivateKey privateKey = keyPair.getPrivate();
		        PublicKey publicKey = keyPair.getPublic();
		 
		        Map<String, Object> keys = new HashMap<String,Object>();
		        keys.put("private", privateKey);
		        keys.put("public", publicKey);
		        return keys;
		    }
		 
		  
		 
		    // Encrypt using RSA private key
		    private static String encryptMessage(String plainText, PrivateKey privateKey) throws Exception {
		        Cipher cipher = Cipher.getInstance("RSA");
		        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		        return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
		    }
		 
		
		// TODO Auto-generated method stub

	}


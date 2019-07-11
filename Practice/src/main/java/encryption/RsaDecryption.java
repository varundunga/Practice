package encryption;

import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

public class RsaDecryption {
	
	  // Decrypt using RSA public key
    private static String decryptMessage(String encryptedText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
    }

}

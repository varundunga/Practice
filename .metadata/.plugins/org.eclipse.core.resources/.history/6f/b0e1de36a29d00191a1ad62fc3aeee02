package encryption;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.codehaus.plexus.util.FileUtils;

public class AesDecryption {
	public static String decrypt(String encryptedText, SecretKey secretKey,IvParameterSpec ivp)
			throws Exception {
		
		/*String keys=FileUtils.fileRead("C:\\Users\\vdunga\\Desktop\\keys.txt");
		BufferedReader readers = new BufferedReader(new StringReader(keys));
		String secretKey=readers.readLine();
		String ivp=readers.readLine();
		System.out.println(secretKey);
		System.out.println(ivp);*/
		Cipher cipher;
		cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = decoder.decode(encryptedText);
		cipher.init(Cipher.DECRYPT_MODE, secretKey,ivp);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		String decryptedText = new String(decryptedByte);
		return decryptedText;
	}


}

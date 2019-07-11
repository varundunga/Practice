package encryption;

import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.codehaus.plexus.util.FileUtils;

import com.google.common.io.Files;

public class Aes {

	//static Cipher cipher;
	
	public static void aesEnc(String plainText) throws Exception {
				KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
				keyGenerator.init(128);
				SecretKey secretKey = keyGenerator.generateKey();
				byte iv[]=new byte[16];
				SecureRandom random=new SecureRandom();
				random.nextBytes(iv);
				IvParameterSpec ivp=new IvParameterSpec(iv);
				byte[] secretKeyBytes=secretKey.getEncoded();
				Base64.Decoder decoder = Base64.getDecoder();
				byte[] decodedSecretKey = decoder.decode(secretKeyBytes);
				String secretKeyString=decodedSecretKey.toString();
				byte[] ivpBytes=ivp.getIV();
				
				byte[] decodedIvp = decoder.decode(ivpBytes);
				String ivpString=decodedIvp.toString();
				System.out.println(secretKeyString+"\n"+ivpString);
				
				//cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

				System.out.println("Plain Text Before Encryption: " + plainText);

				String encryptedText = encrypt(plainText, secretKey,ivp);
				System.out.println("Encrypted Text After Encryption: " + encryptedText);
				FileUtils.fileWrite("C:\\Users\\vdunga\\Desktop\\keys.txt", secretKey+"\n"+ivp);
				//FileUtils.fileWrite("C:\\Users\\vdunga\\Desktop\\keys.txt", ivp.toString());
				

				
			}

			public static String encrypt(String plainText, SecretKey secretKey,IvParameterSpec ivp)
					throws Exception {
				Cipher cipher;
				cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
				byte[] plainTextByte = plainText.getBytes();
				cipher.init(Cipher.ENCRYPT_MODE, secretKey,ivp);
				byte[] encryptedByte = cipher.doFinal(plainTextByte);
				Base64.Encoder encoder = Base64.getEncoder();
				String encryptedText = encoder.encodeToString(encryptedByte);
				return encryptedText;
			}

			
	}



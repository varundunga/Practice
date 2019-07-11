package encryption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

import org.codehaus.plexus.util.FileUtils;

public class Encryption {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Enter encryption algorithm(AES/RSA):");
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String algType=reader.readLine();
		while(!(algType.equalsIgnoreCase("AES")||algType.equalsIgnoreCase("RSA")))
		{
			System.out.println("Enter encryption algorithm(AES/RSA):");
			reader=new BufferedReader(new InputStreamReader(System.in));
			algType=reader.readLine();
		}
		System.out.println("Enter data to encrypt:");
		BufferedReader reader1=new BufferedReader(new InputStreamReader(System.in));
		String plainText=reader.readLine();
		if(algType.equalsIgnoreCase("AES"))
		
			Aes.aesEnc(plainText);
		
		else
			Rsa.rsaEnc(plainText);
		
		//System.out.println(keys);
	}

}

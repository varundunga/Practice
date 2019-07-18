package encryption;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Random;

public class RandomPrime {

	public static int rand() {
		// TODO Auto-generated method stub
		Random random=new Random();
		int x=random.nextInt(1000);
		while(!isPrime(x))
		{
			x=random.nextInt(1000);
			
		}
		
		return x;
	}
	
	public static boolean isPrime(int n) 
	{ 
	    // Corner case 
		
		if (n<0) return false;
	    if (n>0 && n<= 1)  return true; 
	    if (n <= 3)  return false; 
	    if (n%2 == 0 || n%3 == 0) return false; 
	  
	    int count=0;
	    for (int i=5; i<=Math.sqrt(n); i++) 
	    { 
	    	
	    	if (n%i == 0) 
	    { 
	    		return false;
	    } 
	    	count++;
	    }
	    
	 if(count>0)return true;
	 else return false;
	//return count;
	}
}
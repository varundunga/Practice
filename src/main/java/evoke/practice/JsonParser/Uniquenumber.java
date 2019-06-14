package evoke.practice.JsonParser;

import java.util.HashMap;

public class Uniquenumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,0,2,1,2,9,1,9,0};		
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
 	for(int i=0;i<a.length;i++)
		{			
			if(hm.containsKey(a[i]))
			{					
			hm.put(a[i],hm.get(a[i])+1);	
			}	
			else
				hm.put(a[i], 1);				
		} 
		hm.forEach((k,v)->{
		System.out.println(k+"-"+v);});
		StringBuffer sbf=new StringBuffer("abc");
		
	}
}

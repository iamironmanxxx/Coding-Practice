/*
	escape the night
	link : https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/escape-the-night/
	
	print sum of all numbers with two set bits upto given number n

*/

import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		long max=(long)Math.pow(10,18);
		long sum=0;
		long mod=1000000007;
		int ptr=0;
		Map<Long,Long> map=new HashMap<>();
		for(int i=1;i<64;i++)
		{
			for(int j=0;j<i;j++)
			{
			    long no=((1l<<i)+(1l<<j));
			    
			    sum=(sum+no%mod)%mod;
			    map.put(no,sum);
			}
		}
		int t=in.nextInt();
		for(int i=0;i<t;i++)
		{
		    long n=in.nextLong();
		    if(n<3)
		    {
		        System.out.println(0);
		    }
		    else
		    {
    		    long n1,n2,n3;
    		    if((n%(1l<<log(n)))==0)
    		    {
    		        
    		        n--;
    		        //System.out.println("n= "+n);
    		    }
    		    n1=1l<<log(n);
    		    //System.out.println("n1= "+n1);
    		    n%=1l<<log(n);
    		    //System.out.println("n= "+n);
    		    n2=1l<<log(n);
    		    //System.out.println("n2= "+n2);
    		    n3=(n1+n2);
    		    System.out.println(map.get(n3));
		    }
		}
	}
	public static long log(long n)
	{
	    return (long) Math.floor ( Math.log(n) / Math.log(2) ) ;
	}
}

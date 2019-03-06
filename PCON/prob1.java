import java.util.*;
class Abc
{
    public static void main(String args[])
    {
    	long a,b,k;
    	long x=gcd(a,b);
    	System.out.println(k*x);
    }
    static long hcf;
    public static long gcd(long a,long b)
    {
    	if(b==0)
    	{
    		hcf=a;
    	}
    	else
    	{
    		gcd(b,b%a);
    	}
    	return hcf;
    }
}
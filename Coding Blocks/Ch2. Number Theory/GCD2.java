import java.util.*;
import java.io.*;
class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0)
		{
			int divider=in.nextInt();
			String s=in.next();
			int ar[]=new int[251];
			for(int i=0;i<=s.length();i++)
			{
				if(i==s.length())
				{
					ar[i]=-1;
					break;
				}
				ar[i]=Integer.parseInt(""+s.charAt(i));
			}
			int b=mod(ar,divider);
			//System.out.println(b);
			System.out.println(gcd(divider,b));
		}
	}
	public static int gcd(int a,int b)
	{
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	}
	public static int mod(int ar[],int divider)
	{
		int r=0;
		for(int i=0;ar[i]!=-1;i++)
		{
			r=10*r+ar[i];
			r%=divider;
			//System.out.print(r+" ");
		}
		return r;
	}
}
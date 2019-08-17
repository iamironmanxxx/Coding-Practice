import java.io.*;
import java.util.*;
class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0)
		{
			int n,k;
			n=in.nextInt();
			k=in.nextInt();
			System.out.println(pow(k,n-k));
		}
	}
	public static long pow(long n,int k)
	{
		long result=1;
		while(k>0)
		{
			if(k%2==1)
			{
				result*=n;
			}
			n=n*n;
			k/=2;
		}
		return result;
	}
}
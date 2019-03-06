import java.util.*;
import java.io.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t--!=0)
		{
			double r,g;
			r=in.nextInt();
			g=in.nextInt();
			int len=(int)((g-1)/2)+1;;
			double dp[]=new double[len];
			dp[0]=1;
			for(int i=1;i<len;i++)
			{
				dp[i]=dp[i-1]*((g-2*(i-1))/(r+g-2*(i-1))*((g-(2*(i-1)+1))/(r+g-(2*(i-1)+1))));
			}
			double sum=0;
			for(int i=0;i<len;i++)
			{
				sum+=dp[i]*(r/(r+g-2*(i)));
				//System.out.println(sum);
			}
			String res=String.format("%.6f",sum);
			System.out.println(res);
		}
	}
}
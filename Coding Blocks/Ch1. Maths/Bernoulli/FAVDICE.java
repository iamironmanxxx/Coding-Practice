import java.util.*;
import java.io.*;
class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0)
		{
			int n=in.nextInt();
			double ans=0;
			for(int i=1;i<=n;i++)
			{
				ans+=(1/(double)i);
			}
			ans*=n;
			System.out.println(String.format("%.2f",ans));
		}
	}
}
import java.util.*;
import java.io.*;
class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		int limit=500000+2;
		long sum[]=new long[limit];
		for(int i=1;i<limit;i++)
		{
			for(int j=2*i;j<limit;j+=i)
			{
				sum[j]+=i;
			}
		}
		PrintWriter pw=new PrintWriter(System.out);
		while(t-->0)
		{
			int n=in.nextInt();
			pw.println(sum[n]);
		}
		pw.close();
	}
}
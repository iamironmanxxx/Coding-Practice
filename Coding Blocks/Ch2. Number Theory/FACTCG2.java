import java.util.*;
import java.io.*;
class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int limit=1000002;
		ArrayList<Integer> primes=new ArrayList<>();
		int f[]=new int[limit];
		for(int i=2;i<=Math.sqrt(limit);i++)
		{
			if(f[i]==0)
			{
				for(int j=i*i;j<limit;j+=i)
				{
					f[j]=i;
				}
			}
		}
		while(in.hasNext())
		{
			int n=in.nextInt();
			int dup=n;
			//pw.println(f[n]);
			if(n==1)
			{
				pw.print("1\n");
				continue;
			}
			pw.print("1");
			while(f[n]!=0&&n%f[n]==0)
			{
				pw.print(" x "+f[n]);
				n/=f[n];
			}
			pw.print(" x "+n);
			pw.println();
		}
		pw.close();
	}
}
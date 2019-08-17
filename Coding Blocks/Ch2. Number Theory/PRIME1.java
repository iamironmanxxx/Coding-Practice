import java.util.*;
import java.io.*;
class Abc
{
	static int limit=1000000002;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		ArrayList<Integer> primes=new ArrayList<>();
		int lim=(int)Math.sqrt(limit);
		int f[]=new int[lim+1];
		for(int i=3;i<=Math.sqrt(lim);i+=2)
		{
			if(f[i]==0)
			{
				for(int j=i*i;j<=lim;j+=2*i)
				{
					f[j]=1;
				}
			}
		}
		primes.add(2);
		for(int i=3;i<f.length;i+=2)
		{
			if(f[i]==0)
			{
				primes.add(i);
			}
		}



		int t=in.nextInt();
		while(t-->0)
		{
			int m,n;
			m=in.nextInt();
			n=in.nextInt();
			int ar[]=new int[n-m+1];
			for(int i=m;i<=n;i++)
			{
				if(i!=2&&i%2==0)
				{
					ar[i-m]=1;
				}
			}
			for(int i=0;(i<primes.size()&&primes.get(i)<=n);i++)
			{
				int prime=primes.get(i);
				for(int j=m;j<=n;j++)
				{
					if(prime==j)
						continue;
					//pw.println("No. "+j);
					if(j%prime==0||j==1)
					{
						ar[j-m]=1;
					}
				}
			}
			for(int i=0;i<ar.length;i++)
			{
				if(ar[i]==0)
				{
					pw.println((i+m)+" ");
				}
			}
			pw.println();
		}
		pw.close();
	}
}
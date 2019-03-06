import java.util.*;
import java.io.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			long n,a,b,k;
			n=in.nextLong();
			a=in.nextLong();
			b=in.nextLong();
			k=in.nextLong();
			long count=(n/a)+(n/b)-(2l*(n/(a*b)));
			//System.out.println(count);
			if(a==b)
			{
				pw.print("Lose\n");
				continue;
			}
			if(count>=k)
			{
				pw.print("Win\n");
			}
			else
			{
				pw.print("Lose\n");
			}
		}
		pw.close();
	}
}
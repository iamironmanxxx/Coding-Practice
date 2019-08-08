import java.util.*;
class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		assertion(t,1,100);
		while(t--!=0)
		{
			long n,k;
			n=in.nextLong();
			k=in.nextLong();
			assertion(n,1,ten);
			assertion(k,1,ten);
			long step=0;
			while(n!=0)
			{
				if(n%3==0)
				{
					n/=3;
					step++;
					continue;
				}
				n-=1;
				step++;
			}
			System.out.println(step);
		}
	}
	static long ten=(long)Math.pow(10,18);
	public static void assertion(long a,long b,long c)
	{
		if(a<b||a>c)
			System.exit(0);
	}
}
import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner (System.in);
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			long a,b,c,d,k;
			a=in.nextLong();
			b=in.nextLong();
			c=in.nextLong();
			d=in.nextLong();
			k=in.nextLong();
			long start=0,end=Math.cbrt(k/a),mid=0;
			while(start<=end)
			{
				mid=(start+end)/2;
				if(formula(a,b,c,d,mid)>k)
				{
					end=mid-1;
				}
				else{
					start=mid+1;
				}
			}
			System.out.println(start-1);
		}
	}
	static long formula(long a,long b,long c,long d,long t)
	{
		long res=a*t*t*t+b*t*t+c*t+d;
		return res;
	}
}
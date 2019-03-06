import java.util.*;
class Abc
{
	static int max=1000000;
	public static void main(String args[])
	{
		Scanner in=new Scanner (System.in);
		int n=in.nextInt();
		int ar[]=new int[n];
		int f[]=new int[2*max+1];
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
			f[ar[i]+max]++;
		}	
		Arrays.sort(ar);
		for(int i=0;i<=max;i++)
		{
			if(f[i+max]>0&&f[max-i]==0)
			{
				for(int j=0;j<f[i+max];j++)
				{
					list.add(i);
				}
			}
		}
		Collections.sort(list);
		//System.out.println(list);
		if(list.size()>=3)
		{
			long sum=0;
			long mod=1000000007;
			for(int i=0;ar[i]<list.get(list.size()-3);i++)
			{
				if(ar[i]>0)
				{
					sum=(sum+ar[i])%mod;
				}
			}
			System.out.println(sum);
		}
		else
		{
			System.out.println(0);
		}
	}
}
import java.util.*;
class Abc
{
	static int ar[],n;
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		int q=in.nextInt();
		ar=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		ArrayList<Integer> ind[]=new ArrayList[100001];
		init(ind);
		for(int i=0;i<n;i++)
		{
			ind[ar[i]].add(i);
		}
		process(ind);
		for(int g=0;g<q;g++)
		{
			int x,y;
			x=in.nextInt();
			y=in.nextInt();
			int min=Integer.MAX_VALUE;
			for( int i=0;i<ind[x].size();i++)
			{
				int start=0,end=ind[y].size(),mid=(start+end)/2;
				int s,e;
				int v=ind[x].get(i);
				while(start<end)
				{
					mid=(start+end)/2;
					int st=ind[y].get(start);
					int en=ind[y].get(end-1);
					s=Math.min(Math.abs(st-v),n-Math.abs(st-v))/2;
					e=Math.min(n-Math.abs(en-v),Math.abs(en-v))/2;
					//System.out.println(s+" "+e);
					if(s<=e)
					{
						end=mid;
					}
					else
					{
						start=mid;
					}
				}
				min=Math.min(min,Math.min(n-Math.abs(ind[y].get(start)-v),Math.abs(ind[y].get(start)-v))/2);
			}
			System.out.println(min);

		}

	}
	public static void init(ArrayList<Integer> ar[])
	{
		for(int i=0;i<ar.length;i++)
		{
			ar[i]=new ArrayList<>();
		}
	}
	public static void process(ArrayList<Integer> ar[])
	{
		for(int i=0;i<ar.length;i++)
		{
			int initLen=ar[i].size();
			for(int j=0;j<initLen;j++)
			{
				int v=ar[i].get(j);
				ar[i].add(v);
			}
		}
	}
}
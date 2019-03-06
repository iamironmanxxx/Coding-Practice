import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		int a[]=generate(ar,0,n/2);
		int b[]=generate(ar,n/2,n);
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<b.length;i++)
		{
			if(map.get(b[i])==null)
				map.put(b[i],1);
			else
				map.put(b[i],map.get(b[i])+1);
		}
		long count=0;
		for(int i=0;i<a.length;i++)
		{
			if(map.get(ar[i])!=null)
			count+=map.get(a[i]);
		}
		System.out.println(count-1);
	}
	public static int[] generate(int ar[],int x,int y)
	{
		int res[]=new int[(int)Math.pow(2,y-x)];
		//System.out.println("size= "+Math.pow(2,(y-x)));
		int sum;
		for(int i=0;i<(int)Math.pow(2,y-x);i++)
		{
			int dup=i;
			int c=0;
			sum=0;
			while(dup>0)
			{
				if(dup%2==1)
				{
					sum^=ar[x+c];
				}
				dup/=2;
				c++;
			}
			res[i]=sum;
		}
		//System.out.println(Arrays.toString(res));
		return res;
	}
}
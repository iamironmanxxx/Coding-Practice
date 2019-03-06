import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		int n=in.nextInt();
		int ar[]=new int[n];
		int br[]=new int[n];
		int f[]=new int[n];
		int ptr=0;
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
			if(map.get(ar[i])==null)
			{
				br[ptr++]=ar[i];
				map.put(ar[i],1);
			}
			else
			{
				map.put(ar[i],map.get(ar[i])+1);
			}
		}
		Arrays.sort(br,0,ptr-1);
		for(int i=0;i<ptr;i++)
		{
			f[i]=map.get(br[i]);
		}
		int cum[]=new int[n];
		for(int i=ptr-2;i>=0;i--)
		{
			cum[i]=cum[i+1]+f[i];
		}
		int q=in.nextInt();
		for(int i=0;i<q;i++)
		{
			int ch=in.nextInt();
			int x=in.nextInt();
			int start=0,end=ptr-1,mid=0,flag=0;
			while(start<=end)
			{
				mid=(start+end)/2;
				if(br[mid]==x)
				{
					flag=1;
					break;
				}
				else if(br[mid]>x)
				{
					end=mid-1;
				}
				else
				{
					start=mid+1;
				}

			}
			int ans=0;
			if(flag==1)
			{
				if(ch==0)
				{
					ans=cum[mid];
				}
				else
				{
					ans=cum[mid]-f[mid];
				}
			}
			System.out.println(ans);
		}
	}
}
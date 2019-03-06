import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n,t;
		n=in.nextInt();
		t=in.nextInt();
		TreeMap<Integer,Integer> tree=new TreeMap<>();
		for(int i=0;i<n;i++)
		{
			int x=in.nextInt();
			if(tree.get(x)==null)
				tree.put(x,1);
			else
			{
				tree.put(x,tree.get(x)+1);
			}
		}
		int tr[]=new int[t];
		for(int i=0;i<t;i++)
		{
			tr[i]=in.nextInt();
		}
		Arrays.sort(tr);
		for(int i=0;i<t/2;i++)
		{
			tr[i]=tr[i]+tr[t-1-i];
			tr[t-1-i]=tr[i]-tr[t-1-i];
			tr[i]=tr[i]-tr[t-1-i];
		}
		int ptr=t;
		int sum=0;

		while(tree.size()>0)
		{
			for(int i=0;i<ptr;i++)
			{
				if(tree.get(tr[i])!=null)
				{
					if(tree.get(tr[i])==1)
						tree.remove(tr[i]);
					else 
						tree.put(tr[i],tree.get(tr[i])-1);
				}
				else if(tree.lowerKey(tr[i])!=null)
				{
					int lVal=tree.lowerKey(tr[i]);
					if(tree.get(lVal)==1)
						tree.remove(lVal);
					else
					{
						tree.put(lVal,tree.get(lVal)-1);
					}
				}
				else
				{
					ptr--;
				}
			}
			sum+=2;
		}
		System.out.println(sum-1);
	}
}
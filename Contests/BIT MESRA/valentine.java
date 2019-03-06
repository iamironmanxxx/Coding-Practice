import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			String s=in.next();
			int n=in.nextInt();
			int ar[]=new int[n];
			int f[]=new int[10];
			for(int i=0;i<n;i++)
			{
				ar[i]=in.nextInt();
			}
			Deque<Integer> q=new LinkedList<>();
			int tail=0;
			long count=0;
			for(int i=0;i<s.length();i++)
			{
				char c=s.charAt(i);
				if(!find(ar,c-'0'))
				{
					if(isFilled(ar,f,q))
					{
						count+=getCount();
						//System.out.println("Count = "+count);
					}
					q=new LinkedList<>();
					f=new int[10];
					
				}
				else if(q.isEmpty()||(f[c-'0']==0)||(f[c-'0']>0&&q.peekLast()==(c-'0')))
				{
					q.add(c-'0');
					f[c-'0']++;
					//System.out.println("Added "+(c-'0'));
				}
				else
				{	
					if(isFilled(ar,f,q))
					{
						count+=getCount();
						//System.out.println("Count = "+count);
					}
					while(!q.isEmpty()&&f[c-'0']!=0)
					{
						int val=q.poll();
						f[val]--;
						//System.out.println("Removed "+val);
					}
					q.add(c-'0');
					f[c-'0']++;
				}
			}
			if(isFilled(ar,f,q))
			{
				count+=getCount();
			}
			System.out.println(count);
		}
	}
	static long getCount()
	{
		return left*right;
	}
	static long left=0,right=0;
	static boolean find(int ar[],int n)
	{
		int count=0;
		for(int i=0;i<ar.length;i++)
		{
			if(ar[i]==n)
			{
				count=1;
			}
		}
		return (count==0)?false:true;
	}
	public static boolean isFilled(int ar[],int f[],Deque<Integer> q)
	{
		for(int i=0;i<ar.length;i++)
		{
			if(f[ar[i]]==0)
				return false;
		}
		if(q.peek()==q.peekLast())
		{
			if(f[q.peek()]%2==0){
				left=f[q.peek()]/2;
				right=f[q.peek()]+1;
			}
			else
			{
				left=f[q.peek()];
				right=(f[q.peek()]+1)/2;
			}
		}
		else
		{
			left=f[q.peek()];
			right=f[q.peekLast()];
		}
		return true;
	}
}
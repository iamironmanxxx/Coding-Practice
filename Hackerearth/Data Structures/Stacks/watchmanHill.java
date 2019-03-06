import java.util.*;
class Abc
{
	static class Node{
		int x,y;
		Node(int a,int b)
		{
			x=a;
			y=b;
		}
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner (System.in);
		int n=in.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		Stack<Node> st=new Stack<>();
		long count=0;
		for(int i=0;i<n;i++)
		{
			if(st.isEmpty())
			{
				st.push(new Node(ar[i],1));
			}
			else if(st.peek().x>ar[i])
			{
				st.push(new Node(ar[i],1));
			}
			else if(st.peek().x==ar[i])
			{
				st.peek().y++;
			}
			else
			{
				int nCount=0;
				while(!st.isEmpty()&&st.peek().x<ar[i])
				{
					nCount=st.peek().y;
					count+=2*nCount+((nCount-1)*nCount)/2;
					st.pop();
				}
				if(st.isEmpty())
				{
					count-=nCount;
				}
				st.push(new Node(ar[i],1));
			}
		}
		int nCount=0;
		while(!st.isEmpty())
		{
			nCount=st.peek().y;
			count+=(nCount*(nCount-1))/2+nCount;
			st.pop();
		}
		count-=nCount;
		System.out.println(count);
	}
}
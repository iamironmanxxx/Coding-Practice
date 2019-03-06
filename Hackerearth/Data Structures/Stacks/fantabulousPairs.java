import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int ar[]=new int[n];
		int front[]=new int[n];
		int back[]=new int[n];
		int count=0;
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<n;i++)
		{
			if(st.isEmpty())
			{
				back[i]=-1;
				st.push(i);
			}
			else if(st.peek()>ar[i])
			{
				back[i]=st.peek();
				st.push(i);
			}
			else
			{
				while(!st.isEmpty()&&ar[st.peek()]<ar[i])
				{
					//System.out.println(ar[i]+ " , "+ st.peek());
					front[st.peek()]=i;
					st.pop();
				}
				if(!st.isEmpty())
				{
					back[i]=st.peek();
				}
				else
				{
					back[i]=-1;
				}
				st.push(i);
			}
		}
		while(!st.isEmpty())
		{
			front[st.pop()]=-1;
		}
		
		System.out.println(count);
	}
}
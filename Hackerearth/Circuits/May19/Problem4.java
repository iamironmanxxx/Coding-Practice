import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n,m;
		n=in.nextInt();
		int start[]=new int[n];
		int end[]=new int[n];
		int count[]=new int[n+1];
		int root=0;
		int parent[]=new int[n];
		Stack<Integer> st=new Stack<>();
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			start[i]=in.nextInt();
			map.put(start[i],i);
			if(start[i]==0)
			{
				root=i;
				parent[root]=-1;
				st.push(root);
			}
		}
		for(int i=0;i<n;i++)
		{
			end[i]=in.nextInt();
			count[end[i]]++;
		}
		for(int i=1;i<n;i++)
		{
			while(count[i]>0)
			{
				count[i]--;
				st.pop();
			}
			parent[map.get(i)]=st.peek();
			st.push(map.get(i));
		}
		for(int i=0;i<n;i++)
		{
			System.out.print(parent[i]+1+" ");
		}
	}
}
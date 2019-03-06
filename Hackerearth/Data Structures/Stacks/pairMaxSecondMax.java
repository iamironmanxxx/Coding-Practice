import java.util.*;
class Abc
{
	static class Node{
		int x,y;
		Node(int x,int y){
			this.x=Math.max(x,y);
			this.y=Math.min(x,y);
		}
		public boolean equals(Object a)
		{
			if(this==a)
				return true;
			else if(a.getClass()!=this.getClass())
				return false;
			Node node=(Node)a;
			if(node.x==x&&node.y==y)
				return true;
			return false;
		}
		public int hashCode(){
			return 100000*x+y;
		}
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		Stack<Integer> st=new Stack<>();
		Map<Node,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			if(st.isEmpty())
			{
				st.push(ar[i]);
			}
			else if(st.peek()>ar[i])
			{
				Node node=new Node(st.peek(),ar[i]);
				map.put(node,1);
				//System.out.println(node.x+" "+node.y);
				st.push(ar[i]);
			}
			else
			{
				while(!st.isEmpty()&&ar[i]>st.peek())
				{
					Node node=new Node(st.peek(),ar[i]);
					map.put(node,1);
					//System.out.println(node.x+" "+node.y);
					st.pop();
				}
				if(!st.isEmpty()){
					Node node=new Node(st.peek(),ar[i]);
					map.put(new Node(st.peek(),ar[i]),1);
					//System.out.println(node.x+" "+node.y);
				}
				st.push(ar[i]);
			}
		}
		System.out.println(map.size());
	}
}
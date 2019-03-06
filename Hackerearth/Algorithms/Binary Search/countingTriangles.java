import java.util.*;
import java.io.*;
class Abc
{
	static class Node
	{
		long x,y,z;
		public Node(long ar[]){
			Arrays.sort(ar);
			x=ar[0];
			y=ar[1];
			z=ar[2];
		}
		public boolean equals(Object obj)
		{
			if(this==obj){
				return true;
			}
			if(obj.getClass()!=this.getClass())
			{
				return false;
			}
			Node node=(Node)obj;
			if(node.x==x&&node.y==y&&node.z==z)
			{
				return true;
			}
			return false;
		}
		long mod=1000000007;
		public int hashCode()
		{
			return (int)((x+y+z)%mod);
		}
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		Map <Node,Integer> map=new HashMap <>();
		for(int g=0;g<t;g++)
		{
			long a,b,c;
			a=in.nextLong();
			b=in.nextLong();
			c=in.nextLong();
			long ar[]={a,b,c};
			Node n=new Node(ar);
			if(map.get(n)==null)
			{
				map.put(n,1);
			}
			else
			{
				map.put(n,map.get(n)+1);
			}
		}
		long sum=0;
		for(Map.Entry<Node,Integer> entry: map.entrySet())
		{
			if(entry.getValue()==1)
			{
				sum++;
			}
		}
		System.out.println(sum);
	}
}
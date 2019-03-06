import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		if(n==1)
		{
			System.out.println(1);
		}
		else
		{
			BFS(n);
		}
	}
	public static void BFS(int s)
	{
		Queue<Integer> q=new LinkedList<>();
		q.add(s);
		Map<Integer,Integer> map=new HashMap<>();
		Map<Integer,Integer> pi=new HashMap<>();
		map.put(s,0);
		Outer: while(!q.isEmpty())
		{
			int u=q.poll();
			for(int i=1;i<s&&i<=9;i++)
			{
				int v=u-i;
				if(v>0&&map.get(v)==null)
				{
					//ystem.out.println("Putting "+v);
					pi.put(v,u);
					map.put(v,map.get(u)+1);
					q.add(v);
				}
				else if(v==0)
				{
					pi.put(v,u);
					map.put(v,map.get(u)+1);
					System.out.println(map.get(v));
					while(pi.get(v)!=null)
					{
						int w=pi.get(v);
						System.out.print(w-v+" ");
						v=w;
					}
					System.out.println("");
					break Outer;
				}
			}
		}
	}
}
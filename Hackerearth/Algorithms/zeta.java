/*
    find maximum weight shortest path between two nodes

*/
import java.util.*;
class Zeta
{
	static int checked[][];
	static int cost[][];
	static int d[][];
	static int ar[][];
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		
		int n,m;
		n=in.nextInt();
		m=in.nextInt();
		ar=new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				String inp=in.next();
				if(inp.equals("*"))
				{
					ar[i][j]=-1;
				}
				else
				{
					ar[i][j]=Integer.parseInt(inp);
				}
			}
		}
		//print(ar);
		int x,y;
		x=in.nextInt();
		y=in.nextInt();
		x--;
		y--;
		checked=new int[n][m];
		cost=new int[n][m];
		d=new int[n][m];
		BFS(ar,x,y);
		int q=in.nextInt();
		for(int i=0;i<q;i++)
		{
			int tx,ty;
			tx=in.nextInt();
			ty=in.nextInt();
			tx--;
			ty--;
			if((ar[tx][ty]==-1)||(cost[tx][ty]==0))
			{
				System.out.println("-1 -1");
			}
			else 
			{
				System.out.println(d[tx][ty]+" "+cost[tx][ty]);
			}
		}
	}
	static class Node{
		int x,y;
		public Node(int a,int b)
		{
			x=a;
			y=b;
		}
	}
	public static void BFS(int ar[][],int x,int y)
	{
		int n=ar.length;
		int m=ar[0].length;
		Node s=new Node(x,y);
		checked[x][y]=1;
		cost[x][y]=ar[x][y];
		Queue<Node> q=new LinkedList<>();
		q.add(s);
		while(!q.isEmpty())
		{
			Node u=q.poll();
			ArrayList<Node> list=new ArrayList<>();
			for(int i=-1;i<2;i++)
			{
				for(int j=-1;j<2;j++)
				{
					int x1=u.x+i;
					int y1=u.y+j;
					if(x1>=0&&x1<n&&y1<m&&y1>=0&&(i==0||j==0))
					{
						if(ar[x1][y1]!=-1)
						{
						    if(checked[x1][y1]==0)
						    {
    							checked[x1][y1]=1;
    							d[x1][y1]=d[u.x][u.y]+1;
    							cost[x1][y1]=ar[x1][y1]+cost[u.x][u.y];
    							q.add(new Node(x1,y1));
						    }
						    else if(d[x1][y1]==d[u.x][u.y]+1)
						    {
						        if(cost[x1][y1]<cost[u.x][u.y]+ar[x1][y1])
						        {
						            cost[x1][y1]=cost[u.x][u.y]+ar[x1][y1];
						        }
						    }
						}
					}
				}
			}
		}
	}
	public static void print(int ar[][])
	{
		for(int i=0;i<ar.length;i++)
		{
			for(int j=0;j<ar[0].length;j++)
			{
				System.out.print(ar[i][j]);
			}
			System.out.println();
		}
	}
}

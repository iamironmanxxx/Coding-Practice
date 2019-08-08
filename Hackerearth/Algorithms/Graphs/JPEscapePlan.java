import java.io.*;
import java.util.*;
class Abc implements Runnable
{
	static class Node{
		int x,y;
		public Node(int a,int b)
		{
			x=a;
			y=b;
		}
	}
	static boolean flag=false;
	public static void DFS(int ar[][],int n,int m,int sx,int sy,int j,int visited[][],ArrayList<Node> list)
	{
		if(sx==0||sy==0||sx==n-1||sy==m-1)
		{
			if(flag)
					return;
			System.out.println("YES");
			flag=true;
			System.out.println(list.size());
			for (int i=0;i<list.size();i++)
			{
				Node node=list.get(i);
				System.out.println(node.x+" "+node.y);
			}
		}
		else
		{
			for(int i=-1;i<2;i++)
			{
				for (int k=-1;k<2;k++)
				{
					if(Math.abs(i)+Math.abs(k)==1)
					{
						int x,y;
						x=sx+i;
						y=sy+k;
						if(x>=0&&x<n&&y>=0&&y<m&&visited[x][y]==0)
						{
							int hDiff=ar[sx][sy]-ar[x][y];
							if(hDiff>=0&&hDiff<=j)
							{
								visited[x][y]=1;
								list.add(new Node(x+1,y+1));
								DFS(ar,n,m,x,y,j,visited,list);
								list.remove(list.size()-1);
							}
						}
					}
				}
			}
		}
	}
	public static void main(String args[])
	{
		new Thread(null,new Abc(),"Abc",1<<26).start();
	}
	public void run()
	{
		Scanner in=new Scanner(System.in);
		int n,m;
		n=in.nextInt();
		m=in.nextInt();
		int ar[][]=new int[n][m];
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<m;j++)
			{
				ar[i][j]=in.nextInt();
			}
		}
		int dx,dy,j;
		dx=in.nextInt();
		dy=in.nextInt();
		j=in.nextInt();
		int visited[][]=new int[n][m];
		visited[dx-1][dy-1]=1;
		flag=false;
		ArrayList<Node> list=new ArrayList<>();
		list.add(new Node(dx,dy));
		DFS(ar,n,m,dx-1,dy-1,j,visited,list);
		if(!flag)
			System.out.println("NO");

	}
}
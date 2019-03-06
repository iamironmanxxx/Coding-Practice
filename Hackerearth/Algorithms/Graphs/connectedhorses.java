import java.util.*;
class Abc
{
    static int mod=1000000007;
    static long f[]=new long[1000001];
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int g=0;g<t;g++)
        {
            int n,m,q;
            n=in.nextInt();
            m=in.nextInt();
            q=in.nextInt();
            int ar[][]=new int[n][m];
            int visited[][]=new int [q][3];
            for(int i=0;i<q;i++)
            {
                int a,b;
                a=in.nextInt();
                b=in.nextInt();
                a--;
                b--;
                ar[a][b]=i+1;
                visited[i][1]=a;
                visited[i][2]=b;
            }
            int count=0;
            for(int i=0;i<q;i++)
            {
                if(visited[i][0]==0)
                {
                    count++;
                    visited[i][0]=count;
                    DFS(ar,visited,visited[i][1],visited[i][2],count);
                }
                
            }
            int group[]=new int[count];
            for(int i=0;i<q;i++)
            {
                group[visited[i][0]-1]++;
            }
            long prod=1;
            for(int i=0;i<count;i++)
            {
                prod=(prod*fact(group[i]))%mod;
            }
            System.out.println(prod);
        }
    }
    public static void DFS(int ar[][],int visited[][],int x,int y,int count)
    {
        int n=ar.length;
        int m=ar[0].length;
        for(int i=-2;i<3;i++)
        {
            for(int j=-2;j<3;j++)
            {
                int x1=x+i;
                int y1=y+j;
                if((i!=0&&j!=0)&&x1>=0&&x1<n&&y1<m&&y1>=0)
                {
			if(ar[x1][y1]!=0){
		            if(visited[ar[x1][y1]-1][0]==0)
		            {
		                visited[ar[x1][y1]-1][0]=count;
		                DFS(ar,visited,x1,y1,count);
		            }
			}
                }
            }
        }
    }
    public static long fact(int n)
    {
        if(f[n]==0)
        {
            f[n]=(n*f[n-1])%mod;
        }
        return f[n];
    }
}

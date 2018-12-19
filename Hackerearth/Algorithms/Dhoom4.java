import java.util.*;
class Dhoom4
{
    static int visited[]=new int[100001];
    static int d[]=new int[100001];
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int s,l;
        int n;
        s=in.nextInt();
        l=in.nextInt();
        n=in.nextInt();
        int ar[]=new int[n];
        for(int i=0;i<n;i++)
        {
            ar[i]=in.nextInt();
        }
        Queue<Integer> q=new LinkedList<>();
        visited[s]=1;
        q.add(s);
        int c=0;
        while(!q.isEmpty())
        {
            int u=q.poll();
            if(u==l)
            {
                c=1;
                break;
            }
            for(int i=0;i<n;i++)
            {
                int v=(100000+(u*ar[i])%100000)%100000;
                if(visited[v]==0)
                {
                    visited[v]=1;
                    d[v]=d[u]+1;
                    q.add(v);
                }
            }
        }
        if(c==1)
        {
            System.out.println(d[l]);
        }
        else
        {
            System.out.println(-1);
        }
    }
}

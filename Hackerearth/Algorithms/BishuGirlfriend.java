import java.util.*;
class BishuGirfriend
{
    static int d[];
    static int color[];
    public static void main(String argsp[])
    {
        Scanner in=new Scanner (System.in);
        int n=in.nextInt();
        ArrayList<Integer> ar[]=new ArrayList[n];
        color=new int[n];
        d=new int[n];
        for(int i=0;i<n-1;i++)
        {
            int a,b;
            a=in.nextInt();
            b=in.nextInt();
            a--;
            b--;
            if(ar[a]==null)
            {
                ar[a]=new ArrayList<>();
            }
            if(ar[b]==null)
            {
                ar[b]=new ArrayList<>();
            }
            ar[a].add(b);
            ar[b].add(a);
        }
        BFS(ar,0);
        int min=Integer.MAX_VALUE;
        int ind=1;
        int q=in.nextInt();
        for(int i=0;i<q;i++)
        {
            int x=in.nextInt();
            if(d[x-1]<min)
            {
                min=d[x-1];
                ind =x;
            }
        }
        System.out.println(ind);
    }
    public static void BFS(ArrayList<Integer> ar[],int s)
    {
        d[s]=0;
        color[s]=1;
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        while(!q.isEmpty())
        {
            int u=q.poll();
            for(int i=0;ar[u]!=null&&i<ar[u].size();i++)
            {
                int j=ar[u].get(i);
                if(color[j]==0)
                {
                    color[j]=1;
                    d[j]=d[u]+1;
                    q.add(j);
                }
            }
        }
    }
}

import java.util.*;
class FlightPlan
{
    static int color[];
    static int d[];
    static int pi[];
    static final int WHITE=0;
    static final int GRAY=1;
    static final int BLACK=2;
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int n,m,t,c;
        n=in.nextInt();
        m=in.nextInt();
        t=in.nextInt();
        c=in.nextInt();
        color=new int[n];
        d=new int[n];
        pi=new int[n];
        ArrayList<Integer> ar[]=new ArrayList[n];
        for(int i=0;i<m;i++)
        {
            int a,b;
            a=in.nextInt();
            b=in.nextInt();
            if(ar[a-1]==null)
            {
                ar[a-1]=new ArrayList<>();
            }
            if(ar[b-1]==null)
            {
                ar[b-1]=new ArrayList<>();
            }
            ar[a-1].add(b-1);
            ar[b-1].add(a-1);
        }
        int x,y;
        x=in.nextInt();
        y=in.nextInt();
        x--;
        y--;
        for(int i=0;i<n;i++)
        {
            if(ar[i]!=null)
            {
                Collections.sort(ar[i],new Comparator<Integer>(){
		        @Override
                    public int compare(Integer a,Integer b)
                    {
                        if(a<b)
                            return -1;
                        else if(a>b)
                            return 1;
                        return 0;
                    }
                });
            }
        }
        BFS(ar,x);
        System.out.println(d[y]);
        Stack<Integer> st=new Stack<>();
        int parent=pi[y];
        st.push(y);
        while(parent!=-1)
        {
            st.push(parent);
            parent=pi[parent];
        }
        while(!st.isEmpty())
        {
            System.out.print((st.pop()+1)+" ");
        }
        System.out.println();
    }
    public static void BFS(ArrayList<Integer> ar[],int s)
    {
        color[s]=GRAY;
        d[s]=1;
        pi[s]=-1;
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        while(!q.isEmpty())
        {
            int u=q.poll();
            for(int i=0;i<ar[u].size();i++)
            {
                if(color[ar[u].get(i)]==WHITE)
                {
                    color[ar[u].get(i)]=GRAY;
                    d[ar[u].get(i)]=d[u]+1;
                    pi[ar[u].get(i)]=u;
                    q.add(ar[u].get(i));
                }
            }
            color[u]=BLACK;
        }
    }
}

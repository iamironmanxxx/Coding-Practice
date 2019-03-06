/*
	Learning graph - print kth node adjacent to a given node


*/
import java.util.*;
class LearnGraph
{
    public static int val[];
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int n,m,k;
        n=in.nextInt();
        m=in.nextInt();
        k=in.nextInt();
        val=new int[n];
        for(int i=0;i<n;i++)
        {
            val[i]=in.nextInt();
        }
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<m;i++)
        {
            int a,b;
            a=in.nextInt();
            b=in.nextInt();
	    if(adj[a-1]==null)
	    {
		    adj[a-1]=new ArrayList<>();
	    }
	    if(adj[b-1]==null)
	    {
		    adj[b-1]=new ArrayList<>();
	    }
            adj[a-1].add(b-1);
            adj[b-1].add(a-1);
        }
        for(int i=0;i<n;i++)
        {
            if(adj[i]!=null)
            {
                Collections.sort(adj[i],new Comparator<Integer>(){
		            @Override			
		            public int compare(Integer a,Integer b)
			        {
				        if(val[a]<val[b])
					        return 1;
				        else if(val[b]<val[a])
					        return -1;
				        else
				        {
				            if(a<b)
				                return 1;
				            else 
				                return -1;
				        }
			        }		
	        	 });
            }
        }
        for(int i=0;i<n;i++)
        {
            if(adj[i]!=null)
                System.out.println(adj[i].get(k-1)+1);
            else
                System.out.println(-1);
        }
    }
}

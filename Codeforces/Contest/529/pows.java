import java.util.*;
public class Powers
{
    static HashMap<Integer,Integer> map=new HashMap<>();
    static boolean res=false;
    static ArrayList<Integer> ar=new ArrayList<>();
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        //map.put(n,1);
        DFS(n,k);
        if(res){
            System.out.println("YES");
            for(int i=0;i<ar.size();i++)
            {
                System.out.print(ar.get(i)+" ");
            }
            System.out.println();
        }
        else
            System.out.println("NO");
    }
    static void DFS(int n,int k)
    {
        //System.out.println(n+" "+k);
        if(k==0&&n==0)
        {
            res=true;
        }
        else if(n>0&&k>0&&map.get(n)==null)
        {
            map.put(n,1);
            int max=(int)(Math.pow(2,Math.floor(Math.log(n)/Math.log(2))));
            //System.out.println(max);
		if(n-(k*max)<=0)
		{
		    for(int i=1;i<=max;i*=2)
		    {
		        DFS(n-i,k-1);
		        if(res)
		        {
		            ar.add(i);
		            break;
		        }
		    }
		}
        }
        
    }
}


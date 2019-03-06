/* package codechef; // don't place package name! */

import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class DPAIRS
{
	public static void main (String[] args) 
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		Map<Integer,Integer> a=new HashMap<>();
		Map<Integer,Integer> b=new HashMap<>();
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++)
		{
		    a.put(in.nextInt(),i);
		}
		for(int i=0;i<m;i++)
		{
		    b.put(in.nextInt(),i);
		}
		int count=0;
		Outer : for(Map.Entry<Integer,Integer> x:a.entrySet())
		{
		    for(Map.Entry<Integer,Integer> y:b.entrySet())
		    {
		        if(map.get(x.getKey()+y.getKey())==null)
		        {
		            count++;
		            map.put(x.getKey()+y.getKey(),1);
		            System.out.println(x.getValue()+" "+y.getValue());
		            if(count==n+m-1)
		            {
		                break Outer;
		            }
		        }
		    }
		}
	}
}


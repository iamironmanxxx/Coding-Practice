import java.io.*;
import java.util.*;
class Abc
{
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int n=in.nextInt();
		long ar[][]=new long[n][2];
		for(int i=0;i<n;i++)
		{
			ar[i][0]=in.nextInt();
			ar[i][1]=in.nextInt();
		}
		int q=in.nextInt();
		Node qr[]=new Node[q];
		Map<Node,Integer> map=new HashMap<>();
		for(int g=0;g<q;g++)
		{
			int a=in.nextInt();
			int b=in.nextInt();
			a--;
			b--;
			qr[g]=new Node(a,b);
			map.put(qr[g],g);
		}
		Arrays.sort(qr,new Comparator<Node>(){
			public int compare(Node a,Node b)
			{
				if(a.x<b.x)
				{
					return -1;
				}
				else if(a.x>b.x)
				{
					return 1;
				}
				else
				{
					if(a.y<b.y)
					{
						return -1;
					}
					else if(a.y>b.y)
					{
						return 1;
					}
					else
					{
						return 0;
					}
				}
			}
		});
		int ans[]=new int[n];
		for(int i=0;i<n;i++)
		{
			int max=0;
			for(int j=i;j<n;j++)
			{
				long A,B;
				A=(ar[i][0]-ar[j][0])*(ar[i][0]-ar[j][0]);
				B=(ar[i][1]-ar[j][1])*(ar[i][1]-ar[j][1]);
				long x=A+B;
			}
		}
	}
	static class Node{
		int x,y;
		Node(int a,int b)
		{
			x=a;
			y=b;
		}
		public boolean equals(Object obj)
		{
			if(this==obj)
				return true;
			if(obj==null||obj.getClass()==getClass()) 
			Node a=(Node)obj;
			if(a.x==x&&a.y==y)
			{
				return true;
			}
			return false;

		}
		public int hashCode()
		{
			return x*2*100000+y;
		}

	}
}
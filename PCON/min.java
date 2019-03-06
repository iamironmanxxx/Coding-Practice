import java.util.*;
import java.io.*;
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
	static int min;
	static int x,y;
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			min=Integer.MAX_VALUE;
			int n=in.nextInt();
			int k=in.nextInt();
			int ar[]=new int[n];
			for(int i=0;i<n;i++)
			{
				ar[i]=in.nextInt();
			}
			Arrays.sort(ar);
			int flag=0;
			for(int i=0;i<n;i++)
			{
				int start=i+1,end=n-1,mid=0;
				while(start<=end)
				{
					mid=(start+end)/2;
					int diff=Math.abs(ar[i]-ar[mid]);
					if(diff<k)
					{
						start=mid+1;
					}
					else
					{
						end=mid-1;
						flag=1;
						if(diff<min)
						{
							min=diff;
							x=ar[i];
							y=ar[mid];
						}else if(diff==min)
						{
							if((x+y)<(ar[i]+ar[mid]))
							{
								x=ar[i];
								y=ar[mid];
							}
						}
					}
				}
			}
			if(flag==0)
			{
				System.out.println(-1);
			}
			else
			{
				System.out.println(x+" "+y);
			}
		}
	}
}
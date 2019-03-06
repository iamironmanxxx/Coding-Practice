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
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int n=in.nextInt();
		int ar[]=new int[n];
		int br[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
			br[i]=ar[i];
		}
		int expectedIntem=1;
		int count=0;
		Stack<Integer> st=new Stack<>();
		for(int i=n-1;i>0;i--)
		{
			if(ar[i]<ar[i-1])
			{
				count=i;
				break;
			}
		}
		System.out.println(count);
	}
}
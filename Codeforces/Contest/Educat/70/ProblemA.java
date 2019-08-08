import java.io.*;
import java.util.*;
public class Solution
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
    public static void main(String[] args) 
    {
    	FastReader in=new FastReader();
    	int t=in.nextInt();
    	assertion(t,1,100);
    	while(t-->0)
    	{
    		String x,y;
    		x=in.next();
    		y=in.next();
    		assertion(x,100000);
    		assertion(y,100000);
    		int setY=firstSet(y);
    		int setX=nextSet(x,setY);
    		System.out.println(setX-setY);
    	}
    }
    public static int firstSet(String s)
    {
    	int n=s.length();
    	int pos=0;
    	for(int i=0;i<n;i++)
    	{
    		if(s.charAt(n-i-1)=='1')
    			break;
    		pos++;
    	}
    	return pos;
    }
    public static int nextSet(String s, int x)
    {
    	int n=s.length();
    	int pos=x;
    	for(int i=x;i<n;i++)
    	{
    		if (s.charAt(n-1-i)=='1')
    			break;
    		pos++;
    	}
    	return pos;
    }
    public static void assertion(String s,int a)
    {
    	if(s.length()>a)
    		System.exit(0);
    	for(int i=0;i<s.length();i++)
    	{
    		if (!(s.charAt(i)=='1'||s.charAt(i)=='0'))
    			System.exit(0);
    	}
    }
    public static void assertion(int t,int a,int b)
    {
    	if(t<a||t>b)
    	{
    		System.exit(0);
    	}
    }
}
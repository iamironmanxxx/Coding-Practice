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
    static FastReader in=new FastReader();
    static long max=1000000000;
    public static void main(String args[])
    {
    	int t=in.nextInt();
    	Outer :for(int g=0;g<t;g++)
    	{
    		long xl,yl,xu,yu;
    		long xlyl,xuyu,xuyl,xlyu;
    		xlyl=query(0,0);
    		xuyu=(2*max-query(max,max));
            xuyl=max-query(max,0);
            xlyu=max-query(0,max);
            if(xuyl>=0)
            {
                long res=(xlyl+xuyl)/2;
                yl=query(res,0);
                xl=xlyl-yl;
                xu=xuyl+yl;
                yu=xuyu-xu;
                System.out.println("A "+xl+" "+yl+" "+xu+" "+yu);
                System.out.flush();
                int resp=in.nextInt();
                if(resp<0)
                {
                    break Outer;
                }
            }
            else
            {
                long res=(xlyl+xlyu)/2;
                xl=query(0,res);
                yl=xlyl-xl;
                yu=xlyu+xl;
                xu=xuyu-yu;
                System.out.println("A "+xl+" "+yl+" "+xu+" "+yu);
                System.out.flush();
                int resp=in.nextInt();
                if(resp<0)
                {
                    break Outer;
                }
            }
    		
    	}
    }
    static long query(long a,long b)
    {
    	System.out.println("Q "+a+" "+b);
    	System.out.flush();
    	long dist=in.nextLong();
    	return dist;
    }
}
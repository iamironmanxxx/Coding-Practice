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
    		long xlyl,xuyu;
    		xlyl=query(0,0);
    		xuyu=-(2*max-query(max,max));
    		//d(x1+y1,0)
    		long res=query(xlyl,0);
    		if(res-xlyl<=0)//ie xu > xl+yl
    		{
    			//got yl
    			yl=res;
    			xl=xlyl-yl;
    			long res2=query(0,xlyl);
    			if(res2-xlyl<=0)//yu > yl+xl
    			{
    				//got xl do nothing
    				long res3=query(xuyu,xuyu);
    				
    				
    			}
    			else//yu < yl+xl
    			{
    				//got xl+yl+xl-yu
    				yu=xl-(res2-xlyl);
    				long res3=query(2*(xlyl),0);
    				//will get 2(xl+yl)+yl-xu
    				xu=-(res3-yl-(2*xlyl));
    				System.out.println("A "+xl+" "+yl+" "+xu+" "+yu);
    				System.out.flush();
    				int resp=in.nextInt();
    				if(resp<0)
    				{
    					break Outer;
    				}
    			}
    		}
    		else//ie xu < xl+yl
    		{
    			//got xl+yl+yl-xu as yu > xl+yl
    			long res2=query(0,xlyl);
    			//this will definitely give xl as yu > xl+yl
    			xl=res2;
    			yl=xlyl-xl;
    			xu=yl-(res-xlyl);
    			long res3=query(0,2*xlyl);
    			//will get 2(xl+yl) + xl -yu
    			yu=-(res3-(2*xlyl)-xl);
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
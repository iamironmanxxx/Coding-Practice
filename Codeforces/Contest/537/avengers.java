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
	static short cum[];
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int n,k,a,b;
		n=in.nextInt();
		k=in.nextInt();
		a=in.nextInt();
		b=in.nextInt();
		cum=new short[pow(2,n)];
		for(int i=0;i<k;i++)
		{
			int x=in.nextInt();
			cum[x-1]=1;
		}
		for(int i=1;i<pow(2,n);i++)
		{
			cum[i]=cum[i-1]+cum[i];
		}
		int res=solve(0,pow(2,n)-1,a,b,0);
		System.out.println(res);
	}
	public static int solve(int start,int end,int a,int b,int damage)
	{
		//System.out.println("Coming : "+start+" - "+end+" damage= "+damage);
		int burn1st,burn2nd,div,whole;
		if(end-start>=1)
		{
			burn1st=damage+solve(start,(start+end)/2,a,b,damage);
			burn2nd=damage+solve(((start+end)/2)+1,end,a,b,damage);
			//System.out.println("Coming : "+start+" - "+end);
			//System.out.println("Burn 1st half= "+burn1st);
			//System.out.println("Burn 2nd half= "+burn2nd);
			div=burn2nd+burn1st;
			int na=cum[end]-((start==0)?0:cum[start-1]);
			if(na==0)
			{
				whole=damage+a;
			}
			else
			{
				whole=damage+(na*b*(end-start+1));
			}
			//System.out.println("And whole = "+whole);

			return Math.min(div,whole);
		}
		else 
		{
			if((cum[end]-((start==0)?0:cum[start-1]))==0)
			{
				return damage+a;
			}
			else
			{
				return damage+b;
			}
		}
	}
	static int pow(long a,long b)
	{
		return((int)(Math.pow(a,b)));
	}
}
import java.util.*;
import java.io.*;
public class Abc
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
		assertion(t,1,100000);
		long num=0l;
		Stack<Integer> st=new Stack<>();
		double mul=0;
		int flag=0;
		for(int g=0;g<t;g++)
		{
			String str=in.next();
			if(str.equals("for"))
			{
				int n=in.nextInt();
				assertion(n,1,100);
				mul+=Math.log(n)/Math.log(2);
				st.push(n);
			}
			else if (str.equals("add"))
			{
				if(mul>=32)
				{
					flag=1;
					break;
				}
				else
				{
					num+=(long)(Math.pow(2,mul));
					if(Math.log(num)/Math.log(2)>=32)
					{
						flag=1;
						break;
					}
				}
			}
			else if(str.equals("end"))
			{
				int n=0;
				try
				{
					n=st.pop();
				}
				catch(Exception e)
				{
					System.exit(0);
				}
				mul-=Math.log(n)/Math.log(2);
			}
			else
			{
				System.exit(0);
			}
		}
		if(flag==1)
		{
			System.out.println("OVERFLOW!!!");
		}
		else
		{
			System.out.println(num);
		}
	}
	public static void assertion(long a,long b,long c)
	{
		if(a<b||a>c)
			System.exit(0);
	}
	public static void assertion(String a,String b)
	{

	}
}
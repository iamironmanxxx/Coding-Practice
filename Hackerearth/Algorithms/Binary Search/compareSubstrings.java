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
    static int ar[],br[],qr[],n,q;
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		n=in.nextInt();
		q=in.nextInt();
		ar=new int[n];
		br=new int[n];
        String s,t;
        s=in.next();
        t=in.next();
        for(int i=0;i<s.length();i++)
        {
            ar[i]=s.charAt(i)-'0';
        }
        for(int i=0;i<t.length();i++)
        {
            br[i]=t.charAt(i)-'0';
        }
		qr=new int[q];
		for(int i=0;i<q;i++)
		{
			qr[i]=in.nextInt()-1;
			
		}
		int start=0,end=q-1,mid;
        //System.out.println("Enetering while");
		while(end-start>=0)
		{
			mid=(start+end)/2;
            //System.out.println("Comparing "+mid);
			if(compare(mid))
            {
                //System.out.println("Result true");
                end=mid-1;
            }
            else
            {
                //System.out.println("Result false");
                start=mid+1;
            }
		}
		for(int i=0;i<start;i++)
		{
		    pw.print("NO\n");
		}
		for(int i=start;i<n;i++)
		{
			pw.print("YES\n");
		}
		pw.close();
	}
    static boolean compare(int mid)
    {
        int dup[]=new int[n];
        for(int i=0;i<n;i++)
        {
            dup[i]=br[i];
        }
        for(int i=0;i<=mid;i++)
        {
            dup[qr[i]]=1;
        }
        for(int i=0;i<n;i++)
        {
            if(ar[i]>dup[i])
            {
                return false;
            }
            else if(dup[i]>ar[i])
            {
                return true;
            }
        }
        return true;
    }
}
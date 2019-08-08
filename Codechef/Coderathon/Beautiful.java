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
	static int primes[];
	static int bArray[];
	static int ptr;
	public static void main(String args[])
	{
		PrintWriter pw=new PrintWriter(System.out);
		FastReader in=new FastReader();
		int t=in.nextInt();
		int size=1000001;
		primes=new int[size];
		bArray=new int[size];
		primes[0]=1;
		primes[1]=1;
		for(int i=2;i*i<size;i++)
		{
			if(primes[i]==0)
			{
				for(int j=i*i;j<size;j+=i)
				{
					primes[j]=1;
				}
			}
		}
		HashMap<String,Integer> map=new HashMap<>();
		for(int i=2;i<primes.length;i++)
		{
			if(primes[i]==0)
			{
				String s=getDigitString(i);
				map.put(s,i);
			}
		}
		for(int i=2;i<size;i++)
		{
			String s=getDigitString(i);
			while(s.charAt(0)=='0')
			{
				if(map.get(s)!=null)
				{
					break;
				}
				s=s.substring(1);
			}
			if(map.get(s)!=null)
			{
				bArray[i]=i;
			}
			else
			{
				bArray[i]=bArray[i-1];
			}
		}
		while(t-->0)
		{
			int b=in.nextInt();
			pw.println(bArray[b]);
		}
		//pw.println(primes[57]);
		/*for (int i=2;i<size;i++)
		{
			pw.println(i+" "+bArray[i]);
		}*/

		pw.close();
	}
	public static String getDigitString(int n)
	{
		String s="";
		int ptr=0;
		int ar[]=new int[7];
		while(n>0)
		{
			int digit=n%10;
			ar[ptr++]=digit;
			n/=10;
		}
		Arrays.sort(ar,0,ptr);
		for(int i=0;i<ptr;i++)
		{
			s+=Integer.toString(ar[i]);
		}
		return s;
	}
}
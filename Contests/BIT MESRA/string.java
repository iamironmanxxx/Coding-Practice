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
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			int n=in.nextInt();
			String s=in.next();
			String b="";
			ArrayList<Integer> ar[]=new ArrayList[26];
			for(int i=0;i<26;i++)
			{
				ar[i]=new ArrayList<>();
			}
			for(int i=0;i<n;i++)
			{
				if(ar[s.charAt(i)-'a'].size()==0)
				{
					b=b+s.charAt(i);
				}
				ar[s.charAt(i)-'a'].add(i);
			}
			System.out.println(count(s,b));
		}
	}
	static long count(String a, String b) 
	{ 
	    int m = a.length(); 
	    int n = b.length(); 
	  
	   
	    long lookup[][] = new long[m + 1][n + 1]; 
	  
	    
	    for (int i = 0; i <= n; ++i) 
	        lookup[0][i] = 0; 
	  
	   
	    for (int i = 0; i <= m; ++i) 
	        lookup[i][0] = 1; 
	  
	    
	    for (int i = 1; i <= m; i++) 
	    { 
	        for (int j = 1; j <= n; j++) 
	        { 
	            if (a.charAt(i - 1) == b.charAt(j - 1)) 
	                lookup[i][j] = (lookup[i - 1][j - 1] +  
	                               lookup[i - 1][j])%mod; 
	                  
	            else
	                                lookup[i][j] = lookup[i - 1][j]; 
	        } 
	    } 
	  
	    return lookup[m][n]%mod; 
	} 
	static long mod=1000000007;
      
}
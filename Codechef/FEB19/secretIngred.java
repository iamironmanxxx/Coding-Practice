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
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			int n=in.nextInt();
			int f[][]=new int[n][26];
			for(int i=0;i<n;i++)
			{
				String str=in.next();
				for(int j=0;j<str.length();j++)
				{
					char c=str.charAt(j);
					f[i][c-'a']++;
				}
			}
			int count=0;
			int flag=0;
			for(int j=0;j<26;j++)
			{
				flag=0;
				for(int i=0;i<n;i++)
				{
					if(f[i][j]==0)
					{
						flag=1;
						break;
					}
				}
				if(flag==0)
				{
					count++;
				}
			}
			pw.print(count+"\n");
		}
		pw.close();	
	}
}
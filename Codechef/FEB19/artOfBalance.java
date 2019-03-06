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
		PrintWriter pw=new PrintWriter(System.out);
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			String s=in.next();
			int n=s.length();
			int f[]=new int[26];
			for(int i=0;i<n;i++)
			{
				char c=s.charAt(i);
				f[c-'A']++;
			}
			PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());
			int min=Integer.MAX_VALUE;
			for(int i=0;i<f.length;i++)
			{
				pq.add(f[i]);
			}
			for(int i=1;i<=26;i++)
			{
				if(n/i==0)
				{
					break;
				}
				int limit=n/i;
				if(n%i==0)
				{
					int count=0;
					Stack<Integer> st=new Stack<>();
					//System.out.println(" i = "+i );
					for(int j=0;j<i;j++)
					{
						int val=pq.poll();
						st.push(val);
						if(limit-val>0)
							count+=limit-val;
					}
					count=Math.abs(count);
					if(count<min)
					{
						min=count;
					}
					while(!st.isEmpty()){
						pq.add(st.pop());
					}
				}
			}
			pw.print(min+"\n");
		}
		pw.close();
	}
}
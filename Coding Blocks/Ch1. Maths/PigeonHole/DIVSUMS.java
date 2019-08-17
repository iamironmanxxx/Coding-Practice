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
	static PrintWriter pw=new PrintWriter(System.out);
	public static void main(String[] args) {
		FastReader in=new FastReader();
		int t=in.nextInt();
		while(t-->0)
		{
			int n=in.nextInt();
			/*if(n==1)
			{
				pw.print("1\n1\n");
				continue;
			}*/
			int ar[]=new int[n];
			long sum[]=new long[n+1];
			HashMap<Long,Integer> map=new HashMap<>();
			map.put(0l,0);
			for(int i=0;i<n;i++)
			{
				ar[i]=in.nextInt();
			}
			for(int i=0;i<n;i++)
			{
				sum[i+1]=(i==0)?ar[i]:(sum[i]+ar[i]);
				long remVal=sum[i+1]%n;
				if(map.get(remVal)==null){
					map.put(remVal,i+1);
				}
				else
				{
					pw.println(" Start end :"+map.get(remVal)+" "+(i+1)+" ");
					print(sum);
					print(ar,map.get(remVal),i+1);
					break;
				}
			}
		}
		pw.close();
	}
	public static void print(long ar[])
	{
		for(int i=0;i<ar.length;i++)
		{
			pw.print(ar[i]+ " ");
		}
		pw.println();
	}
	public static void print(int ar[],int start,int end)
	{
		pw.println(end-start);
		for(int i=start+1;i<=end;i++)
		{
			//pw.print(ar[i]+" ");
			pw.print((i)+" ");
		}
		pw.println();
	}
}
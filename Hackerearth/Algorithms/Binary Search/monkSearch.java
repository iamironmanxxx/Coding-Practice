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
		int n=in.nextInt();
		int ar[]=new int[n];
		int br[]=new int[n];
		int f[]=new int[n];
		int ptr=0;
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
			if(map.get(ar[i])==null)
			{
				br[ptr++]=ar[i];
				map.put(ar[i],1);
			}
			else
			{
				map.put(ar[i],map.get(ar[i])+1);
			}
		}
		Arrays.sort(br,0,ptr);
		//System.out.println(Arrays.toString(br));
		for(int i=0;i<ptr;i++)
		{
			f[i]=map.get(br[i]);
		}
		int cum[]=new int[n];
		cum[ptr-1]=f[ptr-1];
		for(int i=ptr-2;i>=0;i--)
		{
			cum[i]=cum[i+1]+f[i];
		}
		int q=in.nextInt();
		for(int i=0;i<q;i++)
		{
			int ch=in.nextInt();
			int x=in.nextInt();
			int start=0,end=ptr-1,mid=0,flag=0;
			while(start<=end)
			{
				mid=(start+end)/2;
				if(br[mid]==x)
				{
					flag=1;
					break;
				}
				else if(br[mid]>x)
				{
					end=mid-1;
				}
				else
				{
					start=mid+1;
				}

			}
			int ans=0;
			if(flag==1)
			{
				if(ch==0)
				{
					ans=cum[mid];
				}
				else
				{
					ans=cum[mid]-f[mid];
				}
			}
			else if(start<ptr)
			{
				if(br[start]<x&&(start+1)<ptr)
				{
					ans=cum[start+1];
				}
				else
				{
					ans=cum[start];
				}
			}
			//System.out.println(Arrays.toString(f));
			//System.out.println(Arrays.toString(cum));
			pw.print(ans+"\n");
		}
		pw.close();
	}
}
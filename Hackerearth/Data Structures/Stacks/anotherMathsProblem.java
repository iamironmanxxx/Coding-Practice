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
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}

		int back[]=new int[n];
		int front[]=new int[n];
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<n;i++)
		{
			if(st.isEmpty())
			{
				back[i]=-1;
				st.push(i);
			}
			else if(ar[st.peek()]>ar[i])
			{
				back[i]=st.peek();
				st.push(i);
			}
			else
			{
				while(!st.isEmpty()&&ar[st.peek()]<ar[i])
				{
					int index=st.pop();
					front[index]=i;
				}
				if(st.isEmpty())
				{
					back[i]=-1;
				}
				else
				{
					back[i]=st.peek();
				}
				st.push(i);
			}
		}
		while(!st.isEmpty())
		{
			int index=st.pop();
			front[index]=n;
			if(!st.isEmpty())
			{
				back[index]=st.peek();
			}
			else
			{
				back[index]=-1;
			}
		}
		//System.out.println(Arrays.toString(back));
		//System.out.println(Arrays.toString(front));
		HashMap<Integer,Long> map=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			long res,bCount,fCount;
			bCount=i-back[i]-1;
			fCount=front[i]-i-1;
			res=bCount+fCount+(fCount*bCount)+1;
			if(map.get(ar[i])==null)
			{
				map.put(ar[i],res);
			}
			else
			{
				map.put(ar[i],map.get(ar[i])+res);
			}
		}

		int q=in.nextInt();
		for(int g=0;g<q;g++)
		{
			int x=in.nextInt();
			pw.print(map.get(x)+"\n");
		}
		pw.close();
	}
}
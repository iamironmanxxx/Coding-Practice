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
	public static void main(String[] args) {
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);

		preprocess();

		int t=in.nextInt();
		int rank=1;
		while(t-->0)
		{
			int n=in.nextInt();
			pw.print("Case "+rank+": ");
			if(answers.get(n)!=null)
				pw.println(answers.get(n));
			else
				pw.println("Not Cube Free");
			rank++;
		}
		pw.close();
	}
	static HashMap<Integer,Integer> answers=new HashMap<>();
	public static void preprocess()
	{
		int limit=1000002;
		int lim=(int)Math.sqrt(limit);
		int f[]=new int[limit];
		for(int i=2;i<=lim;i++)
		{
			if(f[i]==0)
			{
				for(int j=i*i;j<limit;j+=i)
				{
					if(f[j]==0)
						f[j]=i;
				}
			}
		}
		/*for(int i=2;i<20;i++)
		{
			if(f[i]==0)
			{
				System.out.print(i+" ");
			}
		}*/
		//System.out.println();
		answers.put(1,1);
		int count=2;
		for(int i=2;i<limit;i++)
		{
			int n=i;
			Map<Integer,Integer> map=new HashMap<>();
			while(f[n]!=0&&n%f[n]==0)
			{
				if(map.get(f[n])==null)
					map.put(f[n],1);
				else
					map.put(f[n],map.get(f[n])+1);
				n/=f[n];
			}
			if(map.get(n)==null)
				map.put(n,1);
			else
				map.put(n,map.get(n)+1);
			int flag=0;
			for(Map.Entry<Integer,Integer> entry:map.entrySet())
			{
				//System.out.println("For n="+i+" div : "+entry.getKey()+" , "+entry.getValue());
				if(entry.getValue()>=3)
				{
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				answers.put(i,count);
				count++;
			}
		}
	}
}
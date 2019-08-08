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
	public static void main(String args[])
	{
		FastReader in = new FastReader();
		int n,m;
		n=in.nextInt();
		m=in.nextInt();
		int br[][]=new int[m][2];
		for(int i=0;i<m;i++)
		{
			br[i][0]=in.nextInt();
			br[i][1]=in.nextInt();
		}
		int flag=0;
		Outer: for(int g=0;g<2;g++)
		{
			Set<Integer> set=new HashSet<>();
			set.add(0);
			for(int i=1;i<m;i++)
			{
				if(br[i][0]==br[0][g]||br[i][1]==br[0][g])
					set.add(i);
			}
			int lock=0;
			int index=1;
			for(int i=1;i<m;i++)
			{
				if(set.contains(i))
					continue;
				index=i;
			}
			if(set.size()==m)
			{
				flag=1;
				break Outer;
			}
			for(int h=0;h<2;h++)
			{
				Set<Integer> mSet=new HashSet<>();
				mSet.add(index);
				for(int i=1;i<m;i++)
				{
					if(set.contains(i)||i==index)
						continue;
					if(br[i][0]==br[index][h]||br[i][1]==br[index][h])
					{
						mSet.add(i);
					}
				}
				if(mSet.size()+set.size()==m)
				{
					flag=1;
					break Outer;
				}
			}
		}
		if(flag==0)
		{
			System.out.println("NO");
		}
		else
		{
			System.out.println("YES");
		}
	}
}
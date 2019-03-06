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
	static int ar[][];
	static int ptr[];
	static String s;
	static int n;
	static long count=0;
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		n=in.nextInt();
		s=in.next();
		ar=new int[26][n];
		ptr=new int[26];
		for(int i=0;i<n;i++)
		{
			int c=s.charAt(i)-'a';
			ar[c][ptr[c]++]=i;
		}
		/*for(int i=0;i<26;i++)
		{
			if(ptr[i]>0)
				System.out.println(Arrays.toString(ar[i]));
		}*/
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				find(i,j,1);
			}
		}
		System.out.println(count);
	}
	public static void find(int i1,int i2,int flag)
	{
		int c,d;
		c=s.charAt(i1)-'a';
		d=s.charAt(i2)-'a';
		int start=0,end=ptr[c]-1,mid=0;
		while(end-start>0)
		{
			mid=(start+end)/2;
			if(ar[c][mid]==i2+1)
			{
				break;
			}
			else if(ar[c][mid]>i2+1)
			{
				end=mid-1;
			}
			else
			{
				start=mid+1;
			}
			mid=(start+end)/2;
		}
		if(ar[c][mid]<i2+1)
		{
			mid++;
			if(mid>=ptr[c]){
				return;
			}
		}
		//System.out.println("For "+(i2+1)+" Found "+((char)(c+'a'))+" at "+ar[c][mid]);
		if(flag==1)
		{
			for(int i=mid;i<ptr[c];i++)
			{
				//System.out.println("Going for "+s.charAt(i2)+"("+i2+")"+" "+s.charAt(ar[c][i])+"("+ar[c][i]+")"+" ");
				find(i2,ar[c][i],0);
				//System.out.println("Coming from "+s.charAt(i2)+" "+s.charAt(ar[c][i]));
			}
		}
		else
		{
			//System.out.println("mid= "+ar[c][mid]);
			int no=ptr[c]-mid;
			//System.out.println("Increment by "+no);
			count+=no;
		}
	}
}
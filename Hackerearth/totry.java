/*
	To try or Not to try
	link: https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/bitmasking/

*/

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
  
public class Main 
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
            int n,m;
            n=in.nextInt();
            m=in.nextInt();
            int ar[][]=new int[n][m];
            long mask1[]=new long[n];
            long mask2[]=new long[n];
            long mask3[]=new long[n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    ar[i][j]=in.nextInt();
                    if(ar[i][j]==1)
                    {
                        if(j<60)
                        {
                            mask1[i]|=(1l<<j);
                        }
                        else if(j<120)
                        {
                            mask2[i]|=(1l<<(j-60));
                        }
                        else
                        {
                            mask3[i]|=(1l<<(j-120));
                        }
                    }
                }
            }
            int total=0;
            for(int x=0;x<(int)Math.pow(2,n);x++)
            {
                long mk1=0,mk2=0,mk3=0;
                for(int j=0;j<n;j++)
                {
                    if(0!=(x&(1l<<j)))
                    {
                        mk1|=mask1[j];
                        mk2|=mask2[j];
                        mk3|=mask3[j];
                    }
                }
                
                if(Long.bitCount(mk1)+Long.bitCount(mk2)+Long.bitCount(mk3)==m)
                {
                    total++;
                }
                
            }
            System.out.println(total);
        }
    }
}

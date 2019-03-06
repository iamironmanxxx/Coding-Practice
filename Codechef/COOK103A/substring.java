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
    static class SubstringClass
    { 
        int last=0;
        int SubstringSearch(String pat, String txt,int N) 
        { 
            int M = pat.length(); 
            //int N = txt.length(); 
       
        
            int lps[] = new int[M]; 
            int j = 0;  // index for pat[] 
       
        
            computeLPSArray(pat,M,lps); 
       
            int i = 0;  // index for txt[] 
            int res = 0;  
            int next_i = 0;   
              
            while (i < N) 
            { 
                if (pat.charAt(j) == txt.charAt(i)) 
                { 
                    j++; 
                    i++; 
                } 
                if (j == M) 
                { 
                    j = lps[j-1]; 
                    last=i;
                    res++; 
      
                
                    if (lps[j]!=0) 
                        i = ++next_i; 
                    j = 0; 
                } 
       
             
                else if (i < N && pat.charAt(j) != txt.charAt(i)) 
                { 
                
                    if (j != 0) 
                        j = lps[j-1]; 
                    else
                        i = i+1; 
                } 
            } 
            return res; 
        } 
       
        void computeLPSArray(String pat, int M, int lps[]) 
        { 
         
            int len = 0; 
            int i = 1; 
            lps[0] = 0;
            while (i < M) 
            { 
                if (pat.charAt(i) == pat.charAt(len)) 
                { 
                    len++; 
                    lps[i] = len; 
                    i++; 
                } 
                else
                { 
                
                    if (len != 0) 
                    { 
                        len = lps[len-1]; 
       
                   
                    } 
                    else  // if (len == 0) 
                    { 
                        lps[i] = len; 
                        i++; 
                    } 
                } 
            } 
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
            String s=in.next();
            String sample="";
            int f[]=new int[n];
            String ar[]=new String[n];
            SubstringClass sbstr=new SubstringClass();
            for(int i=0;i<n;i++)
            {
                char c=s.charAt(i);
                sample+=c;
                ar[i]=sample;
                int len;
                if(i==0)
                {
                    len=n;
                }
                else 
                {
                    //if(g==1)
                    //pw.print(sbstr.last+"\n");
                    len=Math.min(n,sbstr.last+i+1);
                }
                f[i]=sbstr.SubstringSearch(sample,s,len);
            }
            int max=0;
            String maxStr="";
            for(int i=0;i<n;i++)
            {
                if(f[i]>=max)
                {
                    maxStr=ar[i];
                    max=f[i];
                }
            }
            pw.print(maxStr+"\n");
        }
        pw.close();
    } 
}
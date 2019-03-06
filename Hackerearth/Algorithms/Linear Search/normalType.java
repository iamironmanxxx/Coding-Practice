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
        int n=in.nextInt();
        int ar[]=new int[n];
        long count=0;
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            ar[i]=in.nextInt();
            s.add(ar[i]);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int lptr=0;
        for(int i=0;i<n;i++)
        {
            if(map.get(ar[i])==null)
            {
                map.put(ar[i],1);
            }
            else
            {
                map.put(ar[i],map.get(ar[i])+1);
            }
            while(map.size()==s.size())
            {
                if(map.get(ar[lptr])==1)
                {
                    map.remove(ar[lptr]);
                }
                else
                {
                    map.put(ar[lptr],map.get(ar[lptr])-1);
                }
                count+=n-i;
                //System.out.println("For "+lptr+" to "+i+" count+="+(n+1-i));
                lptr++;
            }
        }
        System.out.println(count);
    }
}
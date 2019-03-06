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
        MultiStack mul=new MultiStack(n);
        for(int i=0;i<n;i++)
        {
            int x=in.nextInt();
            for(int j=0;j<x;j++)
            {
                int val=in.nextInt();
                mul.add(i,val);
            }
        }
        int q=in.nextInt();
        for(int j=0;j<q;j++)
        {
            int v=in.nextInt();
            if(v==1)
            {
                int k,h;
                k=in.nextInt();
                h=in.nextInt();
                mul.add(k-1,h);
            }
            else if(v==0)
            {
                int l=in.nextInt();
                mul.remove(l-1);
            }
            else
            {
                int index=0,val=0,flag=0,prev;
                do{
                    prev=mul.getMin(index,val+1);
                    if(prev==-1)
                    {
                        flag=1;
                    }
                    index++;
                    val=prev;
                }while(index<n&&prev!=-1);
                if(flag==1)
                {
                    System.out.println("NO");
                }
                else
                {
                    System.out.println("YES");
                }
            }
        }
    }
    static class MultiStack{
        int ar[][];
        int ptr[];
        Stack<Integer> st=new Stack<>();
        MultiStack(int n)
        {
            ar=new int[n][100000];
            ptr=new int[n];
        }
        void add(int index,int data)
        {
            ar[index][ptr[index]++]=data;
            if(index==0)
            {
                if(!st.isEmpty())
                {
                    st.push(Math.min(st.peek(),data));
                }
                else
                {
                    st.push(data);
                }
            }
        }
        int getMin(int index,int val)
        {
            if(index==0)
            {
                if(!st.isEmpty())
                    return st.peek();
                else
                    return -1;
            }
            //System.out.println("Looking for ind : "+index+" value = "+val);

            int start=0,end=ptr[index]-1,mid;
            
            while(start<end)
            {
                mid=(start+end)/2;
                if(ar[index][mid]==val)
                {
                    return val;
                }
                else if(ar[index][mid]>val)
                {
                    //System.out.println("Since "+ar[index][mid]+" > "+val+" end = "+(mid-1));
                    end=mid-1;
                }
                else
                {
                    //System.out.println("Since "+ar[index][mid]+" < "+val+" start = "+(mid+1));
                    start=mid+1;
                }
            }
            if(end>=0&&end<ar[index].length&&ar[index][end]>=val)
            {
                return ar[index][end];
            }
            else if((end+1)<ar[index].length&&ar[index][end+1]>=val)
            {
                return ar[index][end+1];
            }
            return -1;
        }
        int remove(int index)
        {
            if(index==0)
            {
                st.pop();
            }
            int data=ar[index][ptr[index]-1];
            ptr[index]-=1;
            return data;
        }

    }
}
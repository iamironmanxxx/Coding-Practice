import java.util.*;
class Abc
{
    static long ar[];
    static int n,m;
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        m=in.nextInt();
        ar=new long[n];
        long max=0;
        for(int i=0;i<n;i++)
        {
            ar[i]=in.nextLong();
            max=Math.max(max,ar[i]);
        }
        long start=max,end=1000000007l*1000000007l,mid;
        while(end-start>0)
        {
            mid=(start+end)/2;
            if(func(mid))
            {
                end=mid;
            }
            else
            {
                start=mid+1;
            }
        }
        System.out.println(start);
        
    }
    public static boolean func(long t)
    {
        int req=0;
        long sum=0;
        for(int i=0;i<n;i++)
        {
            if(sum+ar[i]>t)
            {
                req=0;
                sum=ar[i];
            }
            else
            {
                sum+=ar[i];
            }
        }
        if(req<=m)
        {
            return true;
        }
        return false;
    }
}
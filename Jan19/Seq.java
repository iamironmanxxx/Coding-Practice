import java.util.*;
import java.io.*;
class Abc
{
    static int count=0;
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        PrintWriter pw=new PrintWriter(System.out);
        int t=in.nextInt();
        int prime[]=primeFunc();
        //print(prime);
        int c=count;
        for(int g=0;g<t;g++)
        {
            int n=in.nextInt();
            int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=1;
		}
            for(int i=0,j=0;j<c&&i<n;i++,j++)
            {
                ar[i]*=prime[j];
                ar[(i+1)%n]*=prime[j];
            }
		for(int i=0;i<n;i++)
		{
			pw.print(ar[i]+" ");
		}
		pw.print("\n");
        }
        pw.close();
    }
    public static void print (int ar[])
    {
        for(int i=0;i<count;i++)
        {
            System.out.print(ar[i]+" ");
        }
        System.out.println();
    }
    public static int[] primeFunc()
    {
        int ar[]=new int[10000000];
        ar[2]=0;
        int prime[]=new int[ar.length];
        count=0;
        for(int i=2;i<ar.length;i++)
        {
            if(ar[i]==0)
            {
                for(int k=2;(i*k)>=0&&(i*k)<ar.length;k++)
                {
                    ar[i*k]=1;
                    //System.out.println(ar[j]);
                }
            }
        }
        for(int i=2;i<ar.length;i++)
        {
            if(ar[i]==0)
            {
                prime[count++]=i;
            }
        }
        return prime;
    }
}

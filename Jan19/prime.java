import java.util.*;
import java.io.*;
class Abc
{
    static int count=0;
    static int TEN =1000000000;
    static class Node{
        int x,y;
        Node(int a,int b)
        {
            x=a;
            y=b;
        }
    }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        PrintWriter pw=new PrintWriter(System.out);
        int t=in.nextInt();
        int prime[]=primeFunc();
        int c=count;
	System.out.println(c);
	int len=50000;
        int ar[]=new int[len];
	int freq[]=new int[50000];
        int cp[]=new int[len];
        for(int i=0;i<ar.length;i++)
        {
            ar[i]=1;
        }
        int f=0;
        for(int i=0,j=0;j<c&&i<ar.length;j++,i++)
        {
            int p=prime[j];
            int i1=(i+1)%ar.length;
            if(p<=TEN&&p>0&&ar[i]*p<=TEN&&ar[i]*p>0)
            {
                ar[i]*=p;
                ar[i1]*=p;
                //pq.add(new Node(node.x,node.y+1));
            }
		else
		{
			ar[i]*=p;
			ar[i]/=prime[j-1];
			ar[i]*=p;
		}
        }
	//print(pw,ar);
	pw.print(isValid(ar));
        pw.close();
    }
	static int x=0;
	static int gcd(int a,int b)
	{
		if(a==0)
		{
			x=b;
		}
		else	
		{
			gcd(b%a,a);
		}
		return x;
	}
	public static boolean isValid(int ar[])
	{
		int n=ar.length;
		for(int i=0;i<n;i++)
		{
			int a=i,b=(i+1)%n,c=(i+2)%n;
			if(gcd(ar[a],ar[b])==1||gcd(ar[a],gcd(ar[b],ar[c]))!=1)
			{
				System.out.println(i+" "+ar[a]+" "+ar[b]+" "+ar[c]);
				return false;
			}
		}
		return true;
	}
    public static void print (PrintWriter pw,int ar[])
    {
        int n=ar.length;
        
        for(int i=0;i<n;i++)
		{
			pw.print(ar[i]+" ");
		}
		pw.print("\n");
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
            if(ar[i]==0&&i<=100000)
            {
                prime[count++]=i;
            }
        }
	for(int i=0;i<count/2;i++)
	{
		if(i%2==0)
		{
			int temp=prime[i];
			prime[i]=prime[count-1-i];
			prime[count-1-i]=temp;
		}
	}
	//print(new PrintWriter(System.out),prime);
        return prime;
    }
}

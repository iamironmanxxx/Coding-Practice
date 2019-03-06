import java.util.*;
class Abc
{
	static int n,k;
	static String s;
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			n=in.nextInt();
			k=in.nextInt();
			s=in.next();
			int start =0,end=n-1,mid=0;
			while(start<=end)
			{
				mid=(start+end)/2;
				//System.out.println("Start= "+start+" End= "+end+" mid= "+mid);
				if(check(mid))
				{
					start=mid+1;
				}
				else
				{
					end=mid-1;
				}
			}
			System.out.println(start);
		}
	}
	static boolean check(int size)
	{
		int f[]=new int[54];
		for(int i=0;i<=size;i++)
		{
			char c=s.charAt(i);
			increment(f,c);
		}
		int max=maxCount(f);
		if(size-max+1<=k)
		{
			return true;
		}
		int lptr=0;
		int rptr=size;
		while(rptr<n)
		{
			char c=s.charAt(lptr);
			decrement(f,c);
			c=s.charAt(rptr);
			increment(f,c);
			max=maxCount(f);
			if(size-max<=k)
			{
				return true;
			}
			lptr++;
			rptr++;
		}
		return false;
	}
	static int maxCount(int f[])
	{
		int max=0;
		for(int i=0;i<f.length;i++)
		{
			if(f[i]>max)
			{
				max=f[i];
			}
		}
		return max;
	}
	static void increment(int f[],char c)
	{
		if(Character.isUpperCase(c))
		{
			f[c-'A'+26]++;
		}
		else
		{
			f[c-'a']++;
		}
	}
	static void decrement(int f[],char c)
	{
		if(Character.isUpperCase(c))
		{
			f[c-'A'+26]--;
		}
		else
		{
			f[c-'a']--;
		}
	}
}
import java.io.*;
import java.util.*;
class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		if(n>=130)
		{
			System.out.println("Yes");
		}
		else
		{
			long ar[]=new long[n];
			HashSet<Long> set=new HashSet<>();
			for(int i=0;i<n;i++)
			{
				ar[i]=in.nextLong();
				set.add(ar[i]);
			}

			int flag=0;
			Outer :for(int i=0;i<n;i++)
			{
				for(int j=0;j<i;j++)
				{
					for(int k=0;k<j;k++)
					{
						if(i==j||j==k||k==i)
							continue;
						if(set.contains(ar[i]^ar[j]^ar[k]))
						{
							System.out.println("Yes");
							flag=1;
							break Outer;
						}
					}
				}
			}
			if(flag==0)
			{
				System.out.println("No");
			}
		}
	}
}
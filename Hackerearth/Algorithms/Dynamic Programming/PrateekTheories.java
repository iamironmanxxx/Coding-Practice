import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t--!=0)
		{
			int n=in.nextInt();
			int start[]=new int[n];
			int end[]=new int[n];
			for(int i=0;i<n;i++)
			{
				int l,r;
				l=in.nextInt();
				r=in.nextInt();
				start[i]=l;
				end[i]=r;
			}
			Arrays.sort(start);
			Arrays.sort(end);
			int max=0,count=0;
			int ptr1=0;
			int ptr2=0;
			while(ptr1<n)
			{
				if(start[ptr1]<=end[ptr2])
				{
					if(start[ptr1]==end[ptr2])
					{
						count--;
						ptr2++;
					}
					count++;
					if(count>max)
					{
						max=count;
					}
					ptr1++;
				}
				else if(start[ptr1]>end[ptr2])
				{
					count--;
					ptr2++;
				}
			}
			System.out.println(max);
		}
	}
}
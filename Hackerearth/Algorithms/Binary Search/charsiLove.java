import java.util.*;
class Abc
{
	public static int func(int n)
	{
		return(((n+1)*n)/2);
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int ar[]=new int[1000000];
		int ptr=0;
		for(int i=1;func(i)<1000000000&&func(i)>0;i++)
		{
			ar[ptr++]=func(i);
		}
		/*for(int i=0;i<ptr;i++)
		{
			System.out.println(ar[i]);
		}*/
		int flag =0;
		Outer : for(int i=0;i<ptr;i++)
		{
			int start=i,end=ptr-1,mid=0;
			while(start<=end)
			{
				mid=(start+end)/2;
				if(ar[mid]+ar[i]==n)
				{
					flag=1;
					System.out.println("YES");
					break Outer;
				}
				else if(ar[mid]+ar[i]>n)
				{
					end=mid-1;
				}
				else
				{
					start=mid+1;
				}
			}
		}
		if(flag==0)
			{
				System.out.println("NO");
			}
	}
}
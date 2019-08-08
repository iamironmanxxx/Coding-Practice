import java.util.*;
public class Abc
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n,a,x,b,y;
		n = in.nextInt();
		a = in.nextInt();
		x = in.nextInt();
		b = in.nextInt();
		y = in.nextInt();
		int flag = 0;
		for(int i=1;i<=n;i++)
		{
			int t1=time(a,i,n,1);
			int t2=time(b,i,n,2);
			if(isRange(a,x,n,1,i)&&isRange(b,y,n,2,i)&&t1==t2)
			{
				flag=1;
				System.out.println("YES");
				break;
			}
		}
		if(flag==0)
			System.out.println("NO");
	}
	public static boolean isRange(int a,int x,int n,int train,int i)
	{
		if(train == 1)
		{
			if(a<=x)
			{
				if(i>=a&&i<=x)
					return true;
			}
			else
			{
				if((i>=a)||(i<=x))
					return true;
			}
		}
		else
		{
			if(a>=x)
			{
				if(i<=a&&i>=x)
					return true;
			}
			else
			{
				if(i<=a||i>=x)
					return true;
			}
		}
		return false;
	}
	public static int time(int a,int x,int n,int train)
	{
		int ti=0;
		if(train == 1)
		{
			if(a<=x)
				ti = (x-a);
			else
				ti = n+(x-a); 

		}
		else
		{
			if (a>=x)
				ti = (a-x);
			else
				ti=n+(a-x);
		}
		return ti;
	}
}
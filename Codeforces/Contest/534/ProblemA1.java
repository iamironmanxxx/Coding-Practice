import java.util.*;
public class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int c=0;
		for(int i=2;i<=9;i++)
		{
			if(n%i==0)
			{
				c=1;
				System.out.println(n/i);
				for(int j=0;j<n/i;j++)
				{
					System.out.print(i+" ");
				}
				System.out.println();
				break;
			}
		}
		if(c==0)
		{
			System.out.println(n);
			for(int j=0;j<n;j++)
			{
				System.out.print(1+" ");
			}
		}
	}
}
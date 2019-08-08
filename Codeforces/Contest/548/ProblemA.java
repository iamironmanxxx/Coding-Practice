import java.util.*;
public class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		if(n>=1&&n<=65000)
		{
			String s=in.next();
			if(valid(s))
			{
				int count=0;
				for(int i=0;i<n;i++)
				{
					int x=s.charAt(i)-'0';
					if(x%2==0)
					{
						count+=i+1;
					}
				}
				System.out.println(count);
			}
			else
			{
				System.exit(0);
			}
		}
		else
		{
			System.exit(0);
		}
	}
	public static boolean valid(String s)
	{
		for(int i=0;i<s.length();i++)
		{
			int x=s.charAt(i)-'0';
			if(x>=1&&x<=9)
				continue;
			else
				return false;
		}
		return true;
	}
}
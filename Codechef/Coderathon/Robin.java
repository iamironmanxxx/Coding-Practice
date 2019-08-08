import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0)
		{
			int b=in.nextInt();
			int n10=b/10;
			b%=10;
			int nExtra=(b>0)?1:0;
			int total=(n10+nExtra)*10;
			if(total%100==0||total%1000==0)
			{
				total+=10;
			}
			System.out.println(total);
		}
	}
}
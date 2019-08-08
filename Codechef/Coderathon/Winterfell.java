import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t--!=0)
		{
			int m,n,p,q;
			m=in.nextInt();
			n=in.nextInt();
			p=in.nextInt();
			q=in.nextInt();
			int hor=1+(m-p);
			int ver=(n-q+1)*hor;
			System.out.println(ver);
		}
	}
}
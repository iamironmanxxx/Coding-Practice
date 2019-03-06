import java.util.*;
public class Encrypt
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		String str=in.next();
		String s="";
		int i=0;
		int ind=0;
		while(ind<n)
		{
			s+=str.charAt(ind);
			i++;
			ind=(i*(i+1))/2;
		}
		System.out.println(s);
	}
}

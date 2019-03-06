import java.util.*;
import java.io.*;
class Abc
{
	public static void main(String args[])throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(in.readLine());
		for(int g=0;g<t;g++)
		{
			String str=in.readLine();
			//str=str.trim();
			if(str.indexOf(" not ")!=-1)
			{
				System.out.println("Real Fancy");
			}
			else if(str.indexOf(" not")==str.length()-4)
			{
				System.out.println("Real Fancy");
			}
			else if(str.indexOf("not ")==0)
			{
				System.out.println("Real Fancy");
			}
			else
			{
				System.out.println("regularly fancy");
			}
		}
	}
}
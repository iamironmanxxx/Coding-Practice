import java.util.*;
public class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		String s,t;
		s=in.next();
		t=in.next();
		if(s.length()!=t.length())
		{
			System.out.println("No");	
		}
		else
		{
			int sVCount=0,tVCount=0;
			for(int i=0;i<s.length();i++)
			{
				char c,d;
				c=s.charAt(i);
				d=t.charAt(i);
				if(c=='a'||c=='e'||c=='i'||c=='u'||c=='o')
				{
					sVCount++;
				}
				if(d=='a'||d=='e'||d=='i'||d=='u'||d=='o')
				{
					tVCount++;
				}
			}
			//System.out.println(sVCount+" "+tVCount);
			if(sVCount==tVCount)
			{
				System.out.println("Yes");
			}
			else
			{
				System.out.println("No");
			}
		}
	}
}
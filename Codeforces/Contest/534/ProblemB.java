import java.util.*;
public class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		String s=in.next();
		Stack<Character> st=new Stack<>();
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(st.isEmpty()||st.peek()!=c)
			{
				st.push(c);
			}
			else if(!st.isEmpty()&&st.peek()==c)
			{
				st.pop();
				count++;
			}
		}
		if(count%2==0)
		{
			System.out.println("No");
		}
		else 
		{
			System.out.println("Yes");
		}
	}
}
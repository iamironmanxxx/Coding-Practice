import java.util.*;
class Abc
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        String s=in.next();
        int ans[]=new int[s.length()];
        for(int i=s.length()-1;i>=0;i--)
        {
            int val=0;
            if((s.charAt(i)-'0')%2==0)
            {
                val=1;
            }
            if(i==s.length()-1)
            {
                ans[i]=val;
            }
            else
            {
                ans[i]=ans[i+1]+val;
            }
        }
        for(int i=0;i<s.length();i++)
        {
            System.out.println(ans[i]+" ");
        }
    }
}
/*
	OXA
	link : https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/the-game-of-oxa/
*/
import java.util.*;
class Abc
{
    public static void main(String arsg[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int g=0;g<t;g++)
        {
            String monk=in.next();
            int n=in.nextInt();
            int ar[]=new int[n];
            for(int i=0;i<n;i++)
            {
                ar[i]=in.nextInt();
            }
            
            int max=Integer.MIN_VALUE;
            for(int x=0;x<(int)Math.pow(2,n);x++)
            {
                int dup=x;
                int c=0;
                int iter=0;
                int sum=0;
                while(dup>0)
                {
                    if(dup%2==1)
                    {
                        if(c==0)
                        {
                            sum|=ar[iter];
                        }
                        else if(c==1)
                        {
                            sum^=ar[iter];
                        }
                        else
                        {
                            sum+=ar[iter];
                        }
                        c=(c+1)%3;
                    }
                    dup/=2;
                    iter++;
                }
                if(sum>max)
                {
                    max=sum;
                }
            }
            if(monk.equals("Even")&&max%2==0)
            {
                System.out.println("Monk");
            }
            else if(monk.equals("Odd")&&max%2==1)
            {
                System.out.println("Monk");
            }
            else
            {
                System.out.println("Mariam");
            }
        }
    }
}

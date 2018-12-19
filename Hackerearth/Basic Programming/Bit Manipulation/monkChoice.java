/*
	Monk's choice of numbers
	link :https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/monks-choice-of-numbers-1/

*/
import java.util.*;
class Abc
{
    public static void main(String ars[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int g=0;g<t;g++)
        {
            int n,k;
            n=in.nextInt();
            k=in.nextInt();
            Integer ar[]=new Integer[n];
            for(int i=0;i<n;i++)
            {
                ar[i]=in.nextInt();
            }
            Arrays.sort(ar,new Comparator<Integer>()
            {
		@Override
                public int compare(Integer a,Integer b)
                {
                    Integer ba,bb;
                    ba=Integer.bitCount(a);
                    bb=Integer.bitCount(b);
                    if(ba>bb)
                    {
                        return 1;
                    }
                    else if (ba<bb)
                    {
                        return -1;
                    }
                    return 0;
                }
            });
            int sum=0;
            for(int i=n-1;i>=0&&i>n-1-k;i--)
            {
                sum+=Integer.bitCount(ar[i]);
            }
            System.out.println(sum);
        }
    }
}

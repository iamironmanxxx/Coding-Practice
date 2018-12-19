/*
	Try me first
	link : https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/a-95/

*/


import java.util.*;
class Abc
{
    public static void main(String rgs[])
    {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        long c=0;
        int dup=a;
        int iter=0;

	//oxor is max if unset bits of a are xor-ed with set bits of b 
        while(dup>0)
        {
            if(dup%2==0)
            {
                c+=1<<(iter);
            }
            dup/=2;
            iter++;
        }
        System.out.println(a+" "+c);
    }
}

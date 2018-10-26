/* 
	Have you met Ted?
	link :https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/haaaave-you-met-ted/
	
	given a set of numbers,
	find min hamming distance between any two numbers of the set
	
	The set follows the property that its xor is closed,ie,
	if c= a^b
		then c is in the set

*/

import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		
		for(int g=0;g<t;g++)
		{	
			int n=in.nextInt();
			int min=Integer.MAX_VALUE;
			int ar[]=new int[n];
			for(int i=0;i<n;i++)
			{
				ar[i]=in.nextInt();

//since set is closed for xor, we need to count set bits of every 
//element of the set to find minimum hamming distance
				if(Integer.bitCount(ar[i])<min)
				{
				    min=Integer.bitCount(ar[i]);
				}
			}
			System.out.println(min);	
		}
	}
}

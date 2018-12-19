/* 
	Maximum AND
	link : https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/maximum-and/
	
	given a,b find the maximum and value of 2 numbers in range from a to b
	
	=> if b is odd, find b & ( b - 1)
	   else find ( b - 1 ) & ( b - 2 )
*/

import java.util.*;
class Abc
{
    public static void main(String args[])
    {
        Scanner in = new Scanner( System.in );
        int t = in.nextInt();
        for( int g = 0 ; g < t ; g++ )
        {
            long a = in.nextLong();
            long b = in.nextLong();
            if ( b % 2 == 0 && ( b - a ) != 1)
            {
                b--;
            }
            //System.out.println( b + " " + ( b - 1 ) );
            System.out.println( b & ( b - 1 ) );
            
            
        }
    }
    static long log(long n)
    {
        return ( long ) Math.floor( Math.log( n ) / Math.log( 2 ) ) ;
    }
}

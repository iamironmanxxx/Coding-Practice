/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int g=0;g<t;g++)
        {
            int n=in.nextInt();
            int ugly[]=new int[n];
            ugly[0]=1;
            int next2,next3,next5,nextNo;
            int i2=0,i3=0,i5=0;
            next2=ugly[i2]*2;
            next3=ugly[i3]*3;
            next5=ugly[i5]*5;
            for(int i=1;i<n;i++)
            {
                nextNo=Math.min(next2,Math.min(next3,next5));
                ugly[i]=nextNo;
                if(nextNo==next2)
                {
                    i2++;
                    next2=ugly[i2]*2;
                }
                if(nextNo==next3)
                {
                    i3++;
                    next3=ugly[i3]*3;
                }
                if(nextNo==next5)
                {
                    i5++;
                    next5=ugly[i5]*5;
                }
            }
            //System.out.println(Arrays.toString(ugly));
            System.out.println(ugly[n-1]);
        }
	}
}
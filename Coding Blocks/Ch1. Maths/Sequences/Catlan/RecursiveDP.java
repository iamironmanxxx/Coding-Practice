import java.util.*;
import java.io.*;
class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int catlan[]=new int[N+1];
		catlan[0]=1;
		for(int n=1;n<=N;n++)
		{
			catlan[n]=0;
			for (int i=0;i<n;i++)
			{
				catlan[n]+=catlan[i]*catlan[n-1-i];
			}
			System.out.print(catlan[n]+ " ");
		}
		System.out.println();
		System.out.println(catlan[N]);
	}
}
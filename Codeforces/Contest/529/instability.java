import java.util.*;
public class Instability
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int ar[]=new int[n];
		int largest=Integer.MIN_VALUE;
		int sLargest=Integer.MIN_VALUE;
		int smallest=Integer.MAX_VALUE;
		int sSmallest=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
			if(ar[i]<smallest)
			{
				sSmallest=smallest;
				smallest=ar[i];
			}
			else if(ar[i]>=smallest&&ar[i]<sSmallest)
			{
				sSmallest=ar[i];
			}
			if(ar[i]>largest)
			{
				sLargest=largest;
				largest=ar[i];
			}
			else if(ar[i]>sLargest&&ar[i]<=largest)
			{
				sLargest=ar[i];
			}
		}
		int inst1=largest-sSmallest;
		int inst2=sLargest-smallest;
		System.out.println(Math.min(inst1,inst2));
		
	}

}


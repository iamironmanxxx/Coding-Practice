import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int ar[]=new int[n];
		int f[]=new int[1001];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
			f[ar[i]]++;
		}

		int maxInd=0,max=0,sMax=0,sMAxInd=0;

		for(int i=0;i<1001;i++)
		{
			if(f[i]>=max)
			{
				sMax=max;
				sMAxInd=maxInd;
				max=f[i];
				maxInd=i;
			}
			else if(f[i]>=sMax)
			{
				sMax=f[i];
				sMAxInd=i;
			}
		}

		for(int i=0;i<1001;i++)
		{
			if(i!=ar[n-1]&&i!=ar[0])
			{
				if(f[i]==max&&i!=sMAxInd)
				{
					maxInd=i;
					break;
				}
			}
		}
		for(int i=0;i<1001;i++)
		{
			if(i!=ar[0]&&f[i]==sMax&&i!=maxInd)
			{
				sMAxInd=i;
				break;
			}
		}

		System.out.println(" Max= "+max+" SecondMax= "+sMax+ " MaxInd= "+maxInd+" sMAxInd= "+sMAxInd);

		int sum=2+max+sMax;

		if(maxInd==ar[n-1])
		{
			sum--;
		}

		if(maxInd==ar[0]&&n!=1)
		{
			sum--;
		}

		if(sMAxInd==ar[0])
		{
			sum--;
		}
		else if(sMAxInd==ar[n-1]&&n!=1)
		{
			sum--;
		}
		if(sMax==0)
		{
		    sum=max;
		}

		System.out.println(sum);
	}	
}
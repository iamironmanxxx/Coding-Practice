import java.util.*;
class Abc
{
	public static long dist(int ar[],int index,int n,int pivot,int k,long midSum)
	{
		long newSum;
		int X,Y;
		long sumX,sumY;
		long dp=Math.abs(ar[pivot]-ar[index]);
		sumX=cumSum[index]-cumSum[pivot];
		sumY=cumSum[n-1]-cumSum[index];
		X=index+1;
		Y=n-index-1;
		newSum=((X*dp)-sumX)+((sumY)-(Y*dp));
		if(newSum-k>0)
			newSum-=k;
		else
			newSum=(k-newSum)%2;
		return newSum;
	}
	static long cumSum[];
	static long pDist[];
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n,k;
		n=in.nextInt();
		k=in.nextInt();
		int ar[]=new int[n];
		cumSum=new long[n];
		pDist=new long[n];

		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
			if(map.get(ar[i])==null)
			    map.put(ar[i],i);
			else
			    map.put(ar[i],Math.min(map.get(ar[i]),i));
		}
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));
		long sum=0;
		int pivot=0;
		for(int i=0;i<n;i++)
		{
			pDist[i]=Math.abs(ar[pivot]-ar[i]);
			if (i==0)
				cumSum[i]=pDist[i];
			else
				cumSum[i]+=cumSum[i-1]+pDist[i];
			sum+=Math.abs(ar[pivot]-ar[i]);
		}
		long minDist=Long.MAX_VALUE;
		int minIndex=n;
		long br[]=new long[n];
		System.out.println(sum);
		for(int i=0;i<n;i++)
		{
			long distance=dist(ar,i,n,pivot,k,sum);
			System.out.println(distance+" ");
			br[i]=distance;
			if(distance<minDist)
			{
				minDist=distance;
			}
		}
		for(int i=0;i<n;i++)
		{
			if(br[i]==minDist)
			{
				if(map.get(ar[i])+1<minIndex)
				{
					minIndex=map.get(ar[i])+1;
				}
			}
		}
		System.out.println(minIndex+ " "+ minDist);
	}
}
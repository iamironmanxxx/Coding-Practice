import java.util.*;
public class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int ar[]=new int[n];
		long maxSum=0;
		long sum=0;
		assertion(n>=1&&n<=2*100000);
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
			assertion(ar[i]>=1&&ar[i]<=1000000000);
		}
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<n;i++)
		{
			if(st.isEmpty()||st.peek()<ar[i])
			{
				st.push(ar[i]);
				sum+=ar[i];
			}
			else
			{
				Stack<Integer> aux=new Stack<>();
				int up=ar[i];
				aux.push(up);
				while(!st.isEmpty())
				{
					int x=st.pop();
					sum-=x;
					x=(up-1>=0)?Math.min(up-1,x):0;
					if(x!=0)
					{
						up=x;
						aux.push(up);
					}
					else
					{
						st=new Stack<>();
						sum=0;
						break;
					}
				}
				while(!aux.isEmpty())
				{
					int x=aux.pop();
					sum+=x;
					st.push(x);
				}
				
			}
			//System.out.println(st.toString());
			if(sum>maxSum)
			{
				maxSum=sum;
			}
		}
		System.out.println(maxSum);
	}
	public static void assertion(boolean a)
	{
		if(!a)
		{
			System.exit(0);
		}
	}
}
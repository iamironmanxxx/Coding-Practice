import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int f[]=new int[100001];
		int n=in.nextInt();
		int ar[]=new int[n];
		Set<Integer> set=new HashSet<>();
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
			f[ar[i]]++;
			set.add(ar[i]);
		}
		ArrayList<Integer> arrList=new ArrayList<>(set);
		Collections.sort(arrList);
		HashMap<Integer> map=new HashMap<>();
		long arr[]=new long[set.size()];
		for(int i=0;i<set.size();i++)
		{
			int u=arrList.get(i);
			arr[i]=u*f[u];
			map.put(u,i);
			if(i>0)
			{
				arr[i]=arr[i]+arr[i-1];
			}
		}
		//System.out.println(Arrays.toString(arr));
		int flag=0;
		for(int i=0;i<set.size();i++)
		{
			long left,right;
			left=(i==0)?0:arr[i-1];
			right=arr[set.size()-1]-arr[i];
			if(left==right)
			{
				flag=1;
				break;
			}
		}
		for(int i=0;i<100001;i++)
		{
			if(!set.contains(i))
			{

			}
		}
		if(flag==1)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}
}
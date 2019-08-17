#include <iostream>
using namespace std;
int main()
{
	int n;
	cin>>n;
	if(n>=130)
	{
		cout<<"Yes";
	}
	else
	{
		long ar[n];
		set<int> st=new HashSet<>();
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextLong();
			set.add(ar[i]);
		}

		int flag=0;
		Outer :for(int i=0;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				for(int k=0;k<j;k++)
				{
					if(i==j||j==k||k==i)
						continue;
					if(set.contains(ar[i]^ar[j]^ar[k]))
					{
						System.out.println("Yes");
						flag=1;
						break Outer;
					}
				}
			}
		}
		if(flag==0)
		{
			System.out.println("No");
		}
	}
	return 0;
}
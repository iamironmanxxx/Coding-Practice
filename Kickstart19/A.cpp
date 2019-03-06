#include<iostream>
#include<string>
using namespace std;
int query(long long x)
{
	string res;
	cout<<x<<endl<<flush;
	cin>>res;
	if(res=="TOO_SMALL")
		return 1;
	else if(res=="TOO_BIG")
		return -1;
	else if(res=="CORRECT")
		return 0;
	else
		return 2;

}
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		long long a,b,n;
		cin>>a>>b>>n;
		long long start=a+1,end=b,mid=0,flag=0;
		while(start<=end)
		{
			mid=(start+end)/2;
			int ans=query(mid);
			if(ans==0)
			{
				break;
			}
			else if(ans<0)
			{
				end=mid-1;
			}
			else if(ans!=2)
			{
				start=mid+1;
			}
			else 
			{
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			break;
		}
	}
	return 0;
}
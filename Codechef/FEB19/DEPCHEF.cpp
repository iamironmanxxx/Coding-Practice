#include<iostream>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		int a[n];
		int d[n];
		for(int i=0;i<n;i++)
		{
			cin>>a[i];
		}
		for(int i=0;i<n;i++)
		{
			cin>>d[i];
		}
		int maxxx=-1;
		for(int i=0;i<n;i++)
		{
			if(a[(i-1+n)%n]+a[(i+1)%n]<d[i])
			{
				if(d[i]>maxxx)
				{
					maxxx=d[i];
				}
			}
		}
		cout<<maxxx<<endl;
	}
	return 0;
}
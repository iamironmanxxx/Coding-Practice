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
		int ar[n];
		long sum=0;
		for(int i=0;i<n;i++)
		{
			cin>>ar[i];
			ar[i]--;
			sum+=ar[i];
		}
		cout<<sum+1<<endl;

	}
	return 0;
}
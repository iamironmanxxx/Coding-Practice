#include<iostream>
#include<string>
using namespace std;

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		string s;
		cin>>n>>s;
		long sum=0;
		long max=0;
		int half=(n%2==0)?n/2:n/2+1;
		for(int i=0;i<half;i++)
		{
			sum+=(s[i]-'0');
		}
		max=sum;
		int lptr=0;
		for(int i=half+1;i<n;i++,lptr++)
		{
			sum+=(s[i]-'0');
			sum-=(s[lptr]-'0');
			if(sum>max)
			{
				max=sum;
			}
		}
		cout<<<"Casez"<sum<<endl;
	}
}

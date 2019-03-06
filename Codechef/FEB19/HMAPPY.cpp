#include<iostream> 
using namespace std;
#define ll long long
ll x;
ll gcd(ll a,ll b)
{
	if(b==0)
	{
		x=a;
	}
	else
	{
		gcd(b,a%b);
	}
	return x;
}
ll lcm(ll a,ll b)
{
	return ((a*b)/gcd(a,b));
}
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		long long n,a,b,k,res;
		cin>>n>>a>>b>>k;
		res=(n/a)+(n/b)-(2*(n/lcm(a,b)));
		if(res>=k)
		{
			cout<<"Win"<<endl;
		}
		else
		{
			cout<<"Lose"<<endl;
		}
	}
	return 0;
}
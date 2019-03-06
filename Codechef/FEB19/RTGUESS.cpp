//LITWEEK LDS PARTY DOPE
//WEED
#include<iostream>
using namespace std;
#define ll long long
ll mod=1000000007;
ll pow(ll a,ll n,ll mod)
{
	ll result=1;
	while(n>0)
	{
		if(n%2)
		{
			result=(result*a)%mod;
		}
		a=(a*a)%mod;
		n/=2;
	}
	return result%mod;
}
ll modInverse(ll a ,ll b )
{
	return pow(a,b-2,b);
}
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		ll n,k,m;
		cin>>n>>k>>m;
		if(!(m%2))
		{
			ll num=(pow(n,m/2,mod)-pow(n-1,m/2,mod)+mod)%mod;
			ll termOne=((num*modInverse(pow(n,m/2,mod),mod))%mod+mod)%mod;
			ll denom=(pow(n,m/2,mod)*(n+k))%mod;//bug maybe
			ll termTwo=((pow(n-1,m/2,mod)*modInverse(denom,mod))%mod+mod)%mod;
			cout<<((termTwo+termOne)%mod+mod)%mod<<endl;
		}
		else
		{
			ll num=(pow(n,(m+2)/2,mod)-pow(n-1,(m+2)/2,mod)+mod)%mod;
			cout<<((num*modInverse(pow(n,(m+2)/2,mod),mod))%mod+mod)%mod<<endl;
		}
	}
	return 0;
}
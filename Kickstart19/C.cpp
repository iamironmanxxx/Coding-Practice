#include<iostream>
using namespace std;
#define ll long long

long long mod=1000000007;

ll pow(ll a,ll b)
{
	ll result=1;
	while(b>0)
	{
		if(b%2==1)
		{
			result=(result*a)%mod;
		}
		a=(a*a)%mod;
		b/=2;
	}
	return result;
}

ll xgcd,ygcd;

ll gcd(ll a,ll b)
{
	if(b==0)
	{
		xgcd=1;
		ygcd=0;
	}
	else
	{
		gcd(b,a%b);
		ll temp=xgcd;
		xgcd=ygcd;
		ygcd=temp-((a/b)*ygcd);
	}
}

ll modInverse(ll a)
{
	gcd(a,mod);
	return (xgcd%mod+mod)%mod;
}

int main()
{
	int t;
	cin>>t;
	for(int g=0;g<t;g++)
	{
		ll n,k,x1,y1,c,d,e1,e2,f;
		cin>>n>>k>>x1>>y1>>c>>d>>e1>>e2>>f;
		ll x[n];
		ll y[n];
		ll ar[n];

		x[0]=x1;
		y[0]=y1;
		ar[0]=(x1+y1)%f;
		//cout<<ar[0]<<endl;

		for(int i=1;i<n;i++)
		{
			x[i]=((c*x[i-1])%f+(d*y[i-1])%f+e1+f)%f;
			y[i]=((d*x[i-1])%f+(c*y[i-1])%f+e2+f)%f;
			ar[i]=(x[i]+y[i]+2*f)%f;
			//cout<<ar[i]<<endl;
		}
		ll sum=(ar[0]*((k*n)%mod))%mod;
		ll sm=k;
		cout<<1<<" Sm = "<<sm<<endl;
		for(int i=2;i<=n;i++)
		{
			ll num=(i*((pow(i,k)-1+mod)%mod))%mod;// i(i^k-1)
			sm+=(num*modInverse((i-1+mod)%mod))%mod;//(i(i^k-1))/(i-1)
			sm%=mod;
			cout<<i<<" Sm = "<<sm<<endl;
			sum+=(ar[i-1]*((sm*(n+1-i))%mod))%mod;
			sum%=mod;
		}
		cout<<"Case #"<<g+1<<": "<<sum<<endl;
	}
	return 0;
}
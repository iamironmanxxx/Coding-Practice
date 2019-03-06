#include<iostream>
using namespace std;
#define ll long long int

int main()
{
	ll n,m;
	cin>>n>>m;
	ll a[n+1],b[m+1],maxi=-1000000000,mini=1000000000,miniC,maxiC;
	for(ll i=0;i<n;i++) 
	{
		cin>>a[i]; 
		if(a[i]<mini){ 
			mini=a[i]; 
			miniC=i;
		}
	}
	for(ll i=0;i<m;i++) {
		cin>>b[i];
		if(b[i]>maxi)
		{
		  maxi =b[i]; 
		  maxiC=i;
		}
	}

	for(ll i=0;i<m;i++)
		cout<<miniC<<" "<<i<<endl;//<<//" "<<a[miniC]<<"+"<<b[i]<<"="<<a[miniC]+b[i]<</endl;
	for(ll i=0;i<n;i++)
	{
        if(i==miniC) 
        	continue;
        cout<<i<<" "<<maxiC<<endl;//<<" "<<a[i]<<"+"<<b[maxiC]<<"="<<a[i]+b[maxiC]/<<endl;
	}
}
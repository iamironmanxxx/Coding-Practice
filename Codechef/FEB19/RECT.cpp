#include<iostream>
using namespace std;
#define ll long long
ll q(ll a,ll b)
{
	cout<<"Q "<<a<<" "<<b<<endl<<std::flush;
	ll res;
	cin>>res;
	return res;
}
int answer(int x1,int y1,int x2,int y2)
{
	cout<<"A "<<x1<<" "<<y1<<" "<<x2<<" "<<y2<<endl<<std::flush;
	int response;
	cin>>response;
	return response;
}
ll m=1000000000;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		ll x1,y1,x2,y2;
		ll x1y1=q(0,0);
		ll x2y2=(2*m)-q(m,m);
		ll x2y1=m-q(m,0);
		ll x1y2=m-q(0,m);
		if(x1y2>=0)
		{
			ll query=(x1y1+x1y2)/2;
			x1=q(0,query);
			y1=x1y1-x1;
			y2=x1y2+x1;
			x2=x2y2-y2;
			int response=answer(x1,y1,x2,y2);
			if(response<0)
			{
				break;
			}
		}
		else
		{
			ll query=(x1y1+x2y1)/2;
			y1=q(query,0);
			x1=x1y1-y1;
			x2=x2y1+y1;
			y2=x2y2-x2;
			int response=answer(x1,y1,x2,y2);
			if(response<0)
			{
				break;
			}
		}
	}
	return 0;
}
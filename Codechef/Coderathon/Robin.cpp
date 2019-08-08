//LDS party weed 
//dope

#include<iostream>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int b;
		cin>>b;
		int n_ten=b/10;
		b%=10;
		int nExtra=(b>0)?1:0;
		int total=(n_ten + nExtra)*10;
		if(total%100==0||total%1000==0)
		{
			total+=10;
		}
		cout<<total<<endl;

	}
}
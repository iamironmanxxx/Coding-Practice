#include <iostream>
#include<bits/stdc++.h>
using namespace std;
bool res=false;
set<long> contn;
std::vector<int> v ;
void DFS(long n,long k)
{
    if(n==0&&k==0)
    {
        res=true;
    }
    else if(k>0&&(contn.find(n)==contn.end()))
    {
        contn.insert(n);
        long max=(int)pow(2,floor(log(n)/log(2)));
        for(long i=1;i<=max;i*=2)
        {
            DFS(n-i,k-1);
            if(res==true)
            {
                v.push_back(i);
                break;
            }
        }
    }
}
int main() {
	long long n,k;
	cin>>n>>k;
	DFS(n,k);
	if(res)
	{
	    cout<<"YES"<<endl;
	    sort(v.begin(),v.end());
	    for(int i=0;i<v.size();i++)
	    {
	        cout<<v[i]<<" ";
	    }
	}
	else
	{
	    cout<<"NO";
	}
}



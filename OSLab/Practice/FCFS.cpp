#include<iostream> 
#include<bits/stdc++.h>
using namespace std;
class Process
{
	public :
	int pid,at,bt;
};
int comp(Process a,Process b)
{
	if(a.at<b.at)
		return -1;
	else if(a.at<b.at)
		return 1;
	else 
		if(a.pid<b.pid)
			return 1;
		return 0;
}
int main()
{
	int n;
	cin>>n;
	Process a[n];
	for(int i=0;i<n;i++)
	{
		cin>>a[i].pid>>a[i].at>>a[i].bt;
	}
	sort(a,a+n,comp);
	cout<<"PID\t"<<"AT\t"<<"BT\t"<<"CT\t"<<"WT\t"<<"TAT\n";
	int currentTime=a[0].at;
	for(int i=0;i<n;i++)
	{
		int wt,tat;
		wt=currentTime-a[i].at;
		tat=wt+a[i].bt;
		currentTime+=a[i].bt;
		cout<<a[i].pid<<"\t"<<a[i].at<<"\t"<<a[i].bt<<"\t"<<currentTime<<"\t"<<wt<<"\t"<<tat<<endl;
	}
	return 0;
}
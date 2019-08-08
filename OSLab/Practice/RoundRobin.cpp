#include<iostream>
using namespace std;
int* findWaitingTime(int pid[],int bt[],int n,int quantum)
{
	int rem_bt[n];
	int *wt=new int[n];
	bool done=false;
	int currentTime=0;
	for(int i=0;i<n;i++)
	{
		rem_bt[i]=bt[i];
	}
	while(1)
	{	
		done=true;
		for(int i=0;i<n;i++)
		{
			if(rem_bt[i]>0)
			{
				done=false;
				if(rem_bt[i]>quantum)
				{
					currentTime+=quantum;
					rem_bt[i]-=quantum;
				}
				else
				{
					currentTime+=rem_bt[i];
					wt[i]=currentTime-bt[i];
					cout<<"WT for "<<i<<" = "<<wt[i]<<endl;
					rem_bt[i]=0;
				}
			}
		}
		if(done)
		{
			break;
		}
	}
	return wt;
}
int* findTAT(int *wt,int bt[],int n)
{
	int *tat=new int[n];
	for(int i=0;i<n;i++)
	{
		tat[i]=wt[i]+bt[i];
	}
	return tat;
}
int main()
{
	int n,quantum;
	cin>>n;
	int pid[n],bt[n];
	for(int i=0;i<n;i++)
	{
		cin>>pid[i]>>bt[i];
	}
	cin>>quantum;
	int *wt=findWaitingTime(pid,bt,n,quantum);
	int *tat=findTAT(wt,bt,n);

	for(int i=0;i<n;i++)
	{
		cout<<pid[i]<<" "<<bt[i]<<" "<<wt[i]<<" "<<tat[i]<<endl;
	}
}
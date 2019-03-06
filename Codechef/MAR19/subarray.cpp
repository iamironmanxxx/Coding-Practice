#include<iostream>
#include<bits/stdc++.h>
using namespace std;
#include<cstdio>
#define gc getchar_unlocked
#define ll long long
void scanint(int &x)
{
    register int c = gc();
    x = 0;
    for(;(c<48 || c>57);c = gc());
    for(;c>47 && c<58;c = gc()) {x = (x<<1) + (x<<3) + c - 48;}
}
class BIT{
	public :
	int ar[2001];
	int n;
	BIT()
	{
		n=2001;
		for(int i=0;i<2001;i++)
		{
			ar[i]=0;
		}
	}
	void update(int index,int val)
	{
		index++;
		while(index<n)
		{
			ar[index]+=val;
			index+=index&(-index);
		}
	}
	ll getSum(int index)
	{
		ll sum=0;
		index++;
		while(index>0)
		{
			sum+=ar[index];
			index-=index&(-index);
		}
		return sum;
	}
};
void print(BIT tree)
{
	for(int i=1;i<5;i++)
	{
		printf("%d ",tree.getSum(i));
	}
	printf("\n");
}
int search(BIT tree,ll k)
{
	int start=1,end=2001,mid;
	while(start<end)
	{
		mid=(start+end)/2;
		if(tree.getSum(mid)>=k)
		{
			end=mid;
		}
		else
		{
			start=mid+1;
		}
	}
	return start;
}
int main()
{
	int t;
	cin>>t;
	int ar[2001];
	int f[2001];
	while(t--)
	{
		int n,k;
		scanint(n);
		scanint(k);
		int count=0;
		
		for(int i=0;i<n;i++)
		{
			scanint(ar[i]);
		}

		for(int l=1;l<=n;l++)
		{
			BIT tree=BIT();
			
			for(int i=0;i<2001;i++)
			{
				f[i]=0;
			}

			for(int i=0;i<l;i++)
			{
				f[ar[i]]++;
			}

			double arg=k/(double)l;
			int m=(int)ceil(arg);

			for(int i=0;i<l;i++)
			{
				tree.update(ar[i],m);
			}
			//kth smallest element
			int x=search(tree,k);

			if(f[f[x]]>=1)
			{
				count++;
			}

			int lptr=0;
			for(int i=l;i<n;i++)
			{
				//remove from freq array and add new element
				f[ar[i]]++;
				f[ar[lptr]]--;

				//remove from tree and add new element
				tree.update(ar[i],m);
				tree.update(ar[lptr],-m);

				//kth smallest element
				x=search(tree,k);
				if(f[f[x]]>=1)
				{
					//printf("In : %d %d %d %d\n",i,l+i,ar[i],ar[l+i]);
					count++;
				}

				lptr++;
			}
		}
		printf("%d\n",count);
	}
	return 0;
}
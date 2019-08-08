import java.util.*;
class Main
{
	static class Process
	{
		int pid;
		int at;
		int bt;
		public Process(int a,int b,int c)
		{
			pid=a;
			at=b;
			bt=c;
		}
		public int compare(Process b)
		{
			if(bt<b.bt)
				return -1;
			else if(bt>b.bt)
				return 1;
			else
				if (at<b.at)
					return -1;
				else
					return 1;
		}
		public boolean equals(Object obj)
		{
			if(this==obj)
				return true;
			if(this.getClass()!=obj.getClass())
				return false;
			Process n=(Process)obj;
			if(n.pid==pid&&n.at==at&&n.bt==bt)
				return true;
			return false;
		}
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter no. of processes ");
		int n=in.nextInt();
		Process ar[]=new Process[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter pid :");
			int pid=in.nextInt();
			System.out.println("Enter Arrival Time :");
			int at=in.nextInt();
			System.out.println("Enter Burst Time :");
			int bt=in.nextInt();
			ar[i]=new Process(pid,at,bt);
		}
		Arrays.sort(ar,new Comparator<Process>(){
			public int compare(Process a,Process b)
			{
				return a.compare(b);
			}
		});
		int init=Math.max(ar[0].at,0);
		System.out.println("PID\tSt. Time\tEnd Time\t");
		for(int i=0;i<n;i++)
		{
			System.out.println(ar[i].pid+"\t"+init+"\t\t"+(init+ar[i].bt));
			init=(i<n-1)?Math.max(ar[i+1].at,init+ar[i].bt):0;
		}
	}
}
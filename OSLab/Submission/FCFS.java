import java.util.*;
class FCFS
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
			if(at<b.at)
				return -1;
			else if(at>b.at)
				return 1;
			return 0;
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
		int total_tat=0,total_wt=0;
		System.out.println("PID\tSt. Time\tEnd Time\t"+"Waiting time"+"\tTurn Around Time");
		for(int i=0;i<n;i++)
		{
			int wt=init-ar[i].at;
			int tat=wt+ar[i].bt;
			total_wt+=wt;
			total_tat+=tat;
			System.out.println(ar[i].pid+"\t"+init+"\t\t"+(init+ar[i].bt)+"\t\t"+wt+"\t\t"+tat);
			init=(i<n-1)?Math.max(ar[i+1].at,init+ar[i].bt):0;
		}
		System.out.println("Total WT : "+total_wt);
		System.out.println("Total TAT : "+total_tat);
		System.out.println("Avg. WT : "+(total_wt/(double)ar.length));
		System.out.println("Avg. TAT : "+(total_tat)/(double)ar.length);
	}
}
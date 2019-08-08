import java.util.*;
class SRTF
{
	static class Time
	{
		int start;
		int end;
		public Time(int a,int b)
		{
			start=a;
			end=b;
		}
	}
	static class Process
	{
		int pid;
		int at;
		int bt;
		int rt;
		Time time;
		public Process(int a,int b,int c)
		{
			pid=a;
			at=b;
			bt=c;
		}
		public Process(int p,Time t)
		{
			pid=p;
			time=t;
		}
		public int compare(Process b)
		{
			if(at<b.at)
				return -1;
			else if(at>b.at)
				return 1;
			return 0;
		}
		public int compareRT(Process b)
		{
			if(rt<b.rt)
				return -1;
			else if(rt>b.rt)
				return 1;
			else
				if(at<b.at)
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
	static Scanner in=new Scanner(System.in);
	public static void main(String args[])
	{
		System.out.println("Enter no. of processes ");
		int n=in.nextInt();
		ArrayList<Process> ar=new ArrayList<>();
		
		input(ar,n);
		Collections.sort(ar,new Comparator<Process>(){
			public int compare(Process a,Process b)
			{
				return a.compare(b);
			}
		});
		ArrayList<Process> ganttChart=new ArrayList<>();
		PriorityQueue<Process> pq=new PriorityQueue<>(new Comparator<Process>(){
			public int compare(Process a,Process b)
			{
				return a.compareRT(b);
			}
		});
		int ct=Math.max(0,ar.get(0).at);
		while(ar.size()>0)
		{
			int init=ar.get(0).at;
			while(ar.size()>0&&ar.get(0).at==init)
			{
				Process p=ar.get(0);
				ar.remove(0);
				p.rt=p.bt;
				System.out.println("Added process "+p.pid+" to PQ at "+ct );
				pq.add(p);
			}
			Process cur=pq.poll();
			//System.out.println("Next process: "+((ar.size()>0)?ar.get(0).pid:0)+" at "+((ar.size()>0)?ar.get(0).at:0) );
			int nextProcessArrival=(ar.size()>0)?ar.get(0).at:Integer.MAX_VALUE;
			int runningTime=Math.min(cur.rt,nextProcessArrival-ct);
			cur.rt=cur.rt-runningTime;
			if(cur.rt>0)
			{
				pq.add(cur);
			}
			ganttChart.add(new Process(cur.pid,new Time(ct,ct+runningTime)));
			ct+=runningTime;
		}
		while(!pq.isEmpty())
		{
			Process cur=pq.poll();
			int runningTime=cur.rt;
			ganttChart.add(new Process(cur.pid,new Time(ct,ct+runningTime)));
			ct+=runningTime;
		}
		printGanttChart(ganttChart);
	}
	static void input(ArrayList ar,int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter pid :");
			int pid=in.nextInt();
			System.out.println("Enter Arrival Time :");
			int at=in.nextInt();
			System.out.println("Enter Burst Time :");
			int bt=in.nextInt();
			ar.add(new Process(pid,at,bt));
		}
	}
	static void printGanttChart(ArrayList<Process> ar)
	{
		System.out.println("PID\tSt. Time\tEnd Time\t");
		for(int i=0;i<ar.size();i++)
		{
			System.out.println(ar.get(i).pid+"\t"+ar.get(i).time.start+"\t\t"+(ar.get(i).time.end));
		}
	}
}
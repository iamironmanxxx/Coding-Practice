import java.util.*;
class SJF
{
	static class Process
	{
		int pid,at,bt;
		public Process(int a,int b,int c)
		{
			bt=c;
			at=b;
			pid=a;
		}
		int st,et;
		public Process(int a,int b,int c,int d,int e)
		{
			pid=a;
			st=b;
			et=c;
			at=d;
			bt=e;
		}
		//add-ons
		int rt;
	}
	static Scanner in=new Scanner(System.in);
	public static void main(String args[])
	{
		int n;
		System.out.println("Enter no. of jobs");
		n=in.nextInt();
		
		Process ar[]=new Process[n];
		getProcesses(ar);
		Arrays.sort(ar,new Comparator<Process>(){
			public int compare(Process a,Process b)
			{
				if(a.at<b.at)
					return -1;
				else if(b.at<a.at)
					return 1;
				return 0;
			}
		});
		
		ArrayList<Process> ganttChart=new ArrayList<>();//
		PriorityQueue<Process> readyQueue=new PriorityQueue<>(new Comparator<Process>(){
			public int compare(Process a,Process b)
			{
				if(a.rt<b.rt)
					return -1;
				else if(b.rt<a.rt)
					return 1;
				else
					if(a.at<b.at)
						return -1;
					return 1;
			}
		});

		int ptr=0;
		int timeDelta=0;
		Process runningProcess=null;
		int currentTime;
		for(currentTime=ar[ptr].at;!(readyQueue.isEmpty()&&ptr>=n);currentTime+=timeDelta)
		{
			int runningTime=Integer.MAX_VALUE,nextArrival=Integer.MAX_VALUE;
			Process p;
			while(ptr<n&&ar[ptr].at==currentTime)
			{
				p=ar[ptr++];
				p.rt=p.bt;
				readyQueue.add(p);
				//System.out.println("Added Process "+p.pid+" to readyQueue at "+currentTime );
			}
			if(ptr<n)
			{
				nextArrival=ar[ptr].at;
			}
			//System.out.println("Next process is coming at "+nextArrival);
			if(runningProcess==null)
			{
				if(!readyQueue.isEmpty())
				{
					runningProcess=readyQueue.poll();
					runningTime=runningProcess.rt;
					runningProcess.st=(currentTime);
					//System.out.println("Process "+runningProcess.pid+" starts running at "+currentTime);
				}
				else
				{
					timeDelta=nextArrival-currentTime;
					continue;

				}
			}
			if(runningProcess.rt==0)
			{
				runningProcess.et=(currentTime);
				//System.out.println("Process "+runningProcess.pid+" stops at "+currentTime);
				ganttChart.add(new Process(runningProcess.pid,runningProcess.st,runningProcess.et,runningProcess.at,runningProcess.bt));
				runningProcess=null;
			}
			if(runningProcess==null)
			{
				timeDelta=0;
				continue;
			}
			timeDelta=Math.min(runningProcess.rt,nextArrival-currentTime);
			runningProcess.rt=(runningProcess.rt-timeDelta);
			//System.out.println("Running process has remaining time "+runningProcess.rt+" at "+currentTime);
			//System.out.println("--\t--\t--\t--");
		}
		runningProcess.et=(currentTime);
		ganttChart.add(new Process(runningProcess.pid,runningProcess.st,runningProcess.et,runningProcess.at,runningProcess.bt));
		printGanttChart(ganttChart);
	}
	public static void getProcesses(Process ar[])
	{
		int pid,at,bt;
		for(int i=0;i<ar.length;i++)
		{
			System.out.println("Enter process ID :");
			pid=in.nextInt();
			System.out.println("Enter Arrival time");
			at=in.nextInt();
			System.out.println("Enter burst time");
			bt=in.nextInt();
			ar[i]=new Process(pid,at,bt);
		}
	}
	public static void printGanttChart(ArrayList<Process> ganttChart)
	{
		int total_tat=0,total_wt=0;
		System.out.println("PID\tStart Time\tEnd Time\tWaiting Time\tTurn Around Time");
		for(int i=0;i<ganttChart.size();i++)
		{
			Process p=ganttChart.get(i);
			int wt=p.st-p.at;
			int tat=wt+p.bt;
			total_wt+=wt;
			total_tat+=tat;
			System.out.println(p.pid+"\t"+p.st+"\t\t"+p.et+"\t\t"+wt+"\t\t"+tat);
		}
		System.out.println("Total WT : "+total_wt);
		System.out.println("Total TAT : "+total_tat);
		System.out.println("Avg. WT : "+(total_wt/(double)ganttChart.size()));
		System.out.println("Avg TAT : "+(total_tat/(double)ganttChart.size()));
	}
}
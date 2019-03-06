import java.util.*;
import java.io.*;
class Abc
{
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int n,x,k;
		n=in.nextInt();
		x=in.nextInt();
		k=in.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		
		int maxFront[]=new int[n];
		int maxBack[]=new int[n];
		int minFront[]=new int[n];
		int minBack[]=new int[n];
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<n;i++)
		{
			if(st.isEmpty()||ar[st.peek()]>=ar[i])
			{
				st.push(i);
			}
			else
			{
				while(!st.isEmpty()&&ar[st.peek()]<ar[i])
				{
					int index=st.pop();
					maxFront[index]=i;
				}
				st.push(i);
			}
		}
		while(!st.isEmpty())
		{
			int index=st.pop();
			maxFront[index]=n;
		}
		st=new Stack<>();
		for(int i=n-1;i>=0;i--)
		{
			if(st.isEmpty()||ar[st.peek()]>=ar[i])
			{
				st.push(i);
			}
			else
			{
				while(!st.isEmpty()&&ar[st.peek()]<ar[i])
				{
					int index=st.pop();
					maxBack[index]=i;
				}
				st.push(i);
			}
		}
		while(!st.isEmpty())
		{
			int index=st.pop();
			maxBack[index]=-1;
		}
		st=new Stack<>();
		for(int i=0;i<n;i++)
		{
			if(st.isEmpty()||ar[st.peek()]<=ar[i])
			{
				st.push(i);
			}
			else
			{
				while(!st.isEmpty()&&ar[i]<ar[st.peek()])
				{
					int index=st.pop();
					minFront[index]=i;
				}
				st.push(i);
			}
		}
		while(!st.isEmpty())
		{
			int index=st.pop();
			minFront[index]=n;
		}
		st=new Stack<>();
		for(int i=n-1;i>=0;i--)
		{
			if(st.isEmpty()||ar[st.peek()]<=ar[i])
			{
				st.push(i);
			}
			else
			{
				while(!st.isEmpty()&&ar[i]<ar[st.peek()])
				{
					int index=st.pop();
					minBack[index]=i;
				}
				st.push(i);
			}
		}
		while(!st.isEmpty())
		{
			int index=st.pop();
			minBack[index]=-1;
		}
		/*System.out.println(Arrays.toString(maxFront));
		System.out.println(Arrays.toString(maxBack));
		System.out.println(Arrays.toString(minFront));
		System.out.println(Arrays.toString(minBack));*/
		long net[]=new long[n];
		long dupNet[]=new long[n];
		long sum=0;
		for(int i=0;i<n;i++)
		{
			long maxFrontCount=maxFront[i]-i-1;
			long maxBackCount=i-maxBack[i]-1;
			long minFrontCount=minFront[i]-i-1;
			long minBackCount=i-minBack[i]-1;
			/*System.out.println("For "+ar[i]);
			System.out.println("maxFront= "+maxFrontCount);
			System.out.println("maxBack= "+maxBackCount);
			System.out.println("minFront= "+minFrontCount);
			System.out.println("minBack= "+minBackCount);*/

			net[i]=(maxBackCount+maxFrontCount+(maxBackCount*maxFrontCount))-(minBackCount+minFrontCount+(minFrontCount*minBackCount));
			/*System.out.println("Max in "+(maxBackCount+maxFrontCount+maxBackCount*maxFrontCount));
			System.out.println("Min in "+(minBackCount+minFrontCount+minFrontCount*minBackCount));*/
			dupNet[i]=net[i];
		}
		//System.out.println(Arrays.toString(net));
		Arrays.sort(dupNet);
		//System.out.println(Arrays.toString(dupNet));
		HashMap<Long,Integer> map=new HashMap<>();
		for(int i=0;i<x;i++)
		{
			if(dupNet[n-1-i]>0)
				map.put(dupNet[n-1-i],1);
			else
				break;
		}
		//System.out.println(map.toString());
		int count=0;
		for(int i=0;i<n;i++)
		{

			if(map.get(net[i])!=null)
			{
				//System.out.print(net[i]+" ");
				ar[i]++;
				count++;
			}
			if(count>=x)
			{
				break;
			}
		}
		//System.out.println();
		for(int i=0;i<n;i++)
		{
			sum+=net[i]*((long)ar[i]);
		}
		System.out.println(sum);
	}
}
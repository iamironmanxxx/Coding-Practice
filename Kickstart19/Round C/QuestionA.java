import java.io.*;
import java.util.*;
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
		int t=in.nextInt();
		for(int g=1;g<=t;g++)
		{
			int n,r,c,sr,sc;
			n=in.nextInt();
			r=in.nextInt();
			c=in.nextInt();
			sr=in.nextInt();
			sc=in.nextInt();
			sr-=1;
			sc-=1;
			int ar[][]=new int[r][c];
			int row[]=new int[r][2];
			int col[]=new int[c][2];
			int pr=sr,pc=sc;
			ar[pr][pc]=1;
			//System.out.println(pr+" "+pc);
			String s=in.next();
			for(int i=0;i<n;i++)
			{
				char inst=s.charAt(i);
				int x=0,y=0;
				switch(inst)
				{
					case 'N':x=-1;
					break;
					case 'E':y=1;
					break;
					case 'W':y=-1;
					break;
					case 'S':x=1;
					break;
				};
				if(ar[pr+x][pc+y]==1)
				{
					pr+=x;
					pc+=y;
				}
				pr+=x;
				pc+=y;
				ar[pr][pc]=1;
				//System.out.println(inst+" "+(pr+1)+" "+(pc+1));
			}
			System.out.println("Case #"+g+": "+(pr+1)+" "+(pc+1));
		}
	}
}
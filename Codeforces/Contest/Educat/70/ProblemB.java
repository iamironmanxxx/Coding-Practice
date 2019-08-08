import java.io.*;
import java.util.*;
class Solution
{
	static int steps[][][][]=new int[10][10][10][10];
	static int values[][][][]=new int[10][10][10][10];
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
	public static void main(String[] args) {
		FastReader in=new FastReader();
		String s=in.next();
		generate();
	}
	public static void generate()
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				for(int k=0;k<10;k++)
				{
					for(int l=0;l<10;l++)
					{
						steps[i][j][k][l]=Integer.MAX_VALUE;
						for(int m=0;m<=10;m++)
						{
							for(int n=0;n<=10;n++)
							{
								int sum=(k*m+l*n)%10;
								if (m==0 && n==0)
									continue;
								if (m+n<steps[i][j][k][l])
								{
									steps[i][j][k][l]=m+n;
									values[i][j][k][l]=(sum+i)%10;
								}

							}
						}
					}


				}
			}
		}

		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				for(int k=0;k<10;k++)
				{
					System.out.print(steps[1][i][j][k]+"," +values[1][i][j][k]+ " ");
				}
			}
			System.out.println();
		}
	}
}
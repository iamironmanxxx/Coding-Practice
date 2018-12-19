import java.util.*;
class Garden4Cycle
{
    static int count=0;
    final static int WHITE=0;
    final static int GRAY=1;
    final static int BLACK=2;
    final static int N=4;
    static int src=0;
    public static void main(String args[])
    {
        Scanner in=new Scanner (System.in);
        int n=in.nextInt();
        int ar[][]=new int[n][n];
        int color[]=new int[n];
        int pre[]=new int[n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                ar[i][j]=in.nextInt();
            }
        }
        for(int i=0;i<n;i++)
        {
            src=i;
            color[i]=GRAY;
            edgeCheck(ar,n,i,color,0);
        }
        System.out.println(count/2);
    }
    public static void edgeCheck(int ar[][],int n,int s,int color[],int edge)
    {
        if(edge==N-1)
        {
            if(ar[s][src]==1)
            {
                count++;
            }
        }
        else
        {
            for(int i=0;i<n;i++)
            {
                if(ar[s][i]==1&&color[i]==WHITE)
                {
                    color[i]=GRAY;
                    edgeCheck(ar,n,i,color,edge+1);
		    color[i]=WHITE;
                }
            }
        }
    }

}

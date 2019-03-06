import java.util.*;
class Abc
{
    static long sum=0;
    static int k;
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int n,m;
        n=in.nextInt();
        m=in.nextInt();
        k=in.nextInt();
        ArrayList<Integer> set=new ArrayList<>();
        int count[]=new int[m];
        for(int i=0;i<m;i++)
        {
            set.add(i);
        }
        int ar[]=new int[n];
        for(int i=0;i<n;i++)
        {
            ar[i]=in.nextInt();
            ar[i]--;
        }
        for(int i=0;i<n;i++)
        {
            if(set.size()==0)
            {
                sum+=n-i;
                break;
            }
            int ind=Collections.binarySearch(set,ar[i]);
            if(ind<0)
            {
                ind=(-ind)-1;
            }
            ind=ind%set.size();
            if(set.get(ind)!=ar[i])
            {
                sum++;
            }
            //System.out.println("Index returned "+ set.get(ind) );
            count[set.get(ind)]++;
            if(count[set.get(ind)]==k)
            {
                set.remove(ind);
            }
        }
        System.out.println(sum);
    }
}
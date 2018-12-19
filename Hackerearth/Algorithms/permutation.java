import java.util.*;
class Abc
{
    static int count=0;
    static Map<String, Integer> map=new HashMap<>();
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Integer ar[]=new Integer[n];
        Integer ans[]={};
        for(int i=0;i<n;i++)
        {
            ar[i]=in.nextInt();
        }
        if(n>1)
        {
            Queue<Integer[]> q=new LinkedList<>();
            //System.out.println("Added "+Arrays.toString(ar));
            q.add(get(ar));
            map.put(convert(ar),0);
            while(!q.isEmpty())
            {
                Integer cp[]=q.poll();
                if(equals(cp,n))
                {
                    ans=cp;
                    break;
                }
                else
                {
                    count++;
                    for(int i=1;i<=n-1;i++)
                    {
                        Integer arr[]=get(cp);
                        for(int j=0;j<=i/2;j++)
                        {
                            int temp=arr[j];
                            arr[j]=arr[i-j];
                            arr[i-j]=temp;
                        }
                        //System.out.println("Added "+Arrays.toString(arr));
                        if(check(arr)==-1)
                        {
                            q.add(arr);
                            map.put(convert(arr),map.get(cp)+1);
                        }
                    }
                }
            }
            //System.out.println(count);
            if(ans!=null)
            System.out.println(check(ans));
        }
        else
        {
            System.out.println(0);
        }
    }
    public static boolean equals(Integer ar[],int n)
    {
        for(int i=0;i<n;i++)
        {
            if(ar[i]!=(i+1))
                return false;
        }
        return true;
    }
    public static Integer[] get(Integer ar[])
    {
        Integer dup[]=new Integer[ar.length];
        for(int i=0;i<ar.length;i++)
        {
            dup[i]=ar[i];
        }
        return dup;
    }
    public static Integer check(Integer ar[])
    {
        String s=convert(ar);
        if(map.get(s)==null)
        {
            return -1;
        }
        return map.get(s);
    }
    public static String convert(Integer ar[])
    {
        String s="";
        for(int i=0;i<ar.length;i++)
        {
            s+=ar[i];
        }
        return s;
    }
}

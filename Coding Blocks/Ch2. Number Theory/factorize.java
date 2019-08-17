import java.util.*;
class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int m=in.nextInt();
		int primes[]={2,3,5,7,11,13};
		int i=0;
		int p=primes[i];
		ArrayList<Integer> factors=new ArrayList<>();
		while(p*p<=m)
		{
			if(m%p==0)
			{
				factors.add(p);
				while(m%p==0)
				{
					m=m/p;
				}
			}
			i++;
			p=primes[i];
		}
		if(m!=1)
		{
			factors.add(m);
		}
		System.out.println(factors.toString());
	}
}
import java.util.*;
import java.io.*;
class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0)
		{
			long n1,n2,n3,mod=1000000007;
			n1=in.nextLong();
			n2=in.nextLong();
			n3=in.nextLong();
			long t2=((Math.min(n2,n3)%mod)*((n1)%mod))%mod+((Math.min(n2,n1)%mod)*((n3)%mod))%mod+((Math.min(n1,n3)%mod)*((n2)%mod))%mod;
			t2%=mod;
			long t3=Math.min(n1,Math.min(n2,n3))%mod;
			n1%=mod;
			n2%=mod;
			n3%=mod;
			long t1=(n1*n2)%mod*n3%mod;
			long ans=((((t1-t2+mod)%mod)+(t3*2%mod)+mod)%mod);
			System.out.println(ans);
		}
	}
}
import java.util.*;
import java.io.*;
import java.math.BigInteger;
class Abc
{
	public static void main(String[] args)
	{
		for (int i=0;i<10;i++)
		{
			Scanner in=new Scanner(System.in);
			String cStr=in.next();
			String kStr=in.next();
			BigInteger C=new BigInteger(cStr);
			BigInteger K=new BigInteger(kStr);
			BigInteger X=(C.subtract(K)).divide(BigInteger.valueOf(2));
			System.out.println((X.add(K)).toString());
			System.out.println(X.toString());
		}
	}
}
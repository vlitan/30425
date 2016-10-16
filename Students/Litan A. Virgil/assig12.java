import java.util.*;
import java.lang.*;
import java.io.*;


class assig2
{
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println("O(n) : " + getFibbLin());
		System.out.println("O(log(n)) : " + getFibbLog());
	}

	private static long getFibbLin()
	{
		long	sum;
		int 	f1;
		int		f2;
		int		f0;
		
		f1 = 1;
		f2 = 1;
		f0 = 0;
		sum = 0;
		while (f0 < 4000000)
		{
			f0 = f1 + f2;
			sum += (f0 % 2 == 0) ? f0 : 0;
			f2 = f1;
			f1 = f0;
		}
		return (sum);
	}
	
	private static long getFibbLog()
	{
		long	sum;
		int 	f1;
		int		f2;
		int		f0;
		
		//TODO magic binary tree
		return (-1);
	}
	
}
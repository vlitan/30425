import java.util.*;
import java.lang.*;
import java.io.*;


class assig3
{
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println("3 digit : " + getPali(2));
		System.out.println("3 digit : " + getPali(3));
		System.out.println("4 digit : " + getPali(4));
	}

	private static long getPali(int digits)
	{
		int max;
		int min;
		
		max = (int)Math.pow(10, digits) - 1;
		min = (int)Math.pow(10, digits - 1);
		for (int i = max; i >= min; i--)
		{
			for (int j = i; j >= min; j--)
			{
				if (isPali(i * j))
				{
					return (i * j);
				}
			}
		}
		return (-1);//no pali found
	}
	
	private static boolean isPali(long nbr)
	{
		//"a palindromic number READS the same both ways"
		return (String.valueOf(nbr).equals(reverseString(String.valueOf(nbr))));
	}
	
	private static String reverseString(String str)
	{
		return ((new StringBuilder(str)).reverse().toString());
	}
	
}
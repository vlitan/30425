import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;


class assig1
{
	public static void main (String[] args)
	{
		int input;
		long result;

		input = getInput();
		result = getResult(input);
		System.out.println(result);
		printSecondTweak();
	}
	private static int getInput()
	{
		//return (1000);
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		return (num);
	}
	private static long getResult(long in)
	{
		long sum;
		
		sum = 0;
		for (long i = 0; i < in; i++)
		{
			if ((i % 3 == 0) || (i % 5 == 0))
			{
				sum += i;
			}
		}
		return (sum);
	}
	private static void printSecondTweak()
	{
		boolean done;
		long	aux;
		
		done = false;
		for (long i = 0; !done; i++)
		{
			if (getResult(i) > Integer.MAX_VALUE)
			{
				System.out.println("the result will overflow Integer for " + i);
			}
			aux = (((i + 1) % 3 == 0) || ((i + 1) % 5 == 0)) ? i : 0;
			if (getResult(i) + i + 1 > Long.MAX_VALUE)
			{
				System.out.println("the result will overflow Long for " + i + 1);
				done = true;
			}
		}
	}
}
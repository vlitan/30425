package sumOfMultiples;
import java.util.*;

public class SumOfMultiples {
	
	public static void main (String[] args){
		Scanner number = new Scanner(System.in);
		System.out.println("Enter the number:");
		int num = number.nextInt();
		int sum=0;
		for (int i=0; i<num; i++){
			if ((i%3==0) || (i%5==0))  {
				sum+=i;
			}
		}
		System.out.println("The sum is:" + sum);
	}

}

package fibonacciSum;

public class FibonacciSum {

	public static void main(String[] args) {
		 int evensum=2, fibonacci[] = new int[1000000];
		 fibonacci[0] = 1;
		 fibonacci[1] = 2;
		 for (int i = 2; ; i++) {
			 
		        fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		        
		        if(fibonacci[i] > 4000000){
		        	break;
		        }
		        
		        if(fibonacci[i] % 2 == 0){
		        	evensum+=fibonacci[i];
		        }
		        
		 }
		 
		 System.out.println("Sum of the even-valued terms is:" +evensum);

	}

}

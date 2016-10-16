package palindrome;

public class LargestPalindrome {

	public static void main(String[] args) {
		
		int product=0, max=0;
		
		for(int num1=999; num1>=100; num1--){
			
			for (int num2=999; num2>=100; num2--){
				
				product = num1 * num2;
				int clone, lastdigit,reverse=0;
				clone = product;
				
				while(clone>0){
					lastdigit = clone % 10;
					reverse = reverse*10 + lastdigit;
					clone = clone / 10;
				}
				
				if ((product == reverse) && (product>max)){
					max = product;
				}
				
			}
		}
		
		System.out.println("The largest palindrome is:" +max);

	}

}

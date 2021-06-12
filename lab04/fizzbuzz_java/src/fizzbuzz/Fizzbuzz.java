package fizzbuzz;

public class Fizzbuzz {
	public String fizzbuzz(int n) {
	   if (((n % 5) == 0) && ((n % 7) == 0)) // Is it a multiple of 5 & 7?
	        return("fizzbuzz");
	   else if ((n % 5) == 0) // Is it a multiple of 5?
		   return("fizz");
	   else if ((n % 7) == 0) // Is it a multiple of 7?
		   return("buzz");
	   else
	        return(Integer.toString(n)); // Not a multiple of 5 or 7
	}
	
}

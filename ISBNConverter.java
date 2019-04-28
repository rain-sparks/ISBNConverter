

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class ISBNConverter {

	public static void main(String[] args) {
		try {
			String input;
			System.out.println("Enter Product ID:");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			while ((input = reader.readLine()) != null) {
				input = input.trim();
				if(input.length() == 0) 
					continue;
				String converted_isbn = convertISBN(input);
				if(converted_isbn == null) {
					System.err.println("[ERR] Incorrect product ID: "+ input);
				}
				else{
					System.out.println("ISBN: "+converted_isbn);
				}
			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}

    /**
    * Convert product ID to ISBN equivalent.
    */
    public static String convertISBN(String productID){
    	if(productID.length() != 12 || !productID.matches("[0-9]+") || productID == null){
    		return null;
    	} 
    	else{
    		String remainder = productID.substring(3);
    		String converted_isbn = remainder + controlDigit(remainder);
    		return converted_isbn;
    	}
    }
    
    /**
    * Calculate error control digit
    */
    public static String controlDigit(String remainder){        
    	int pSum = 0, pos = 10;
    	for(int i=0;i<9;i++){
    		int digit = Integer.parseInt(remainder.charAt(i)+"");
    		pSum += digit * pos--;
    	}
    	int pSumMod11 = pSum%11;
    	int cDigit = (pSumMod11 == 0) ? pSumMod11 : 11 - pSumMod11;
    	if(cDigit == 10){
    		return "x";
    	}
    	else{
    		return cDigit+"";
    	}
    }
}

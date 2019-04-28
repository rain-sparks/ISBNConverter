

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class ISBNConverter {

    public static void main(String[] args) {
        try {
        	System.out.println("Enter Product ID:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while ((input = reader.readLine()) != null) {
                input = input.trim();
                if(input.length() == 0) continue;
                String converted_isbn = convertISBN(input.trim());
                if(converted_isbn == null) {
                System.err.println("[ERROR] Incorrect product ID: "+ input);
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
        if(productID == null || productID.length() != 12 || !productID.matches("[0-9]+")) return null;
        
        String remainder = productID.substring(3);
        String converted_isbn = remainder + errorControlDigit(remainder);
        return converted_isbn;
    }
    
    /**
    * Calculate error control digit
    */
    public static String errorControlDigit(String remainder){        
        int pSum = 0;
        int pos = 10;
        for(int i=0;i<9;i++){
            int digit = Integer.parseInt(remainder.charAt(i)+"");
            pSum += digit * pos--;
        }
        int pSumMod11 = pSum%11;
        int cDigit = (pSumMod11 == 0) ? pSumMod11 : 11 - pSumMod11;
        if(cDigit == 10)
            return "x";
        return cDigit+"";
    }
}
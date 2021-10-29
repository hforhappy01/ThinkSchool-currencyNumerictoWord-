import java.util.*;

public class Main{
    public static void main(String[] args){
        // creating scanner to take the input
        
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the value of currency ");
    
        double currency = scn.nextDouble();
        // converting the currency value into integer
        int n = (int) currency;
    
        
        // printing the currency value
        System.out.println(convert(n) + " ONLY" );
    }
    
    /* by the help of static we are calling the array  without 
    creating object*/
    /* we are creating string array vtwenty which stores value from 0-19
    the no from 0 - 19 are unique therefore we are creating the array of them 
    on the first place*/

    public static final String[] vtwenty = { "","One","Two","Three","Four","Five","Six","Seven",
    "Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen",
    "Seventeen","Eighteen","Ninteen"};

    // for tens value

    public static final String[] tens = {"","","Twenty","Thirty","Forty","Fifty"
    ,"Sixty","Seventy","Eighty","Ninety"};

    

    public static String convert (final int n){
                /* if the currency is in minus or value is in minus than it 
        will return minus + currency() ex-> -23 > ans> Minus Twenty Three*/

        if(n<0){
            return "Minus" + convert(-n);

        }
        
        // when no is less than twenty
        
        else if(n<20){
            return vtwenty[n]; // here n is behaving like index value
        }
        // when no is less than 100

        else if(n<100){
            return tens[n/10] + ((n%10 !=0) ? " ":"")+ vtwenty[n%10]; // ternary operator is for spacing
            // tens [n/10] >> by using n/10 we will get index value ex 40 no is passed n/10 = 4 -> tens[4] =forty
            // if no throws some remainder when divided by 10 then we get that remainder in form of string by calling vtwenty[n%10]
        }
        // when no is less than 1000

        else if(n<1000){
            return vtwenty[n/100] + " Hundred" +((n%100!=0)? " ":"") + convert(n%100);
            // if no is smaller than 1000 and greater than 100 add hundered after vtwenty[index]
            // calling convert function to get the rest of the values after having the values upto Hundred
        }
        // when no is less than one Lakh

        else if(n<100000){
            return convert(n/1000) + " Thousand" +((n%1000!=0)? " ":"") + convert(n%1000);
        }
        // when no is less than one Crore

        else if(n<10000000){
            return convert(n/100000) + " Lakh" +((n%100000!=0)? " ":"") + convert(n%100000);
        }
        else {
            return convert(n/10000000) + " Crore" +((n%10000000!=0)? " ":"") + convert(n%10000000);
        }

    
  
    }


}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringProgram {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter String : ");
        String str = reader.readLine();
        //String str = "日本人 中國的";
        Boolean result = str.matches("\\A\\p{ASCII}*\\z");
        int length = str.length();
        if(length >30 ){
            System.out.println("Length of entered string" + str + " is greater than 30");
        } else if (result == false) {
            System.out.println("Entered String " + str + " contains non-ASCII values");
        } else{
            System.out.println("You have entered string : " + str);
            System.out.println("String contains ASCII values");
            String reverseString = "";
            for(int i=str.length(); i > 0; i--)
            {
                reverseString = reverseString + (str.charAt(i-1));
               // System.out.println(reverseString);
            }
            System.out.println("Reverse of Entered string is : " + reverseString);
        }

    }
}
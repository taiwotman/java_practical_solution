import java.io.*;

public class Palindrom
{
    public static void main (String[] args) throws java.lang.Exception
    {
        
        
        System.out.println(checkPalindrom("Amen icy cinema.")); //Test input
    }


    public static boolean checkPalindrom(String palindrom){
            String str = palindrom.replaceAll("[^A-Za-z]+", "").toUpperCase();
            char[] word = str.toCharArray();
            int i1 = 0;
            int i2 = word.length - 1;
            while (i2 > i1) {
                if (word[i1] != word[i2]) {
                    return false;
                }
                ++i1;
                --i2;
            }
            return true;
        }
        
    
}

import java.util.*;

public class EncryptionTest
{
   public static void main(String args[])
   {
      Scanner input = new Scanner(System.in);
      
      Encryption e = new Encryption(input.nextLine());
      
      int[] alpha = alphaEncrypt(str);
      for(int n : alpha)
         System.out.print(n + " ");
      System.out.println();
      
      String[] beta = betaEncrypt(alpha);
      for(String e : beta)
         System.out.print(e + " ");
      System.out.println();
      
      String[][] gamma = gammaEncrypt(beta);
      for(String[] arr : gamma)
      {
         for(String s : arr)
            System.out.print(s + " ");
         System.out.println();
      }
      
      String[][] delta = deltaEncrypt(gamma);
      for(String[] arr : delta)
      {
         for(String e : arr)
            System.out.print(e + " ");
         System.out.println();
      }
   }
}
import java.util.*;

public class EncryptionTest
{
   public static void main(String args[])
   {
      Scanner input = new Scanner(System.in);
      
      System.out.print("Enter data to be encrypted: ");
      Encryption2 e = new Encryption2(input.nextLine());
      //System.out.println(e);
      /*
      e.alphaEncrypt();
      System.out.println(e);
      
      e.betaEncrypt();
      System.out.println(e);
      
      e.gammaEncrypt();
      System.out.println(e);
      */
      e.betaEncrypt();
      System.out.println(e);

      e.betaDecrypt();
      System.out.println(e);
   }
}
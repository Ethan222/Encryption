import java.util.*;

public class EncryptionTest
{
   public static void main(String args[])
   {
      Scanner input = new Scanner(System.in);
      
      System.out.print("Enter data to be encrypted: ");
      Encryption2 e = new Encryption2(input.nextLine());
      print(e);
      
      e.alphaEncrypt();
      print(e);

      e.betaEncrypt();
      print(e);
            
      e.gammaEncrypt();
      print(e);
            
      e.deltaEncrypt();
      print(e);
      
      e.omegaEncrypt();
      print(e);
      
      e.omegaDecrypt();
      print(e);
      
      e.deltaDecrypt();
      print(e);
      
      e.gammaDecrypt();
      print(e);
      
      e.betaDecrypt();
      print(e);
      
      e.alphaDecrypt();
      print(e);
      
   }

   private static void print(Encryption2 e)
   {
      System.out.printf("%s: %s \n", e.getStatus(), e);
   }
}
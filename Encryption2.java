// Alpha-Beta-Gamma Encryption

import java.util.*;

public class Encryption2
{
   private String original;
   private String encrypted;
   
   public Encryption()
   {
      setData("");
   }
   
   public Encryption(String s)
   {
      setData(s);
   }
   
   public void setData(String s)
   {
      original = s;
      encrypted = original.toUpperCase();
   }
   
   public String getData()
   {
      return encrypted;
   }
   
   private String[] parseString(String s)
   {
      int count = 0;
      for(int i = 0; i < s.length(); i++)
         if(s.charAt(i) == ' ')
            count++;
      
      String[] arr = new String[count];
      for(int i = 0; i < arr.length; i++)
      {
         int index = s.indexOf(" ");
         arr[i] = s.substring(0, index);
         s = s.substring(index + 1, s.length());
      }
      
      return arr;
   }
   
   // encrypt letters to ints
   public void alphaEncrypt()
   {
      encrypted = Encryption.alphaEncrypt(encrypted);
   }
   
   private static String alphaEncrypt(String s)
   {
      String temp = "";
      for(int i = 0; i < s.length(); i++)
      {
         if(s.charAt(i) != " ")
            temp += ((int)s.charAt(i) - 64) + " ";
         else
            temp = temp.substring(0, temp.length() - 1) + "|";
      }
      return temp;
   }
   
   // encrypt ints to roman numerals
   public void betaEncrypt()
   {
      String temp = "";
      int n;
      for(int i = 0; i < encrypted.length(); i++)
      {
         int index = encrypted.indexOf(" ", i);
         n = Integer.parseInt(encrypted.substring(i, index));
         i = index;
         while(n >= 10)
         {
            String += "X";
            n -= 10;
         }
         if(n == 4)
            temp += "IV";
         else if(n == 9)
            temp += "IX";
         else
         {
            if(n >= 5)
            {
               temp += "V";
               n -= 5;
            }
            while(n >= 1)
            {
               temp += "I";
               n--;
            }
         }
         temp += " ";
      }
      encrypted = temp;
   }
   
   // encrypts roman numerals to morse code
   private static void gammaEncrypt()
   {
      final String[] MORSE = { "", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", "-.-", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
      
      String temp = "";
      for(int i = 0; i < encrypted.length(); i++)
      {
         int index = 
         temp[i] = alphaEncrypt(arr[i]);
      }
      
//       for(int[] outer : temp)
//       {
//          for(int inner : outer)
//             System.out.print(inner + " ");
//          System.out.println();
//       }
      
      for(int i = 0; i < temp.length; i++)
      {
         gamma[i] = new String[temp[i].length];
         for(int j = 0; j < temp[i].length; j++)
         {
            gamma[i][j] = MORSE[temp[i][j]];
         }
      }
      return gamma;
   }
   private static String[][] deltaEncrypt(String[][] arr)
   {
      String[][] delta = new String[arr.length][];
      for(int i = 0; i < arr.length; i++)
      {
         delta[i] = new String[arr[i].length];
         for(int j = 0; j < arr[i].length; j++)
         {
            String s = "";
            for(int k = 0; k < arr[i][j].length(); k++)
               s += (arr[i][j].charAt(k) == '-' ? "1" : "0");
            delta[i][j] = s;
         }
      }
      return delta;
   }
}
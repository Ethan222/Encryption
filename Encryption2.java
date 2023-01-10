// Alpha-Beta-Gamma Encryption

import java.util.*;

public class Encryption2
{
   private String original;
   private String[][] encrypted;
   
   public Encryption2()
   {
      setData("");
   }
   
   public Encryption2(String s)
   {
      setData(s);
   }
   
   public void setData(String s)
   {
      original = s;
      String temp = original.toUpperCase();
      encrypted = new String[s.length()][];
      for(int i = 0; i < encrypted.length; i++)
      {
         encrypted[i] = new String[1];
         encrypted[i][0] = temp.substring(i, i + 1);
      }
   }
   
   public String toString()
   {
      String temp = "";
      for(String[] arr : encrypted)
      {
         for(String s : arr)
            temp += s + " ";
         temp += ", ";
      }
      return temp;
   }
   
   // encrypt letters to ints
   public void alphaEncrypt()
   {
      encrypted = this.alphaEncrypt(encrypted);
   }
   
   private String[][] alphaEncrypt(String[][] orig)
   {
      String[][] temp = new String[orig.length][];
      for(int i = 0; i < orig.length; i++)
      {
         temp[i] = new String[orig[i].length];
         for(int j = 0; j < orig[i].length; j++)
         {
            temp[i][j] = (int)orig[i][j].charAt(0) - 64 + "";
         }
      }
      return temp;
   }
   
   // encrypt ints to roman numerals
   public void betaEncrypt()
   {
      String[][] temp = new String[encrypted.length][];
      for(int i = 0; i < temp.length; i++)
      {
         temp[i] = new String[encrypted[i].length];
         for(int j = 0; j < temp[i].length; j++)
            temp[i][j] = "";
      }
      int n;
      for(int i = 0; i < encrypted.length; i++)
      {
         for(int j = 0; j < encrypted[i].length; j++)
         {
            n = Integer.parseInt(encrypted[i][j]);
            while(n >= 10)
            {
            temp[i][j] += "X";
            n -= 10;
            }
            if(n == 4)
               temp[i][j] += "IV";
            else if(n == 9)
               temp[i][j] += "IX";
            else
            {
               if(n >= 5)
               {
                  temp[i][j] += "V";
                  n -= 5;
               }
               while(n >= 1)
               {
                  temp[i][j] += "I";
                  n--;
               }
            }
         }
      }
      encrypted = temp;
   }
   
   /*
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
   */
}

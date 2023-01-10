// Alpha-Beta-Gamma Encryption

public class Encryption2
{
   private String original;
   private String[][] encrypted;
   private enum status {UNENCRYPTED, ALPHA, BETA, GAMMA, DELTA};
   private status encryption = status.UNENCRYPTED;
   
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
      if(encryption == status.UNENCRYPTED)
         return original;
      
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
      encryption = status.ALPHA;
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
      if(encryption == status.UNENCRYPTED)
         alphaEncrypt();
      
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
      encryption = status.BETA;
   }
   
   // encrypts roman numerals to morse code
   public void gammaEncrypt()
   {
      if(encryption != status.BETA) // unencrypted or alpha
         betaEncrypt();
      
      final String[] MORSE = { "", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", "-.-", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
      
      // space out roman numerals
      for(int i = 0; i < encrypted.length; i++)
      {
         String temp = encrypted[i][0];
         encrypted[i] = new String[temp.length()];
         for(int j = 0; j < encrypted[i].length; j++)
            encrypted[i][j] = temp.substring(j, j + 1);
      }

      String[][] temp = alphaEncrypt(encrypted);
      
      for(int i = 0; i < temp.length; i++)
      {
         for(int j = 0; j < temp[i].length; j++)
         {
            temp[i][j] = MORSE[Integer.parseInt(temp[i][j])];
         }
      }
      encrypted = temp;
      encryption = status.GAMMA;
   }
   
   // morse to binary
   public void deltaEncrypt()
   {
      if(encryption != status.GAMMA)   // unencrypted, alpha, or beta
         gammaEncrypt();
      
      String[][] delta = new String[encrypted.length][];
      for(int i = 0; i < delta.length; i++)
      {
         delta[i] = new String[encrypted[i].length];
         for(int j = 0; j < delta[i].length; j++)
         {
            delta[i][j] = "";
            for(int k = 0; k < encrypted[i][j].length(); k++)
               delta[i][j] += (encrypted[i][j].charAt(k) == '-' ? "1" : "0");
         }
      }
      encrypted = delta;
      encryption = status.DELTA;
   }
   
}

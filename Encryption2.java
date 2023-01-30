// Alpha-Beta-Gamma Encryption

public class Encryption2
{
   private String original;   // the original data
   private String[][][] encrypted; // the encrypted data
   private enum status {UNENCRYPTED, ALPHA, BETA, GAMMA, DELTA, OMEGA};
   private status encryption = status.UNENCRYPTED; // which encryption the data is encrypted to
   private final String[] MORSE = { "", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", "-.-", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
   
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
      int numWords = countSpaces(s) + 1;
      encrypted = new String[numWords][][];
      int begin = 0, end = 0;
      for(int i = 0; i < numWords; i++)
      {
         end = s.indexOf(" ", begin + 1);
         String word = temp.substring(begin, end != -1 ? end : temp.length());
         encrypted[i] = new String[word.length()][1];
         for(int j = 0; j < word.length(); j++)
            encrypted[i][j][0] = word.substring(j, j + 1);
         begin = end + 1;
      }
   }

   private static int countSpaces(String s)
   {
      int c = 0;
      for(int i = 0; i < s.length(); i++)
         if(s.charAt(i) == ' ')
            c++;
      return c;
   }
   
   public String toString()
   {
      if(encryption == status.UNENCRYPTED)
         return original;
      
      String temp = "| ";
      for(String[][] word : encrypted)
      {
         for(String[] letter : word)
         {
            for(String s : letter)
               temp += s + " ";
            temp += "  ";
         }
         temp = temp.substring(0, temp.length() - 2) + "|\n| ";
      }
      return temp.substring(0, temp.length() - 3);
   }

   public String getStatus()
   {
      return encryption + "";
   }
   
   public void alphaEncrypt()   // encrypt letters to ints
   {
      String[][][] temp = new String[encrypted.length][][];
      for(int i = 0; i < temp.length; i++)
      {
         temp[i] = new String[encrypted[i].length][];
         for(int j = 0; j < temp[i].length; j++)
         {
            temp[i][j] = new String[encrypted[i][j].length];
            for(int k = 0; k < temp[i][j].length; k++)
               temp[i][j][k] = (int)encrypted[i][j][k].charAt(0) - 64 + "";
         }
      }
      encrypted = temp;
      encryption = status.ALPHA;
   }
   
   public void betaEncrypt()   // encrypt ints to roman numerals
   {
      if(encryption == status.UNENCRYPTED)
         alphaEncrypt();
      
      String[][][] temp = new String[encrypted.length][][];
      for(int i = 0; i < temp.length; i++)
      {
         temp[i] = new String[encrypted[i].length][1];
         for(int j = 0; j < temp[i].length; j++)
            temp[i][j][0] = "";
      }
      int n;
      for(int i = 0; i < temp.length; i++)
      {
         for(int j = 0; j < temp[i].length; j++)
         {
            n = Integer.parseInt(encrypted[i][j][0]);
            while(n >= 10)
            {
               temp[i][j][0] += "X";
               n -= 10;
            }
            if(n == 4)
               temp[i][j][0] += "IV";
            else if(n == 9)
               temp[i][j][0] += "IX";
            else
            {
               if(n >= 5)
               {
                  temp[i][j][0] += "V";
                  n -= 5;
               }
               while(n >= 1)
               {
                  temp[i][j][0] += "I";
                  n--;
               }
            }
         }
      }
      encrypted = temp;
      encryption = status.BETA;
   }
   
   public void gammaEncrypt()   // encrypts roman numerals to numbers (alphabetical indexes)
   {
      if(encryption != status.BETA) // unencrypted or alpha
         betaEncrypt();
            
      // space out roman numerals
      for(int word = 0; word < encrypted.length; word++)
      {
         for(int letter = 0; letter < encrypted[word].length; letter++)
         {
            String temp = encrypted[word][letter][0];
            encrypted[word][letter] = new String[temp.length()];
            for(int i = 0; i < encrypted[word][letter].length; i++)
               encrypted[word][letter][i] = temp.substring(i, i + 1);
         }
      }

      alphaEncrypt();
      encryption = status.GAMMA;
   }
   
   public void deltaEncrypt()   // numbers to morse
   {
      if(encryption != status.GAMMA)   // unencrypted, alpha, or beta
         gammaEncrypt();
      
      for(int i = 0; i < encrypted.length; i++)
      {
         for(int j = 0; j < encrypted[i].length; j++)
         {
            for(int k = 0; k < encrypted[i][j].length; k++)
               encrypted[i][j][k] = MORSE[Integer.parseInt(encrypted[i][j][k])];
         }
      }
      encryption = status.DELTA;
   }

   public void omegaEncrypt()   // morse to binary
   {
      if(encryption != status.DELTA)
         deltaEncrypt();
      
      String[][][] temp = new String[encrypted.length][][];
      for(int i = 0; i < temp.length; i++)
      {
         temp[i] = new String[encrypted[i].length][];
         for(int j = 0; j < temp[i].length; j++)
         {
            temp[i][j] = new String[encrypted[i][j].length];
            for(int k = 0; k < temp[i][j].length; k++)
            {
               temp[i][j][k] = "";
               for(int ii = 0; ii < encrypted[i][j][k].length(); ii++)
                  temp[i][j][k] += (encrypted[i][j][k].charAt(ii) == '-' ? "1" : "0");
            }
         }
      }
      encrypted = temp;
      encryption = status.OMEGA;
   }
   
   /////////// DECRYPTION ///////////
   public void omegaDecrypt() // binary to morse
   {
      String[][][] temp = new String[encrypted.length][][];
      for(int i = 0; i < encrypted.length; i++)
      {
         temp[i] = new String[encrypted[i].length][];
         for(int j = 0; j < encrypted[i].length; j++)
         {
            temp[i][j] = new String[encrypted[i][j].length];
            for(int k = 0; k < temp[i][j].length; k++)
            {
               temp[i][j][k] = "";
               for(int ii = 0; ii < encrypted[i][j][k].length(); ii++)
                  temp[i][j][k] += encrypted[i][j][k].charAt(ii) == '1' ? "-" : ".";
            }
         }
      }
      encrypted = temp;
      encryption = status.DELTA;
   }
   
   public void deltaDecrypt() // morse to numbers
   {
      if(encryption == status.OMEGA)
         omegaDecrypt();
      
      String[][][] temp = new String[encrypted.length][][];
      for(int i = 0; i < encrypted.length; i++)
      {
         temp[i] = new String[encrypted[i].length][];
         for(int j = 0; j < encrypted[i].length; j++)
         {
            temp[i][j] = new String[encrypted[i][j].length];
            for(int k = 0; k < temp[i][j].length; k++)
            {
               for(int ii = 1; ii < MORSE.length; ii++)
               {
                  if(encrypted[i][j][k].equals(MORSE[ii]))
                     temp[i][j][k] = ii + "";
               }
            }
         }
      }
      encrypted = temp;
      encryption = status.GAMMA;
   }

   public void gammaDecrypt() // numbers to roman numerals
   {
      if(encryption != status.GAMMA)
         deltaDecrypt();
      
      alphaDecrypt();
      encryption = status.BETA;
   }

   public void betaDecrypt()  // roman numerals to numbers
   {
      if(encryption != status.BETA)
         gammaDecrypt();
      
      String[][][] temp = new String[encrypted.length][][];
      for(int i = 0; i < temp.length; i++)
      {
         temp[i] = new String[encrypted[i].length][1];
         for(int j = 0; j < temp[i].length; j++)
         {
            // compress roman numerals
            String r = "";
            for(int k = 0; k < encrypted[i][j].length; k++)
               r += encrypted[i][j][k];
            
            temp[i][j] = new String[1];
            int n = 0, k = r.length() - 1;
            while(k >= 0 && r.charAt(k) == 'I')
            {
               n++;
               k--;
            }
            // check for IV and IX
            if(k >= 1 && r.substring(k - 1, k + 1).equals("IV"))
            {
               n += 4;
               k -= 2;
            }
            else if(k >= 1 && r.substring(k - 1, k + 1).equals("IX"))
            {
               n += 9;
               k -= 2;
            }
            if(k >= 0 && r.charAt(k) == 'V')
            {
               n += 5;
               k--;
            }
            while(k >= 0 && r.charAt(k) == 'X')
            {
               n += 10;
               k--;
            }
            temp[i][j][0] = n + "";
         }
      }
      encrypted = temp;
      encryption = status.ALPHA;
   }

   public void alphaDecrypt() // numbers to letters
   {
      String[][][] temp = new String[encrypted.length][][];
      for(int i = 0; i < temp.length; i++)
      {
         temp[i] = new String[encrypted[i].length][];
         for(int j = 0; j < temp[i].length; j++)
         {
            temp[i][j] = new String[encrypted[i][j].length];
            for(int k = 0; k < temp[i][j].length; k++)
               temp[i][j][k] = (char)(Integer.parseInt(encrypted[i][j][k]) + 64) + "";
         }
      }
      encrypted = temp;
      encryption = status.UNENCRYPTED;
   }
}


/**
 * This program genereates random passwords
 *
 * @author Kayla Long
 * @version 11142018
 */
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;
public class SecretPasscodes
{
   public static void main (String[] args) throws IOException
   {
       //Output - Menu
       System.out.println("              Password Generator");
       System.out.println("________________________________________");
       System.out.println("                    Menu");
       System.out.println();
       System.out.println("     [1] All Lowercase");
       System.out.println("     [2] All Uppercase");
       System.out.println("     [3] All Numbers");
       System.out.println("     [4] Lowercase, Numbers");
       System.out.println("     [5] Uppercase, Numbers");
       System.out.println();
       System.out.println("     [6] Quit");
       System.out.println("________________________________________");
       
       //Variables
       Scanner in = new Scanner (System.in);
       Random charGen = new Random();
       PrintWriter charWrite = new PrintWriter (new File ("generatedPass.txt"));
       int choice;
       int passLength;
       
       
       //Output
       System.out.print("Select a category (1-6): ");
       choice = in.nextInt();
       
       while (!(choice <= 6))   //Makes sure input matches the menu choices
       {
           System.out.println(); 
           System.out.println("Entry invalid");
           System.out.print("Select a category (1-6): ");
           choice = in.nextInt();
        }
        
       System.out.println();
       System.out.print("How long will your password be? (Min. 6): ");
       passLength = in.nextInt();
       
       while (!(passLength >= 6))   //Makes sure password length is at least 6
       {
           System.out.println(); 
           System.out.println("Password not long enough");
           System.out.print("How long will your password be? (Min. 6): ");
           passLength = in.nextInt();
        }
        
       if (choice == 1) // Starts All lowercase generator
       {
           for (int charCount = 0; charCount < passLength; charCount++)
           {
               int character = charGen.nextInt((122 - 97) + 1) + 97;
               char entry = (char)character;
               charWrite.print(entry);
           }
       }
       else if (choice == 2) 
       {
          for (int charCount = 0; charCount < passLength; charCount++)
          {
              int character = charGen.nextInt((90 - 65)+ 1) + 65;
              char entry = (char)character;
              charWrite.print(entry);
          } 
       }

       charWrite.close();
    }
}


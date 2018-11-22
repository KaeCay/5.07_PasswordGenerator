
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
       boolean quit = false;
       int choice;
       int passLength;
       
       while (quit == false)
       {
         //Recurring variables
         Scanner in = new Scanner (System.in);
         File genPass = new File ("generatedPass.txt");
         Random charGen = new Random();
         PrintWriter charWrite = new PrintWriter (genPass);
         
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

         if (choice == 6) //Quit
         {
            break;
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
          
         if (choice == 1) //All lowercase generator
         {
             for (int charCount = 0; charCount < passLength; charCount++)
             {
                 int character = charGen.nextInt((122 - 97) + 1) + 97;
                 char entry = (char)character;
                 charWrite.print(entry);
             }
         }
         else if (choice == 2) //All uppercase generator
         {
            for (int charCount = 0; charCount < passLength; charCount++)
            {
                int character = charGen.nextInt((90 - 65)+ 1) + 65;
                char entry = (char)character;
                charWrite.print(entry);
            } 
         }
         else if (choice == 3) //All numbers generator
         {
            for (int charCount = 0; charCount < passLength; charCount++)
            {
              int character = charGen.nextInt((57 - 48)+ 1) + 48;
              char entry = (char)character;
              charWrite.print(entry);
            }
         }
         else if (choice == 4) //Lowercase, numbers generator
         {
            for (int charCount = 0; charCount < passLength; charCount++)
            {
              int character = charGen.nextInt((122 - 97) + 1) + 97;  //lowercase letter
              char entry = (char)character;
              charWrite.print(entry);
              charCount++; //count extra character

              character = charGen.nextInt((57 - 48)+ 1) + 48;  //number
              entry = (char)character;
              charWrite.print(entry);
            }
         }
         else if (choice == 5) //Uppercase, numbers generator
         {
            for (int charCount = 0; charCount < passLength; charCount++)
            {
                int character = charGen.nextInt((90 - 65)+ 1) + 65; //upeprcase letter
                char entry = (char)character;
                charWrite.print(entry); 
                charCount++; //count extra character

                character = charGen.nextInt((57 - 48)+ 1) + 48;  //number
                entry = (char)character;
                charWrite.print(entry);
            } 
         }

       charWrite.close();

       Scanner charRead = new Scanner (genPass);  //initialize reader for generated password
       String password = ""; //initialize password variable
       while (charRead.hasNext())
       {
            password += charRead.next();
       }
       charRead.close();

       System.out.println();
       System.out.println("Here is your new password!");
       System.out.println(password);
       System.out.println();
     }

     System.out.println();
     System.out.println("-------------------------");
     System.out.println("|    Password Generator |");
     System.out.println("|           End         |");
     System.out.println("-------------------------");  
    }
}

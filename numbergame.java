import java.util.Random;
import java.util.Scanner;


public class numbergame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        String ask;

     do {
         int chance = 0;
         int user = 0;
         int limit = 7;
         System.out.println("Computer already selected the number from 1 to 100");
         int compchoice = r.nextInt(100) + 1;


         while (user != compchoice && chance < limit) {
             System.out.println("Guess the number :");
             user = sc.nextInt();
             chance++;


             if (user == compchoice) {
                 System.out.println("Congrats your guess is correct !!!!!");
                 System.out.println("You take " + chance + " Attempts to win !!");
                 System.out.format("The computer selected this %d and your guess is %d\n", compchoice, user);
             } else if (user > compchoice) {

                 System.out.println("you choose the higher value!!! try again ;)");

             } else {
                 System.out.println("you choose the lower value!!! try again ;)");
             }
         }

         if (user != compchoice) {
             System.out.println("You have only " + limit + " Chances for Winning this game!!!");
             System.out.println("Out of chances!!!");
             System.out.println("You are out now !!!");

         }

         System.out.println("PLAY AGAIN ? (Yes Or No) : ");
         ask = sc.next();
     } while(ask.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing !!!");
        sc.close();
    }

}



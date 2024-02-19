package CMSC203_Lab1;

import java.util.Scanner;

public class MovieDriver {

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String opt = "";
        do{
            Movie movie = new Movie();
            System.out.println("Enter the name of a movie: ");
            movie.setTitle(keyboard.nextLine());
            System.out.println("Enter the rating of the movie: ");
            movie.setRating(keyboard.nextLine());
            System.out.println("Enter the number of tickets sold: ");
            movie.setSoldTickets(keyboard.nextInt());
            keyboard.nextLine();
            System.out.println(movie.toString());
            System.out.println("Do you want to enter another? (y/n) ");
            opt = keyboard.nextLine();
        }while(opt.equals("y"));
        System.out.println("Goodbye!");
    }
}

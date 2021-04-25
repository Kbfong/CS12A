import java.util.Scanner;
import java.util.Random;
/*
 *
 *This program computes the chance of winning after a user input amount of games
 * Author: Kody Fong ( kbfong@ucsc.edu)
 *
 *
 */
public class SimCraps
{
    public static void main(String[]args)
    {
        Scanner one = new Scanner(System.in);
        Random rand = new Random();
        double losses = 0;
	double wins = 0;
	int trials =Integer.parseInt(args[0]); //This is for the user to pass an integer in the command line
	int games = trials;
        while(trials>0) //runs through all of the games the user inputs
	    {
                int toss1 = rand.nextInt(6)+1;
                int toss2 = rand.nextInt(6)+1;
                int points = toss1 + toss2;
                if(points == 7 || points ==11)
                    {
			wins++; //adds a win to the win total if 7 or 11
                  

                    }
                else if( points == 2 || points ==3 || points ==12)
                    {
			losses++; //adds a loss to the loss total if 2 3 or 12
                       
                    }
                else //runs through multiple dice rolls when point is achieved until point is achieved again
                    {

                    
                        int toss3 = rand.nextInt(6)+1;
                        int toss4 = rand.nextInt(6)+1;
                        int point2 = toss3 + toss4;
                        if(point2 ==7)
                            {
				losses++; //adds a loss if the roll after point is 7
         

                            }

                        while(point2 !=7 || point2 == points) //keeps running until a 7 or point is achieved
                            {
				
					int toss5 = rand.nextInt(6)+1;
					int toss6 = rand.nextInt(6)+1;
					point2 = toss5 + toss6;
					if(points == point2)
					    {
						wins++; //adds a win if both points are equal
						break; //breaks the loops so the program can run from the start again

					    }
					else if(point2 ==7)
					    {
						losses++; //adds a loss if 7 is achieved after the initial point
						
						break; 
					    }
                            }
			trials--; //allows the loop to run numerous times
                    
		    }
	       
    }
	System.out.println("The probability of winning is " + wins/(wins+losses)); //Gets the probability of winning after x amount of games
    }
} 

  



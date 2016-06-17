package com.Shanklish.RockPaperScissors;

import java.util.Scanner;

public class rpsMain
    {
	public static void main( String[] args )
	{
	    Scanner scan = new Scanner(System.in);
	    
	    rpsApp game = new rpsApp();
	    
	    char quit = ' ';
	    
	    while(quit != 'N')
		{

		game.chooseOpponent();	
			
		 game.play();
		 
		 System.out.println("Play again? (Y/N)");
		 quit = scan.nextLine().toUpperCase().charAt(0);
		 
		}
	    
	    scan.close();
	    
	    game.displayStats();
	}
	
    }

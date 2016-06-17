package com.Shanklish.RockPaperScissors;
import java.util.Scanner;
import com.Shanklish.RockPaperScissors.Enumerators.CHOICES;


public class Player extends Enumerators
    {
	//-----	VARIABLES ----------
	
	Scanner scan;
	
	
	//----- CONSTRUCTOR -------
	
	public Player()
	{
	    super();
	    scan = new Scanner(System.in);
	}
	
	//------ METHOD---------
	
	public CHOICES getChoice()
	{
	    System.out.println("Rock, Paper or Scissors?");
	    char playerChoice = scan.next().toUpperCase().charAt(0);
	    
	    switch ( playerChoice )
		{
		    case 'R':
			return CHOICES.ROCK;
	
		    case 'P':
			return CHOICES.PAPER;
			
		    case 'S':
			return CHOICES.SCISSORS;		
		}
	    
	    System.out.println("Invalid Input");		// none of the above? Try again
	    return getChoice();					//recursive call to restart method
	    
	}
    }

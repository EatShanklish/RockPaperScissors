package com.Shanklish.RockPaperScissors;

import java.util.Scanner;

public class rpsApp extends Enumerators
    {
	// ----------------------------VARIABLES------------------------------------
	
	private Player myPlayer;			// myPlayer is an instance of Player class
	
	private AIplayer computer;			// computer is an instance of AIplayer class	
	
	private String opponent;			//Stores the opponent(Jim, Tim or Brock)
	
	private CHOICES playerChoice;			// used to store the player choice as an enum
	
	private CHOICES computerChoice;			//stores the computer choice as an enum
		
	private RESULT result;				// stores the result of the matchup as an enum
	
	private static int wins;			// tracks wins
	
	private static int losses;			//tracks losses
	
	private static int ties;			// tracks ties
	
	
	//--------------------------------METHODS--------------------------------------
	
	public rpsApp()					//instantiates a computer player and a human player
	{
	    super();
	    
	    myPlayer = new Player();
	    
	    computer = new RandomPlayer();
	        
	}
	
	//-------------------------METHOD TO INITIATE GAMEPLAY---------------------------------
	
	public void play()					
	{
	    if(opponent.equalsIgnoreCase("brock"))
		{
		    computer = new Brock(); 
		    computerChoice = computer.getChoice();
		}
				// returns rock
	    else if(opponent.equalsIgnoreCase("jim"))
		{
		    computer = new RandomPlayer();
		    computerChoice = computer.getChoice();
		}
	    else 
	    {
		computer = new ThirdPlayer();
		computerChoice = computer.getChoice();
	    }
				// retrieves computer choice using random int and switch statement
	    
	    
	    playerChoice = myPlayer.getChoice();		//retrieves player choice using scanner
	    
	    
	    result = getResult();				// stores the result 
	    
	    displayResult();					//displays result
	    
	    stats();						// displays stats
	}
	
	//----------------------METHOD TO CHOSE OPPONENT----------------------------
	
	public String chooseOpponent()
	{
	    Scanner scan = new Scanner(System.in);
	    
	    System.out.println("Would you like to play against Brock, Tim or Jim?(B/J)");
	    String c = scan.nextLine();
	   
	    
	    if(c.equalsIgnoreCase("brock"))
		opponent = "brock";
	    else if(c.equalsIgnoreCase("jim"))
		opponent = "jim";
	    else 
		opponent = "tim";
	    
	    
	    return opponent;
	    
	    
	}
	
	//---------------------METHOD TO DISPLAY STATISTICS---------------------------
	
	public void displayStats()				//Displays results of games
	{
	    System.out.println("You have played " + (wins + losses + ties) + " games");
	    System.out.println("You have won " + wins + " times");
	    System.out.println("You have lost " + losses + " times");
	    System.out.println("You have tied " + ties + " times");
	    
	}
	
	//--------------------METHOD TO CALCULATE STATISTICS---------------------------
	
	private void stats()
	{
	    if(result == RESULT.WIN)		//if result is a win, increment wins variables
		wins++;
	    
	    else if(result == RESULT.LOSE)	// if result is a loss, increments losses variables
		losses++;
	    
	    else
		ties++;				// else, increment ties variables
	}
	
	//--------------------METHOD TO DISPLAY RESULTS---------------------------------
	
	private  void displayResult()		//Displays one of three statements depending on the variables result
	{
	    switch ( result )
		{
		    case WIN:
			System.out.println(playerChoice + " beats " + computerChoice + ". You Win!");			
			break;
		    case LOSE:
			System.out.println(playerChoice + " loses to " + computerChoice +". You Lose!" );
			break;
		    case TIE:
			System.out.println(playerChoice + " equals " + computerChoice +". Draw");
		   
		}
	}
	
	//-------------------------METHOD TO CALCULATE RESULT---------------------------
	
	private RESULT getResult()		// compares the choices of player and computer and returns the result
	{
        	    if(playerChoice == computerChoice)	
        		return RESULT.TIE;
        	    
        	    if(opponent.equalsIgnoreCase("jim"))
        	{
        	    switch ( playerChoice )								 
        		{
        		    case ROCK:
        			return (computerChoice == CHOICES.SCISSORS ? RESULT.WIN : RESULT.LOSE);		//if statement(if scissors, send win else send loss)		
        		    
        		    case PAPER:
        			return (computerChoice == CHOICES.ROCK ? RESULT.WIN : RESULT.LOSE);
        			
        		    case SCISSORS:
        			return (computerChoice == CHOICES.PAPER ? RESULT.WIN : RESULT.LOSE);
        
        		}
        	    
        	    return RESULT.LOSE;		// will never run
        	}
        	    
        	    else if(opponent.equalsIgnoreCase("brock"))
        		{
        		    switch ( playerChoice )								 
        			{
        			    case ROCK:
        				return RESULT.TIE;			
        			    
        			    case PAPER:
        				return RESULT.WIN;
        				
        			    case SCISSORS:
        				return RESULT.LOSE;
        
        			}
        		    return RESULT.LOSE;		// Will never run
        		}
        	    
        	    else				// if Tim,
        	    {
			switch(playerChoice)
			{
			    case ROCK:
				return RESULT.LOSE;
				
			    case PAPER:
				return RESULT.TIE;
				
			    case SCISSORS:
				return RESULT.WIN;
			}
			
			return RESULT.LOSE;
		    }
	    
	}
    }

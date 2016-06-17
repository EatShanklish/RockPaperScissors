package com.Shanklish.RockPaperScissors;

import java.util.Random;

public  class RandomPlayer extends AIplayer
    {
	
	public RandomPlayer()
	{
	    super();
	    
	}
	
	
	public CHOICES getChoice()
	{
	    Random rand = new Random();
	    
	    int x = rand.nextInt(3)+1;
	    
	    switch(x)
	    {
		case 1:
		    return CHOICES.ROCK;
		case 2:
		    return CHOICES.PAPER;
	    }
	    return CHOICES.SCISSORS;
	}
    }

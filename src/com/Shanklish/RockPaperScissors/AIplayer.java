package com.Shanklish.RockPaperScissors;

import java.util.Enumeration;
import java.util.Random;

public abstract class AIplayer extends Enumerators
    {
	//-----	VARIABLES ----------
	
	private Random rand;
	
	
	//----- CONSTRUCTOR -------
	
	public AIplayer()
	{
	    super();
	    rand = new Random();
	}
	
	//------ METHOD---------
	
	public abstract CHOICES getChoice();		//Returns a value of type CHOICES
	
    }


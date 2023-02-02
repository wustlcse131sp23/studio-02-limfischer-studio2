package studio2;

import java.util.Scanner; 


public class Ruin {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		System.out.println ("What is the start amount? ");
		double startAmount = scan.nextDouble();
		System.out.println ("What is the win chance? ");
		double winChance = scan.nextDouble();
		System.out.println ("What is the win limit? ");
		double winLimit = scan.nextDouble();
		double currentAmount = startAmount;
		System.out.println("How many days simulating? ");
		double totalSimulations = scan.nextDouble();
		int numberOfPlays = 0;
		int totalLosses = 0;
		double expectedRuin = 0.0;
		
		for (int i =0; i< totalSimulations; i++)
		{
			
			while (currentAmount > 0 && currentAmount < winLimit)
			{
				numberOfPlays ++;
				if (Math.random() < winChance)
				{
					currentAmount ++;
				}
				else {
					currentAmount --;
				}
			}
			
			System.out.print("Day " + (i+1) + ": " + numberOfPlays + " Plays ");
			
			numberOfPlays = 0;
			
			if (currentAmount == 0)
			{
				System.out.println("Lose");
				totalLosses ++;
			}
			else if (currentAmount == winLimit)
			{
				System.out.println("Win");
		
			}
			
			currentAmount = startAmount;
			
		}
		
		if(winChance == 0.5)
		{
			expectedRuin = (1-(startAmount/winLimit));
		}
		else
		{
			double a = (1-winChance)/winChance;
			expectedRuin = (Math.pow(a,startAmount)-Math.pow(a, winLimit))/(1-Math.pow(a,winLimit));
		}
		
		System.out.println("Losses: " + totalLosses + " Simulations: " + totalSimulations);
		System.out.println("Ruin rate from simulation: " + totalLosses/totalSimulations + " Expected ruin rate: " + expectedRuin);
		
	}

}

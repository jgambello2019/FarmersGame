import java.util.Scanner;


/**
* The user has to try and move the Cabbage, Wolf, Sheep, and Human without any items being eaten
* The wolf eats the sheep if they are left alone
* The sheep eats the cabbage if left alone
* Items are booleans that flip between true and false when moved by the user
* @author Jack Gambello
* @version 1.0
*/
public class FarmersGame
{

	//global scope 
	public static boolean cabb;
	public static boolean sheep;
	public static boolean wolf;
	public static boolean human;
	
	public static void main(String[] args)
	{
		welcome();
		displayGameStatus();
		game();
		
	}
	/**
	*This function prints statements that introduce the user to the game
	*/
	public static void welcome()
	{
		System.out.println("Farmer's Game");
		System.out.println("You (the human) are trying to move the cabbage, sheep, and wolf across the lake.");
		System.out.println("However, you must do so without any items eating each other.");
		System.out.println("The wolf may not be left alone with the sheep or it will eat the sheep.");
		System.out.println("The sheep may not be left alone with the cabbage or it will eat the cabbage.");
		System.out.println("The human must always be on the same side as the item you are trying to move.");
		System.out.println("You may type 'quit' at any time to leave the game");
	}
	
	/**
	*This method prints out the game board before every move made
	*It changes every time the user moves an item
	*/
	public static void displayGameStatus()
	{
		String bank0 = " ";
		String bank1 = " ";
		
		if(!cabb)
			bank0 += "C ";
		else
			bank1 += "C ";
			
		if(!sheep)
			bank0 += "S ";
		else
			bank1 += "S ";
			
		if(!wolf)
			bank0 += "W ";
		else
			bank1 += "W ";
		
		if(!human)
			bank0 += "H ";
		else
			bank1 += "H ";
			
		System.out.println(bank0);
		System.out.println("--------");
		System.out.println(" ≈ ≈ ≈ ≈ \n ≈ ≈ ≈ ≈ \n ≈ ≈ ≈ ≈ ");
		System.out.println("--------");
		System.out.println(bank1);
	}
	
	/**
	*This function checks the status of each boolean to see if the user can keep playing
	*returns 2 if the sheep eats the cabbage
	*returns 3 if the wolf eats the sheep
	*returns 4 if the user has gotten all items across the water
	*returns 0 if the user may proceed to play
	*/
	public static int checkWinner()
	{
	
		if(cabb == false && sheep == false && human == true && wolf == true)
			return 2;
		else if(cabb == true && sheep == true && human == false && wolf == false)
			return 2;
		else if(cabb == false && sheep == true && human == false && wolf == true)
			return 3;
		else if(cabb == true && sheep == false && human == true && wolf == false)
			return 3;
		else if(cabb == true && sheep == true && human == true && wolf == true)
			return 4;
		else
			return 0;
	
	}
	
	/**
	*This is where the user actually plays the game
	*The user inputs the letter of which they'd like to move each round
	*While loop ends when the game is finished
	*/
	public static void game()
	{
		Scanner keyboard = new Scanner(System.in);
		int game = 0;
		while (game == 0)
		{
			System.out.println("Would you like to move C, S, W, or H: ");
			String movement = keyboard.nextLine();
			if (movement.equals("quit"))
			{
				game = 1;
				System.out.println("See you later!");
			}
			else if (movement.equals("H") || movement.equals("h"))
				human = !human;
			else if (movement.equals("C") || movement.equals("c"))
			{
				if (cabb == true && human == true)
					{
					cabb = !cabb;
					human = !human;
					}
				else if (cabb == false && human == false)
					{
					cabb = !cabb;
					human = !human;
					}
				else
					System.out.println("The human must be on the same line in order for you to move");
			}	
			else if (movement.equals("S") || movement.equals("s"))
			{
				if (sheep == true && human == true)
					{
					sheep = !sheep;
					human = !human;
					}
				else if (sheep == false && human == false)
					{
					sheep = !sheep;
					human = !human;
					}
				else
					System.out.println("The human must be on the same line in order for you to move");
			}
			else if (movement.equals("W") || movement.equals("w"))
			{
				if (wolf == true && human == true)
					{
					wolf = !wolf;
					human = !human;
					}
				else if (wolf == false && human == false)
					{
					wolf = !wolf;
					human = !human;
					}
				else
					System.out.println("The human must be on the same line in order for you to move");
			}	
			
			displayGameStatus();
			
			game = checkWinner();
			
		}
		if (game == 2)
			System.out.println("The sheep ate the cabbage you lose.");
		else if (game == 3)
			System.out.println("The wolf ate the sheep you lose.");
		else if (game == 4)
			System.out.print("You win! Everyone made it to the other side!");

}
}
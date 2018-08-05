public class Project_2
{
   public static void main ( String [] args )
   {
      Players dealer = new Players(); //define a new Players object called dealer
      Players player = new Players(); //define a new Players object called player

      String name = Input.getString("What's your name?"); //ask user for name, store in name variable of type String
      player.setName(name); //call setName function and store name variable for the name attribute of player
      System.out.println("Welcome " + player.getName() + " to the amazing world of BlackJack!!! You will be playing with me, the computer.");
      String response = Input.getString("Do you know how to play?(yes or no)"); //ask if the player knows the rules
      if (response.equals("yes")) //if they do, don't explain the rules
         System.out.println("Let's get playing!");
      else //if they don't, explain the rules
         System.out.println(" The rules are very simple. The goal of the game is to get a hand of cards that sum to 21 or at least a sum very close to 21, as close as possible. Number cards have the value of their number, face cards have a value of 10, and you have the choice of an ace being a 1 or 11. Once you and I have our hands, we will sum them in the end to determine the winner.But remember, don't go over 21, or else you lose. Alright, let's get playing!");

      PlayerHand(player); //pass player object reference to PlayerHand method
      DealerHand(dealer); //pass dealer object reference to DealerHand method
      String winner = compare(player , dealer); //compare the player and dealer objects(the sum attribute specifically) to get winner
      if ( winner.equals(player.getName()) || winner.equals("Computer")) //if the winner is the player or dealer, print the winner
          System.out.println(winner + " is the winner! Nice playing!");
      else // if the compare function returns a tie, print it's a tie
          System.out.println("Everybody is the winner! Nice playing!");
   }

   public static void PlayerHand(Players player) //PlayerHand takes a Players object called player
   {
      for ( int x = 1 ; x < 3 ; x++) //Hit initial two cards
         {
           player.Hit(x);
            if (( (player.GetCard(x)).substring(0,3)).equals("Ace")) /*if the rank of any of the card is an ace, ask user if they would like the value of the card to be 1 or 11 and add that value to the sum*/
                 {
                    int y = Input.getInt("Would you like the value of ace to be 1 or 11?");
                    player.AceCard(y);
                 }
         }
      System.out.println("Your first two cards are " + player.GetCard(1) + " and " + player.GetCard(2)); //display the cards to the user
      int x = 3; //card count is now 3 after initial 2 cards
      while(player.getSum() <= 21) //continue the loop for as long as the sum is less than 21 and the player wishes to hit
           {
             String s1 = Input.getString("Would you like to hit or stay?"); //ask whether the user wants to hit or escape
             if (s1.equals("hit")) //if the user wants to hit
                 {
                   player.Hit(x); //Hit a card
                   if (( (player.GetCard(x)).substring(0,3)).equals("Ace")) /*if the rank of any of the card is an ace, ask user if they would like the value of the card to be 1 or 11 and add that value to the sum*/

                       {
                          int y = Input.getInt("Would you like the value of x to be 1 or 11?");
                          player.AceCard(y);
                       }
                 }
             else // if the user wants to stay
                 break; //break out of loop
             System.out.print("Your cards so far are "); //print the users cards
             for (int i = 1 ; i <= x ; i++)
                  System.out.print(player.GetCard(i) + "   ");
              System.out.println("Your sum is " + player.getSum()); //print the users sum
              x++; //increase the card count by 1
            }
       if ( player.getSum() > 21) //say if the player has lost because their sum exceeds 21
                  System.out.println("You have lost, your sum is over 21");

      System.out.println("Your sum is " + player.getSum()); //print the player's final sum
    }

    public static void DealerHand(Players dealer)  //DealerHand takes a Players object called dealer
    {
       int x = 1; //start with card count of 1
       while (dealer.getSum() <=21) //continue the loop for as long as the sum is less than 21
       {
          if (dealer.getSum() <= 17) //continue to hit as long as the sum is less than or equal to 17
            {
             dealer.Hit(x); //Hit a card
             if (( (dealer.GetCard(x)).substring(0,3)).equals("Ace"))/*if the rank of any of the card is an ace, add 11 if the sum is 11 or more less than 21 and add 1 if the sum is less than 11 less than 21*/            

                    if ( 21 - dealer.getSum() >= 11) // if the 
                      dealer.AceCard(11);
                    else 
                      dealer.AceCard(1);
             System.out.print("My cards so far are "); //print the computer's cards
             for (int i = 1 ; i <= x ; i++)
                  System.out.print(dealer.GetCard(i) + "   ");
             System.out.println("My sum is " + dealer.getSum()); //print the computer's sum
            }
          else //if the sum is more than 17, break out of the loop
             break;
       
           x++; //increase the card count by 1
       }
       if ( dealer.getSum() > 21) //say if the computer has lost because its sum exceeds 21
                  System.out.println("I have lost, my sum is over 21");
       System.out.println("My sum is " + dealer.getSum()); //print the computer's final sum
    }


    public static String compare(Players player, Players dealer) // compare takes two Players objects called player and dealer 
    {
       if (dealer.getSum() > 21 && player.getSum() > 21) //if both players sum exceeds 21, both players lost and it's a tie
          return "It's a tie!";     
       if (player.getSum() > 21) //if only player's sum exceeds 21, computer/dealer wins
          return "Computer";
       if (dealer.getSum() > 21) //if only dealer's sum exceeds 21, player wins
          return player.getName();
       if (dealer.getSum() == player.getSum()) //if both objects have same sum, return a tie
          return "It's a tie!";
       if (player.getSum() == 21) //if only player get's 21, the player wins
          return player.getName();
       if (dealer.getSum() == 21) //if only dealer get's 21, the dealer wins
          return "Computer";
       if (player.getSum() > dealer.getSum()) //if player's sum is greater than dealer's sum and none have 21, the player wins
          return player.getName();
       if (dealer.getSum() > player.getSum()) //if dealer's sum is greater than player's sum and none have 21, the dealer wins
          return "Computer";
  
       return "Computer"; 
    }
}

public class Players
{
  private int Sum; //sum of all cards the player has
  private String Name; //name of player
  private Cards [] Card = new Cards [10]; //initialize an array of Card objects
  
  public Players()  //constructor starts player sum as 0
  {
     Sum = 0;
  }

  public void setName(String s1) //method sets name of player given user input
  {
     Name = s1;
  }

  public String getName() //method returns name attribute of players object
  {
     return Name;
  }

  private void setSum(int x) //adds the value of the most recent card to the sum attribute
  {
     Sum += x;
  }

  public int getSum() //method returns the sum attribute
  {
     return Sum;
  }

  private void createCards(int x) //method creates a new Cards object at the x-1 index of the Card Array
  {
     Card[x-1] = new Cards();
  }

     
  public void Hit(int x) /*method calls createCards method, sets Card using method defined in Cards Class, and adds the value of the card picked using value method defined in Cards class taking the rank of the Card as an attribute*/
  {
    createCards(x);
    Card[x-1].setCard();
    //The current card is " + Card[x-1].getCard()
    setSum(Card[x-1].value(Card[x-1].getRank()));
  } 

  public void AceCard(int x) /*since value returns -1 for ace regardless of user choice, get user choice and add 1 to mitigate the -1 returned by value, add value to sum using setSum method*/
  {
     setSum(x + 1);
  }
   

  public String GetCard(int x) //verify that no duplicate cards have been made(only play with one deck) and then return the card using getCard method defined in Cards class
  {
    for(int i = 0 ; i < (x - 1) ; i++)
     {
         if(Card[x-1].getCard() == Card[i].getCard())
           {  
             Hit(x);
             return "Please wait while the random generator generates your card.";
           }
     }
      return Card[x-1].getCard();
  }


}

public class Cards
{

   private static final String RankArray[] = {"Ace" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10" , "Jack" , "Queen" , "King"}; //define an array of ranks, ranks are strings
   private static final String SuiteArray[] = {"Spade" , "Heart" , "Club" , "Diamond"}; //define an array of suites, suites are strings, doesn't have any value but for user reference and checking for duplicity

   private String Rank; //define a Rank attribute for Card objects
   private String Suite; //define a Suite attribute for Card objects

   public String getCard() //returns a string that concatenates Rank attribute and Suite attribute of Card object
   {
      String s1 = Rank + " of " + Suite;
      return s1; 
   }

   public void setCard() //randomly select a Rank and Suite using Math.random() function and set those attributes
   {
      Rank = RankArray[(int) (Math.random() * 13)];
      Suite = SuiteArray[(int) (Math.random() * 4)];
   }
 
   public String getRank() //return rank attribute
   {
      return Rank;
   }

   public String getSuite() //return suite attribute, just in case, should not be necessary
   {
      return Suite;
   }

   public int value(String s1) /*return the value of a card, s1 is the rank from getRank function called outside this class, return 10 for face cards, the value of the number for number cards(numbers are located at their respective indexes in RankArray), return -1for ace to provide opportunity for player to select value*/
   {
      if (s1 == "Jack" || s1 == "Queen" || s1 == "King")
        return 10;
      else if (s1 != "Ace")
         {
           for (int i = 1 ; i < 10 ; i++)
              {
                if (RankArray[i].equals(s1))
                 return (i + 1); 
              }
           return -127;
         }
            else
                return -1; 
    }
}

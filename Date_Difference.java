public class Date_Difference
{
     private static final int month_day[][] = {{1,31} , {2,28} , {3,31} , {4,30} , {5,31} , {6,30} , {7,31} , {8,31} , {9,30} , {10,31} , {11,30} , {12,31}};

     private int dateSum = 0;

     private int year;

     private int month;

     private int day;

     private String dayName;
     
   public Date_Difference()
   {
      month = 6;
      day = 7;
      year = 2017;
      dayName = "Thursday";
   }

   public String getdayName()
   {
       return dayName;
   }

   public void setYear(int y)
   {
      year = y;
   }

   public void setMonth(int m)
   {
      month = m;
   }

   public void setDay(int d)
   {
      day = d;
   }

   public int getMonth()
   {
      return month;
   }

   public int getYear()
   {
      return year;
   }

   public int getDay()
   {
      return day;
   } 

   public int sameYear(int month_1 , int month_2 , int day_1 , int day_2 , int year_1)
   {
      if (month_1 == month_2)
         return (Math.abs(day_2 - day_1));

      for (int i = (month_1+1) ; i < month_2 ; i++)
         {
            dateSum += month_day[i-1][1];
         }
      dateSum += ((month_day[month_1 - 1][1] - day_1) + day_2);

      if (isLeapyear(year_1) == 1  && month_1 <= 2 && month_2 >= 3)
         dateSum++;

      return dateSum;

   }

   public int differentYear(int month_1 , int month_2 , int day_1 , int day_2 , int year_1 , int year_2)
   {
      dateSum += sameYear(month_1 , 12 , day_1 , 31 , year_1) + sameYear(1, month_2 , 1 , day_2 , year_2);
      for (int y = year_1 + 1 ; y < year_2 ; y++)
          dateSum += dayCount(y);

      return dateSum;

   }

   private int dayCount ( int y )
   {

      return 365 + isLeapyear(y);

   }

   private  int isLeapyear (int x)
   {
    if (x % 100 == 0 )
      {
      if (x % 400 == 0)
         return 1;
      else
         return 0;
      }
    else
      {
      if (x %4 == 0)
         return 1;
      else
         return 0;
      }
    }

}








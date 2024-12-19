package Model;

public class Date
{
  private int day;
  private int month;
  private int year;

  // Constructor that initializes day, month, and year with validation
  public Date(int day, int month, int year)
  {
    if (day < 0)
    {
      this.day = 1;  // Ensures day is not negative
    }
    if (day > 31)
    {
      this.day = 31;  // Ensures day does not exceed 31
    }
    else
    {
      this.day = day;
    }

    if (month < 0)
    {
      this.month = 1;  // Ensures month is not negative
    }
    if (month > 12)
    {
      this.month = 12;  // Ensures month does not exceed 12
    }
    else
    {
      this.month = month;
    }
    this.year = year;
  }

  // Returns the day of the date
  public int getDay()
  {
    return this.day;
  }

  // Returns the month of the date
  public int getMonth()
  {
    return this.month;
  }

  // Returns the year of the date
  public int getYear()
  {
    return this.year;
  }

  // Converts the date to a string in the format "day/month/year"
  public String toString()
  {
    return day + "/" + month + "/" + year;
  }
}

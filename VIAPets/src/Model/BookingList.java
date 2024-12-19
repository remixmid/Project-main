package Model;

import java.util.ArrayList;
import java.util.Date;

public class BookingList
{
  private ArrayList<KennelPlace> bookingList;

  // Constructor initializes the booking list
  public BookingList()
  {
    bookingList = new ArrayList<>();
  }

  // Returns the list of bookings
  public ArrayList<KennelPlace> getBookingList()
  {
    return bookingList;
  }

  // Adds a new booking to the list if there's availability
  public void addBooking(Date dateIn, Date dateOut, String pet, Price price)
  {
    Date dateFrom = new Date(dateIn.getDay(), dateIn.getMonth(),
        dateIn.getYear());
    Date dateTo = new Date(dateOut.getDay(), dateOut.getMonth(),
        dateOut.getYear());
    Date dateToCheckIn;
    Date dateToCheckOut;

    for (KennelPlace kennelPlace : bookingList)
    {
      dateToCheckIn = new Date(kennelPlace.getDateIn().getDay(),
          kennelPlace.getDateIn().getMonth(),
          kennelPlace.getDateIn().getYear());
      dateToCheckOut = new Date(kennelPlace.getDateOut().getDay(),
          kennelPlace.getDateOut().getMonth(),
          kennelPlace.getDateOut().getYear());
      if (!dateFrom.after(dateToCheckIn) && !dateFrom.before(dateToCheckOut))
      {
        if (!dateTo.after(dateToCheckIn) && !dateTo.before(dateToCheckOut))
        {
          KennelPlace newKennelPlace = kennelPlace.copy();
          newKennelPlace.setPet(pet);
          newKennelPlace.setPrice(price);
          newKennelPlace.setDateIn(dateIn);
          newKennelPlace.setDateOut(dateOut);
          newKennelPlace.setOccupied(true);
          bookingList.add(newKennelPlace);
          return;
        }
      }
    }
  }

  // Removes a booking from the list
  public void removeBooking(KennelPlace kennelPlace)
  {
    if (bookingList.contains(kennelPlace))
      bookingList.remove(kennelPlace);
  }
}

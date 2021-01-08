package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        msg("Room Number: ",false);
        int number = sc.nextInt();
        msg("Check-in Date (dd/MM/yyyy): ",false);
        Date checkIn = sdf.parse(sc.next());
        msg("Check-out Date (dd/MM/yyyy): ",false);
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            msg("Error in reservation: Check-out date must be after check-in date",true);
        }else{
            Reservation reservation = new Reservation(number,checkIn,checkOut);
            msg(reservation+"",true);
            msg("",true);
            msg("Enter data to update the reservation",true);
            msg("Check-in Date (dd/MM/yyyy): ",false);
            checkIn = sdf.parse(sc.next());
            msg("Check-out Date (dd/MM/yyyy): ",false);
            checkOut = sdf.parse(sc.next());
            Date now = new Date();
            if (checkIn.before(now) || (checkOut.before(now))){
                msg("Error in reservation: Reservation dates for updates must be future days",true);
            }else {
               if (!checkOut.after(checkIn)) {
                    msg("Error in reservation: Check-out date must be after check-in date", true);
                } else {
                    reservation.updateDates(checkIn, checkOut);
                    msg(reservation + "", true);
                }
            }

        }




        msg("Program ended",true);

    }

    public static void msg(String msg,boolean quebraLinha){
        if ((quebraLinha)) {
            System.out.println(msg);
        } else {
            System.out.print(msg);
        }
    }
}

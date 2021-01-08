package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        try {
            msg("Room Number: ", false);
            int number = sc.nextInt();
            msg("Check-in Date (dd/MM/yyyy): ", false);
            Date checkIn = sdf.parse(sc.next());
            msg("Check-out Date (dd/MM/yyyy): ", false);
            Date checkOut = sdf.parse(sc.next());


            Reservation reservation = new Reservation(number, checkIn, checkOut);
            msg(reservation + "", true);
            msg("", true);
            msg("Enter data to update the reservation", true);
            msg("Check-in Date (dd/MM/yyyy): ", false);
            checkIn = sdf.parse(sc.next());
            msg("Check-out Date (dd/MM/yyyy): ", false);
            checkOut = sdf.parse(sc.next());
            Date now = new Date();


            reservation.updateDates(checkIn, checkOut);
            msg("Reservation: " + reservation + "", true);
        } catch (ParseException e){
            msg("Invalid Date Format.",true);

        }catch (DomainException e ){
            msg("Error in reservation: "+e.getMessage(),true );
        }catch (RuntimeException e){
            msg("Unexpected erro: "+e.getMessage(),true);
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

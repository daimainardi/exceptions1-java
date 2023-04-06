package application;

import model.entities.Reservation;
import model.exception.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat datConv = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkin = datConv.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkout = datConv.parse(sc.next());

            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = datConv.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = datConv.parse(sc.next());

            reservation.updateDates(checkin, checkout);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException parseException) {
            System.out.println("Invalid date format");
        }
        catch (DomainException domainException) {
            System.out.println("Error in reservation: " + domainException.getMessage());
        }
        catch (RuntimeException runtimeException){
            System.out.println("Unexpected error");
        }
    }
}
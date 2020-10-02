package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner dado = new Scanner(System.in);

		try {
		
			System.out.print("Enter Room number: ");
			int number = dado.nextInt();
			dado.nextLine();
			System.out.print("Check-in date: (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(dado.nextLine());
			System.out.print("Check-out date: (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(dado.nextLine());
	
		
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			System.out.println();
	
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date: (dd/MM/yyyy): ");
			checkIn = sdf.parse(dado.nextLine());
			System.out.print("Check-out date: (dd/MM/yyyy): ");
			checkOut = sdf.parse(dado.nextLine());
	
			reservation.updateDate(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
	
		} catch (ParseException e) {
			System.out.println("Invalid date!");
		} catch (DomainException e) {
			System.out.println("Error in reservation "+ e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		dado.close();
		
	}

}

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner dado = new Scanner(System.in);

		System.out.print("Enter Room number: ");
		int number = dado.nextInt();
		dado.nextLine();
		System.out.print("Check-in date: (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(dado.nextLine());
		System.out.print("Check-out date: (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(dado.nextLine());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}

		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			System.out.println();

			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date: (dd/MM/yyyy): ");
			checkIn = sdf.parse(dado.nextLine());
			System.out.print("Check-out date: (dd/MM/yyyy): ");
			checkOut = sdf.parse(dado.nextLine());

			String error = reservation.updateDate(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}
		}

		dado.close();

	}

}

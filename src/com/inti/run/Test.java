package com.inti.run;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inti.entities.Hotel;
import com.inti.entities.Reservation;
import com.inti.entities.Voyageur;
import com.inti.service.interfaces.IHotelService;
import com.inti.service.interfaces.IReservationService;
import com.inti.service.interfaces.IVoyageurService;

public class Test {

	public static void main(String[] args) throws ParseException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IHotelService hotelService = (IHotelService) context.getBean("hotelService");
		IVoyageurService voyageurService = (IVoyageurService) context.getBean("voyageurService");
		IReservationService reservationService = (IReservationService) context.getBean("reservationService");
		Voyageur voy1 = new Voyageur();
		voy1.setNomVoyageur("Chopin");
		voy1.setPrenomVoyageur("Frédéric");
		voyageurService.save(voy1);
		
		Hotel hot1 = new Hotel();
		hot1.setNomHotel("RITZ");
		hot1.setNbretoile(5);
		hotelService.save(hot1);
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		Date d1 = formater.parse("01-06-2019");
		Date d2 = formater.parse("01-07-2019");
		
		Reservation res1 = new Reservation();
		res1.setDateReservation(d1);
		reservationService.save(res1);
		Reservation res2 = new Reservation();
		res2.setDateReservation(d2);
		reservationService.save(res2);
		
		List<Voyageur> voyageurs = voyageurService.findAll(Voyageur.class);
				for (Voyageur voyageur : voyageurs) {
					System.out.println(voyageur.toString());
				}
		List<Hotel> hotels = hotelService.findAll(Hotel.class);
		for (Hotel hotel : hotels) {
			System.out.println(hotel.toString());
		}
		List<Reservation> reservations = reservationService.findAll(Reservation.class);
		for (Reservation reservation : reservations) {
			System.out.println(reservation.toString());
		}
	}
}

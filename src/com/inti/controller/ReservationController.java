package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.inti.entities.Reservation;
import com.inti.service.interfaces.IReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	IReservationService reservationService;
	
	
	@RequestMapping(value="/reservations")
	public ModelAndView findAllReservations() {
		ModelAndView model = new ModelAndView("reservations");
		List<Reservation> listReservation = reservationService.findAll(Reservation.class);
		model.addObject("listReservation", listReservation);
		
		return model;
	}
	
}

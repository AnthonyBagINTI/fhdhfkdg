package com.inti.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.inti.entities.Reservation;
import com.inti.entities.Voyageur;
import com.inti.service.interfaces.IReservationService;
import com.inti.service.interfaces.IVoyageurService;

@Controller
public class VoyageurController {
	
	@Autowired
	IVoyageurService voyageurService;
	@Autowired
	IReservationService reservationService;
	
	@RequestMapping(value="/saveVoyageur", method=RequestMethod.POST)
	public ModelAndView saveVoyageur(@ModelAttribute("v") Voyageur voyageur) {
		Set<Reservation> setReservations=new HashSet<Reservation>();
		
		voyageurService.save(voyageur);
		return new ModelAndView("redirect:/voyageurs");
	}
	
	@RequestMapping(value="/voyageurs")
	public ModelAndView findAllVoyageurs(@RequestParam(required = false) Integer page) {
		ModelAndView model = new ModelAndView("voyageurs");
		List<Voyageur> listVoyageur = voyageurService.findAll(Voyageur.class);
		PagedListHolder<Voyageur> pagedListHolder = new PagedListHolder<>(listVoyageur);
		//List<Reservation> listReservation = reservationService.findAll(Reservation.class);
		pagedListHolder.setPageSize(5);
		model.addObject("maxPages",pagedListHolder.getPageCount());
		if(page == null || page<1 || page>pagedListHolder.getPageCount()) {
			page = 1 ;
		}
		model.addObject("page",page);
		
		if(page == null || page<1 || page>pagedListHolder.getPageCount()) {
		pagedListHolder.setPage(0);
		model.addObject("listVoyageur", pagedListHolder.getPageList());
	// model.addObject("listReservation", listReservation);
		model.addObject("v", new Voyageur());
		}else if(page<= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page-1);
			model.addObject("listVoyageur", pagedListHolder.getPageList());
			// model.addObject("listReservation", listReservation);
				model.addObject("v", new Voyageur());
		}
		return model;
	}
	@RequestMapping(value="/delete/{id}")
	public ModelAndView deleteVoyageur(@PathVariable("id") Long id) {
		Voyageur v = voyageurService.findOne(Voyageur.class, id);
		voyageurService.remove(v);
		return new ModelAndView("redirect:/voyageurs");
	}
}

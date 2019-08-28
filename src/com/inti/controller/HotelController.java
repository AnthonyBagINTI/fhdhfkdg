package com.inti.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.inti.entities.Avis;
import com.inti.entities.Hotel;
import com.inti.service.interfaces.IAvisService;
import com.inti.service.interfaces.IHotelService;

@Controller
public class HotelController {

	@Autowired
	IHotelService hotelService;
	@Autowired
	IAvisService avisService;
	
	@RequestMapping(value = "/saveHotel", method = RequestMethod.POST)
	public ModelAndView saveHotel(@ModelAttribute("h") Hotel hotel, @RequestParam("file") MultipartFile file) {
		try {
			hotel.setImage(file.getBytes());
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			hotelService.save(hotel);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/hotels");
	}
	
	@RequestMapping(value="/hotels")
	public ModelAndView findAllHotels() {
		ModelAndView model = new ModelAndView("hotels");
		List<Hotel> listHotel = hotelService.findAll(Hotel.class);
		model.addObject("listHotel", listHotel);
		model.addObject("h",new Hotel());
		return model;
	} 
	@RequestMapping(value="/hotels/{idhotel}")
	public ModelAndView findOneHotels(@PathVariable("idhotel") Long id) {
		ModelAndView model = new ModelAndView("hotels");
		Hotel hotel = hotelService.findOne(Hotel.class, id);
		model.addObject("Hotel", hotel);
		return new ModelAndView("details");
	} 
	
	@RequestMapping(value = "/saveAvis", method = RequestMethod.POST)
	public ModelAndView saveAvis(@ModelAttribute("av") Avis avis) {
		try {
			avisService.save(avis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/details");
	}

	@RequestMapping(value="/aviss")
	public ModelAndView findAllAvis() {
		ModelAndView model = new ModelAndView("aviss");
		List<Avis> listAvis = avisService.findAll(Avis.class);
		model.addObject("listAvis", listAvis);
		model.addObject("a",new Avis());
		return model;
	} 

	
}

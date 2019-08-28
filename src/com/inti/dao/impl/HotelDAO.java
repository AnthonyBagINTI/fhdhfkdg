package com.inti.dao.impl;

import org.springframework.stereotype.Repository;

import com.inti.dao.interfaces.IHotelDAO;
import com.inti.entities.Hotel;

@Repository
public class HotelDAO extends ManagerDAO<Hotel> implements IHotelDAO{

}

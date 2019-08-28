package com.inti.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entities.Hotel;
import com.inti.service.interfaces.IHotelService;

@Service
@Transactional
public class HotelService extends ManagerService<Hotel> implements IHotelService {

}

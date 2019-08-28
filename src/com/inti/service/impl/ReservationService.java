package com.inti.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entities.Reservation;
import com.inti.service.interfaces.IReservationService;

@Service
@Transactional
public class ReservationService extends ManagerService<Reservation> implements IReservationService {

}

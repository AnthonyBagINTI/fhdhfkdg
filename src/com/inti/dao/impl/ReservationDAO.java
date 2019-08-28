package com.inti.dao.impl;

import org.springframework.stereotype.Repository;

import com.inti.dao.interfaces.IReservationDAO;
import com.inti.entities.Reservation;

@Repository
public class ReservationDAO extends ManagerDAO<Reservation> implements IReservationDAO{

}


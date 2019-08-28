package com.inti.dao.impl;

import org.springframework.stereotype.Repository;

import com.inti.dao.interfaces.IDestinationDAO;
import com.inti.entities.Destination;

@Repository
public class DestinationDAO extends ManagerDAO<Destination> implements IDestinationDAO{

}

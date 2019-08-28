package com.inti.dao.impl;

import org.springframework.stereotype.Repository;

import com.inti.dao.interfaces.IVoyageurDAO;
import com.inti.entities.Voyageur;

@Repository
public class VoyageurDAO extends ManagerDAO<Voyageur> implements IVoyageurDAO{

}

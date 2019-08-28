package com.inti.dao.impl;

import org.springframework.stereotype.Repository;

import com.inti.dao.interfaces.IAvisDAO;
import com.inti.entities.Avis;

@Repository
public class AvisDAO extends ManagerDAO<Avis> implements IAvisDAO{

}

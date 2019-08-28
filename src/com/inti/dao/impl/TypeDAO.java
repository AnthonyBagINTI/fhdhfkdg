package com.inti.dao.impl;

import org.springframework.stereotype.Repository;

import com.inti.dao.interfaces.ITypeDAO;
import com.inti.entities.Type;

@Repository
public class TypeDAO extends ManagerDAO<Type> implements ITypeDAO{

}



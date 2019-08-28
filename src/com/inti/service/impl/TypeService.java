package com.inti.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entities.Type;
import com.inti.service.interfaces.ITypeService;

@Service
@Transactional
public class TypeService extends ManagerService<Type> implements ITypeService {

}

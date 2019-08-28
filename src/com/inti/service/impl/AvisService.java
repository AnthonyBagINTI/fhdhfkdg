package com.inti.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entities.Avis;
import com.inti.service.interfaces.IAvisService;

@Service
@Transactional
public class AvisService extends ManagerService<Avis> implements IAvisService {

}

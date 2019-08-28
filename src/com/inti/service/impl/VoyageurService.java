package com.inti.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entities.Voyageur;
import com.inti.service.interfaces.IVoyageurService;

@Service
@Transactional
public class VoyageurService extends ManagerService<Voyageur> implements IVoyageurService {

}

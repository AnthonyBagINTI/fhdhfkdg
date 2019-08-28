package com.inti.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entities.Destination;
import com.inti.service.interfaces.IDestinationService;

@Service
@Transactional
public class DestinationService extends ManagerService<Destination> implements IDestinationService{

}

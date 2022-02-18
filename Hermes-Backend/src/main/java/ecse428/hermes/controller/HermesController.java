package ecse428.hermes.controller;


import ecse428.hermes.service.HermesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
public class HermesController {

    @Autowired
    private HermesService service;
}

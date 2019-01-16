package filRouge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import filRouge.repository.AuteurRepository;
import filRouge.repository.EditeurRepository;
import filRouge.repository.GenreRepository;
import filRouge.repository.OuvrageRepository;

@RestController
@RequestMapping("/catalogue")
public class LivreController
{

	@Autowired
	private OuvrageRepository ouvRepo;
	
	@Autowired
	private AuteurRepository autRepo;
	
	@Autowired
	private EditeurRepository ediRepo;
	
	@Autowired
	private GenreRepository genRepo;
	
	
	
}

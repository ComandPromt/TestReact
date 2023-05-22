package com.pablomonteserin.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablomonteserin.crud.persistence.model.Invitado;
import com.pablomonteserin.crud.persistence.repository.InvitadoRepository;

@CrossOrigin // Para hacer peticiones desde otro servidor
@RestController // Para hacer peticiones REST
@RequestMapping("/persons")
public class InvitadoController {

	@Autowired
	private InvitadoRepository invitadoRepository;
	
	@PostMapping
	public void createPeople(@RequestBody Invitado person) {
		invitadoRepository.save(person);
	}

	@DeleteMapping("/{id}")
	public void deletePeople(@PathVariable("id") Integer id) {
		Invitado i = new Invitado();
		i.setId(id);
		invitadoRepository.delete(i);
	}
	
	@GetMapping
	public List<Invitado> selectPeople() {
		List<Invitado> people = invitadoRepository.findAll();
		return people;
	}
	
	@PutMapping("/{id}")
	public void updatePeople(@RequestBody Invitado person, @PathVariable("id")Integer id) {
		person.setId(id);
		invitadoRepository.save(person);
	}
}
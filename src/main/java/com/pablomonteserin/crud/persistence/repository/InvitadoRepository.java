package com.pablomonteserin.crud.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pablomonteserin.crud.persistence.model.Invitado;


public interface InvitadoRepository extends CrudRepository<Invitado, Integer> {
    List<Invitado> findAll();

}

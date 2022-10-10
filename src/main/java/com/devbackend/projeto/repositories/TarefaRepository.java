package com.devbackend.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devbackend.projeto.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

}

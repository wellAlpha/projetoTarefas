package com.devbackend.projeto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.devbackend.projeto.entities.Tarefa;
import com.devbackend.projeto.infra.FileSaver;
import com.devbackend.projeto.repositories.TarefaRepository;

@Service
public class TarefaService {
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private FileSaver fs;
	
	public List<Tarefa> findAllTarefas(){
		var tasks = tarefaRepository.findAll();
		
		return tasks;
	}
	
	public Tarefa create(Tarefa tarefa, MultipartFile img) {
		if(!img.isEmpty()) {
			tarefa.setPath(fs.write("imgs", img));			
		}
		
		tarefaRepository.save(tarefa);
		
		return tarefa;
	}
	
	public Tarefa get(int id) {
		var result = tarefaRepository.findById(id).get();
		return result;
	}
	
	public Tarefa update(Tarefa tarefa, MultipartFile img) {
		var newTask = this.get(tarefa.getId());
		
		newTask.setTitulo(tarefa.getTitulo());
		newTask.setDescricao(tarefa.getDescricao());
		
		if(!img.isEmpty()) {
			if(tarefa.getPath() != null)
				fs.remove(newTask.getPath());
			
			String path = fs.write("imgs", img);
			
			newTask.setPath(path);
		}
		
		tarefaRepository.save(newTask);
		
		return newTask;
	}
	
	public void delete(int id) {
		var tarefa = this.get(id);
		if(tarefa.getPath() != null)
			fs.remove(tarefa.getPath());
		
		tarefaRepository.delete(tarefa);
	}
	public void confirm(int id) {
		var tarefa = this.get(id);
		
		tarefa.setConcluido(true);
		
		tarefaRepository.save(tarefa);
	}
}

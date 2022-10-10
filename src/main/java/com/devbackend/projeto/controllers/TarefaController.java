package com.devbackend.projeto.controllers;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devbackend.projeto.entities.Tarefa;
import com.devbackend.projeto.services.TarefaService;

@Controller
public class TarefaController {
	
	
	@Autowired
	private TarefaService tarefaService;
	
	@GetMapping("/")
	public ModelAndView get(RedirectAttributes redirectAttributes, ModelAndView modelAndView) {
		var tasks = tarefaService.findAllTarefas();

		modelAndView.setViewName("index");
		
		modelAndView.addObject("allTasks", tasks);
		
		return modelAndView;
	}
	
	@GetMapping("/form")
	public ModelAndView get(ModelAndView modelAndView, Tarefa tarefa) {
		modelAndView.setViewName("form");
		
		return modelAndView;
	}
	
	@PostMapping("/form")
	public ModelAndView postTarefa(MultipartFile img, ModelAndView modelAndView, @Valid Tarefa tarefa, BindingResult erros, RedirectAttributes redirectAttributes) {
		modelAndView.setViewName("redirect:/");
		
		tarefa.setConcluido(false);
		
		if(erros.hasErrors()) {
			return get(modelAndView, tarefa);
		}
		
		Tarefa tarefaStored = tarefaService.create(tarefa, img);
		
		redirectAttributes.addFlashAttribute("msg", tarefaStored != null ? "Salvo com sucesso!" : "Falha ao salvar!");
		return modelAndView;
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView edit(@PathVariable Integer id, ModelAndView modelAndView, Tarefa tarefa) {
		modelAndView.setViewName("formEd");
		modelAndView.addObject("task", tarefaService.get(id));
		
		return modelAndView;
	}
	
	@PostMapping("edit/{id}")
	public ModelAndView update(@PathVariable Integer id, ModelAndView modelAndView, @Valid Tarefa tarefa, BindingResult erros, RedirectAttributes redirectAttributes, MultipartFile img) {
		modelAndView.setViewName("redirect:/");
		
		if(erros.hasErrors()) {
			return edit(id, modelAndView, tarefa);
		}
		tarefa.setId(id);
		
		tarefaService.update(tarefa, img);
		
		redirectAttributes.addFlashAttribute("msg", "Editado com sucesso!");
		
		return modelAndView;
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		tarefaService.delete(id);
		
		redirectAttributes.addFlashAttribute("msg", "Apagado com sucesso!");
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("confirmar/{id}")
	public ModelAndView confirmar(@PathVariable Integer id, ModelAndView modelView, RedirectAttributes redirectAttributes) {
		modelView.setViewName("redirect:/");
		tarefaService.confirm(id);
		redirectAttributes.addFlashAttribute("msg", "Tarefa Concluida com sucesso!");
		return modelView;
	}
	
}

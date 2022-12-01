package max.PI.eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import max.PI.eventos.models.Evento;
import max.PI.eventos.repositories.EventoRepository;

@Controller
@RequestMapping("/eventos")
public class EventosControler {
	
	@Autowired
	private EventoRepository er;
	
	@GetMapping("/form")
	public String form() {
		return "eventos/formEvento";
	}
	
	@PostMapping
	public String adicionar(Evento evento) {
		
		System.out.println(evento);
		er.save(evento);
		
		return "eventos/evento-adicionado";
	}
	
	@GetMapping
	public ModelAndView listar() {
		
		List<Evento> eventos = er.findAll();
		ModelAndView mv = new ModelAndView("eventos/lista");
		mv.addObject("eventos", eventos);
		return mv;
	}
	
}

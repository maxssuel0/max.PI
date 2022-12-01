package max.PI.eventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import max.PI.eventos.models.Evento;
import max.PI.eventos.repositories.EventoRepository;

@Controller
public class EventosControler {
	
	@Autowired
	private EventoRepository er;
	
	@RequestMapping("/eventos/form")
	public String form() {
		return "eventos/formEvento";
	}
	
	@PostMapping("/eventos")
	public String adicionar(Evento evento) {
		
		System.out.println(evento);
		er.save(evento);
		
		return "eventos/evento-adicionado";
	
	}
	
}

package max.PI.eventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import max.PI.eventos.models.Evento;

@Controller
public class EventosControler {
	
	@Autowired
	private EventoRepository er;
	
	@RequestMapping("/eventos/form")
	public String form() {
		return "formEvento";
	}
	
	@PostMapping("/eventos")
	public String adicionar(Evento evento) {
		
		System.out.println(evento);
		
		return "evento-adicionado";
	
	}
	
}

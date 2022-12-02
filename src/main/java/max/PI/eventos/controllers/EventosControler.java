package max.PI.eventos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import max.PI.eventos.models.Evento;
import max.PI.eventos.repositories.ConvidadoRepository;
import max.PI.eventos.repositories.EventoRepository;

@Controller
@RequestMapping("/eventos")
public class EventosControler {

	@Autowired
	private EventoRepository er;
	@Autowired
	private ConvidadoRepository er;

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

	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {

		Optional<Evento> opt = er.findById(id);
		if (opt.isEmpty()) {
			md.setViewName("redirect:/eventos");
			return md;
		}

		md.setViewName("eventos/detalhes");
		Evento evento = opt.get();

		md.addObject("evento", evento);
			
		List<Convidado> convidados = er.findByEvento(evento);
		md.addObject("convidados", convidado);
		
		return md;
	}
	
	@PostMapping("/{idEvento}")
	public String salvarConvidado(@PathVariable Long idEvento, max.PI.eventos.models.convidado convidado) {
		
		System.out.println("id do evento: " + idEvento);
		System.out.println(convidado);
		
		Optional<Evento> opt = er.findById(idEvento);
		if(opt.isEmpty()) {
			return "redirect:/eventos";
		}
		
		Evento evento = opt.get();
		convidado.setEvento(evento);
		
		er.save(convidado);
		
		return "redirect:/eventos/{idEvento}";
		
	}

}

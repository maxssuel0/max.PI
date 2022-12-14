package max.PI.eventos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import max.PI.eventos.models.convidado;

public interface ConvidadoRepository extends JpaRepository<convidado, Long> {
	
	List<Convidado> findByEvento(Evento evento);
}

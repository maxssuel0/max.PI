package max.PI.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import max.PI.eventos.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}

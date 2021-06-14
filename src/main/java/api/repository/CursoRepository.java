package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}

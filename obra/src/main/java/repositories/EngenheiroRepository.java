package repositories;

import domain.Engenheiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngenheiroRepository extends JpaRepository<Engenheiro, Integer> {
}

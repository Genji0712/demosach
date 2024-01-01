package ntt.crud.server.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ntt.crud.server.model.Sach;

public interface SachRepository extends JpaRepository<Sach, Long> {
	List<Sach> findBySachContaining( String tensach);
}

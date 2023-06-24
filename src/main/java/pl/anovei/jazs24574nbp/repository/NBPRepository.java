package pl.anovei.jazs24574nbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.anovei.jazs24574nbp.model.Log;

public interface NBPRepository extends JpaRepository<Log, Long> {

}

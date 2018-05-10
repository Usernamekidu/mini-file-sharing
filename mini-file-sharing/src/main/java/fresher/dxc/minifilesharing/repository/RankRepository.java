package fresher.dxc.minifilesharing.repository;

import fresher.dxc.minifilesharing.model.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankRepository extends JpaRepository<Rank, Integer> {

	Rank findByName(String string);

}

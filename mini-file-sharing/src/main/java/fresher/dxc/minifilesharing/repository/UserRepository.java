package fresher.dxc.minifilesharing.repository;

import fresher.dxc.minifilesharing.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	Page<User> findByActive(Integer active, Pageable pageable);
	Page<User> findByRankIdIdAndActive(Integer rankID, Integer active, Pageable pageable);
	Page<User> findByNameContainingAndActive(String name, Integer active, Pageable pageable);
}

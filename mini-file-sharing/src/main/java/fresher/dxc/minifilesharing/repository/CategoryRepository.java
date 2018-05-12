package fresher.dxc.minifilesharing.repository;

import fresher.dxc.minifilesharing.model.CategoriesType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoriesType, Integer>{
	CategoriesType findByFileType(String type);
	CategoriesType findByCategoryIdId(Integer id);
	
}

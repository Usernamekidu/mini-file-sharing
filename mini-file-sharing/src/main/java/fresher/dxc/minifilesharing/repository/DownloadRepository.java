package fresher.dxc.minifilesharing.repository;

import fresher.dxc.minifilesharing.model.Download;
import fresher.dxc.minifilesharing.model.Files;
import fresher.dxc.minifilesharing.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * This interface extend JpaRepository interface, support method interactive db(direct)
 * @author VuMin
 *
 */
public interface DownloadRepository extends JpaRepository<Download, Integer>{
	/**
	 * Get total size download of user in day
	 * @param idOfUser
	 * @param dateDownload
	 * @return Object(it could be NULL)
	 */
	@Query(value="SELECT SUM(f.size) FROM files f INNER JOIN download d ON f.id=d.id_file"
			+ " WHERE datedownload=:dateDownload AND d.id_user=:idOfUser", nativeQuery=true)
	Object sumSizeDownloadInDay(@Param("idOfUser") int idOfUser, @Param("dateDownload") Date dateDownload);
	
	

	List<Download> findByIdFile(Files idfile);
	Page<Download> findByIdUser(User iduser, Pageable pageable);
	
}

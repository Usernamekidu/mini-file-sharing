package fresher.dxc.minifilesharing.controller;

import fresher.dxc.minifilesharing.model.Files;
import fresher.dxc.minifilesharing.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/file")
public class FileController {
	@Autowired
	private FileService fileService;

	/**
	 * Insert file
	 * 
	 * @param file
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insertFile(@RequestBody Files file) {
		fileService.insertFile(file);
	}

	/**
	 * get all file
	 * 
	 * @return List<Files>
	 */
	@RequestMapping("/all")
	public Page<Files> getAll(Pageable pageable) {
		return fileService.getAll(pageable);
	}
	
	/**
	 * get all file of user by id user(pagination)
	 * 
	 * @param id
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/getByUser/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Files> getFileByUser(@PathVariable int idUser, Pageable pageable) {
		return fileService.getFileByUser(idUser, pageable);
	}
	
	/**
	 * Delete one file(not recommend because foreign key)
	 * 
	 * @param id
	 */
	@RequestMapping("/delete/{idFile}")
	public void delete(@PathVariable int idFile) {
		fileService.delete(idFile);
	}

	/**
	 * Get one file by id file
	 * 
	 * @param id
	 * @return File
	 */
	@RequestMapping(value = "/get/{idFile}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Files getFile(@PathVariable int idFile) {
		return fileService.getFile(idFile);
	}
	
	@RequestMapping(value = "/find/Size/{size}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Files> findBySize(@PathVariable double size, Pageable pageable) {
		return fileService.findBySize(size, pageable);
	}
	
	@RequestMapping(value = "/find/Name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Files> findByName(@PathVariable String name, Pageable pageable) {
		return fileService.findByNameLike(name, pageable);
	}
	
	@RequestMapping(value = "/find/Uploader/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Files> findByUploader(@PathVariable String lastName, Pageable pageable) {
		return fileService.findByUploader(lastName, pageable);
	}
	
	@RequestMapping(value = "/find/FileType/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Files> findByTypeFile(@PathVariable String type, Pageable pageable) {
		return fileService.findByFileType(type, pageable);
	}
	
	@RequestMapping(value = "/find/Category/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Files> findByCategory(@PathVariable String category, Pageable pageable) {
		return fileService.findByCategory(category, pageable);
	}
	
	@RequestMapping(value = "/find/All/{info}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Files> findByAll(@PathVariable String info, Pageable pageable) {
		return fileService.findByAll(info, pageable);
	}
	
	@RequestMapping("/updateSharing/{idFile}")
	public void updateSharing(@PathVariable("idFile") int idFile) {
		fileService.updateSharing(idFile);
	}
	
	@RequestMapping(value="/updateDescription", method=RequestMethod.PUT)
	public void updateDescription(@RequestBody() Files file) {//@RequestParam("idFile") String idFile, @RequestParam("description") String description
		fileService.updateDescription(file.getId(), file.getDescription());
	}
	
}
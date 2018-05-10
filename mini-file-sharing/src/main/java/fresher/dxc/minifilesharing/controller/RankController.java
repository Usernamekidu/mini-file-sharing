package fresher.dxc.minifilesharing.controller;

import fresher.dxc.minifilesharing.model.Rank;
import fresher.dxc.minifilesharing.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rank")
public class RankController {
	
	@Autowired
	private RankService rankService;

	@RequestMapping("/all")
	public List<Rank> getAll(){
		return (List<Rank>) rankService.getAll();
	}
	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable int id){
		rankService.delete(id);
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insert(@RequestBody Rank rank){
		rankService.insert(rank);
	}
	
	@RequestMapping(value="/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Rank getOne(@PathVariable int id){
		return rankService.getOne(id);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(@RequestBody Rank rank){
		rankService.update(rank);
	}
}

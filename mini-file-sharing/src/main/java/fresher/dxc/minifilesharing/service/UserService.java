package fresher.dxc.minifilesharing.service;

import fresher.dxc.minifilesharing.messages.Message;
import fresher.dxc.minifilesharing.model.Rank;
import fresher.dxc.minifilesharing.model.Role;
import fresher.dxc.minifilesharing.model.User;
import fresher.dxc.minifilesharing.repository.RankRepository;
import fresher.dxc.minifilesharing.repository.RoleRepository;
import fresher.dxc.minifilesharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RankRepository rankRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Page<User> getAll(Pageable pageable) {
		PageRequest page = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), Direction.DESC, "name");
		return userRepository.findByActive(1, page);
	}

	public long countRecord() {
		return userRepository.count();
	}

	public void delete(int idUser) {
		User user = userRepository.findOne(idUser);
		if(user!=null){
			user.setActive(0);
			userRepository.saveAndFlush(user);
		}
	}

	public void lock(int id) {
		User user = userRepository.findOne(id);
		if (null != user) {
			user.setActive(0);
			userRepository.flush();
		}
	}

	public User getUser(int id) {
		return userRepository.findOne(id);
	}

	public void updateUser(User user) {
		User u = userRepository.findByEmail(user.getEmail());
		if(null!=u){
			user.setPassword(u.getPassword());
			userRepository.saveAndFlush(user);	
		}
	}

	public Message saveUser(User user) {
		if (null != userRepository.findByEmail(user.getEmail())) {
			return (new Message(false, "There is already a user registered with the email provided"));
		} else {
			if(null!=user.getPassword()){
				user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			} else {
				user.setPassword(bCryptPasswordEncoder.encode(user.getName()));
			}
			user.setActive(1);
			Rank rank = rankRepository.findByName("Bronze");
			user.setRankId(rank);
			Role userRole = roleRepository.findByRole("MEMBER");
			Set<Role> listRole = new HashSet<Role>();//((Set<Role>) new ArrayList<Role>());
			listRole.add(userRole);
			user.setRoleList(listRole);
			userRepository.save(user);
			return (new Message(true, "User has been registered successfully"));
		}
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public Page<User> findByRankId(Integer rankId, Pageable pageable){
		PageRequest page = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), Direction.DESC, "name");
		return userRepository.findByRankIdIdAndActive(rankId, 1, page);
	}
	
	public Page<User> findByName(String name, Pageable pageable){
		PageRequest page = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), Direction.DESC, "name");
		return userRepository.findByNameContainingAndActive(name, 1, page);
	}
}
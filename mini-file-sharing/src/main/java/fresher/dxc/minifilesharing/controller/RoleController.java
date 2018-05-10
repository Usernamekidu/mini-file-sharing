package fresher.dxc.minifilesharing.controller;

import fresher.dxc.minifilesharing.model.Role;
import fresher.dxc.minifilesharing.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleRepository roleReponsitory;

    @RequestMapping("/all")
    public List<Role> getAll() {
        return roleReponsitory.findAll();
    }

    @RequestMapping("/get/{idRole}")
    public Role getRole(@PathVariable Integer idRole) {
        return roleReponsitory.findOne(idRole);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insertFile(@RequestBody Role role) {
        roleReponsitory.save(role);
    }

    @RequestMapping("/updateName/{id}/{name}")
    public void updateName(@PathVariable int id, @PathVariable String name) {
        Role role = roleReponsitory.findOne(id);
        role.setRole(name);
        roleReponsitory.flush();
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        roleReponsitory.delete(id);

    }
}
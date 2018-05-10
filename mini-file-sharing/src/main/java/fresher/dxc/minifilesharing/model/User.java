/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fresher.dxc.minifilesharing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 *
 * @author training
 */
@Entity
@Table(name = "user", catalog = "finalfresherfilesharing", schema = "")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "email", nullable = false, length = 255)
	private String email;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "password", nullable = false, length = 255)
	@JsonIgnore
	private String password;
	@Size(max = 100)
	@Column(name = "name", length = 100)
	private String name;
	@Column(name = "active")
	private Integer active;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "last_name", nullable = false, length = 255)
	private String lastName;

	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false) })
	@ManyToMany
	@JsonIgnoreProperties({ "userList" })
	private Set<Role> roleList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
	@JsonIgnore
	private List<Download> downloadList;

	@OneToMany(mappedBy = "userId")
	@JsonIgnore
	private List<Files> filesList;

	@JoinColumn(name = "rank_id", referencedColumnName = "id")
	@ManyToOne
	private Rank rankId;

	public User() {
	}

	public User(Integer id) {
		this.id = id;
	}

	public User(Integer id, String email, String password, String lastName) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	@XmlTransient
	public List<Download> getDownloadList() {
		return downloadList;
	}

	public void setDownloadList(List<Download> downloadList) {
		this.downloadList = downloadList;
	}

	@XmlTransient
	public List<Files> getFilesList() {
		return filesList;
	}

	public void setFilesList(List<Files> filesList) {
		this.filesList = filesList;
	}

	public Rank getRankId() {
		return rankId;
	}

	public void setRankId(Rank rankId) {
		this.rankId = rankId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "fresher.dxc.minifilesharing.model.User[ id=" + id + " ]";
	}

}

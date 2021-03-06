/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fresher.dxc.minifilesharing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author training
 */
@Entity
@Table(name = "files", catalog = "finalfresherfilesharing", schema = "")
public class Files implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(name = "name", length = 255)
    private String name;
    @Size(max = 255)
    @Column(name = "path", length = 255)
    private String path;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "size", precision = 22)
    private Double size;
    
    @Column(name = "dateupload")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateupload;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "active", nullable = false)
    private int active;
    
    @Column(name = "sharing")
    private Integer sharing;
    
    @Lob
    @Size(max = 16777215)
    @Column(name = "description", length = 16777215)
    private String description;
    
    @OneToMany(mappedBy = "idFile")
    @JsonIgnore
    private List<Download> downloadList;
    
    @JoinColumn(name = "id_type", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CategoriesType idType;
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public Files() {
    }

    public Files(Integer id) {
        this.id = id;
    }

    public Files(Integer id, int active) {
        this.id = id;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Date getDateupload() {
        return dateupload;
    }

    public void setDateupload(Date dateupload) {
        this.dateupload = dateupload;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Integer getSharing() {
        return sharing;
    }

    public void setSharing(Integer sharing) {
        this.sharing = sharing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Download> getDownloadList() {
        return downloadList;
    }

    public void setDownloadList(List<Download> downloadList) {
        this.downloadList = downloadList;
    }

    public CategoriesType getIdType() {
        return idType;
    }

    public void setIdType(CategoriesType idType) {
        this.idType = idType;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Files)) {
            return false;
        }
        Files other = (Files) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csc.mfs.model.Files[ id=" + id + " ]";
    }
    
}

package ru.adeg.dms.saservice.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    @Column(name = "role_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "role", orphanRemoval = true, cascade={CascadeType.REMOVE, CascadeType.MERGE})
    private Set<DocumentTypePermissions> documentTypePermissions = new HashSet<DocumentTypePermissions>();

    @ManyToMany (mappedBy = "roles",  cascade=CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Directory> directoryPermissions = new HashSet<Directory>();

    public Role() {}

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, Set<DocumentTypePermissions> documentTypePermissions) {
        this.name = name;
        this.documentTypePermissions = documentTypePermissions;
    }

    public Long getId() {
        return role_id;
    }

    public void setId(Long id) {
        this.role_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DocumentTypePermissions> getDocumentTypePermissions() {
        return documentTypePermissions;
    }

    public void setDocumentTypePermissions(Set<DocumentTypePermissions> documentTypePermissions) {
        this.documentTypePermissions = documentTypePermissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return getName().equals(role.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

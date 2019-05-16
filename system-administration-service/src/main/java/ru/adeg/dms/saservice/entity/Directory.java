package ru.adeg.dms.saservice.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "directory")
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long directory_id;

    @Column(name = "directory_name", nullable = false)
    private String name;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "parent_directory_id", referencedColumnName = "directory_id")
    private Directory parentDirectory;

    @OneToMany(mappedBy = "parentDirectory", orphanRemoval = true, cascade=CascadeType.ALL)
    private Set<Directory> childDirectories;

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "directory_permissions",
            joinColumns = { @JoinColumn(name = "directory_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<Role> roles = new HashSet<Role>();

    public Directory() {}

    public Directory(String name) {
        this.name = name;
    }

    public Directory(String name, Directory parentDirectory) {
        this.name = name;
        this.parentDirectory = parentDirectory;
    }

    public Directory(String name, Directory parentDirectory, Set<Directory> childDirectories) {
        this.name = name;
        this.parentDirectory = parentDirectory;
        this.childDirectories = childDirectories;
    }

    public Long getId() {
        return directory_id;
    }

    public void setId(Long id) {
        this.directory_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(Directory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public Set<Directory> getChildDirectories() {
        return childDirectories;
    }

    public void setChildDirectories(Set<Directory> childDirectories) {
        this.childDirectories = childDirectories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Directory)) return false;
        Directory directory = (Directory) o;
        return getId().equals(directory.getId()) &&
                getName().equals(directory.getName()) &&
                Objects.equals(getParentDirectory(), directory.getParentDirectory()) &&
                Objects.equals(getChildDirectories(), directory.getChildDirectories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getParentDirectory(), getChildDirectories());
    }
}

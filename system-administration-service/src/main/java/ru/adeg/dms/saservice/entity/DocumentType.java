package ru.adeg.dms.saservice.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "document_type")
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long document_type_id;

    @Column(name = "document_type_name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "document_type_templates",
            joinColumns = { @JoinColumn(name = "document_type_id") },
            inverseJoinColumns = { @JoinColumn(name = "template_id") })
    private Set<Template> templates = new HashSet<Template>();

    @OneToMany(mappedBy = "document_type", orphanRemoval = true, cascade={CascadeType.REMOVE, CascadeType.MERGE})
    private Set<DocumentTypePermissions> documentTypePermissions = new HashSet<DocumentTypePermissions>();

    public DocumentType() {}

    public DocumentType(String name) {
        this.name = name;
    }

    public DocumentType(String name, Set<Template> templates, Set<DocumentTypePermissions> documentTypePermissions) {
        this.name = name;
        this.templates = templates;
        this.documentTypePermissions = documentTypePermissions;
    }

    public Long getId() {
        return document_type_id;
    }

    public void setId(Long id) {
        this.document_type_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(Set<Template> templates) {
        this.templates = templates;
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
        if (!(o instanceof DocumentType)) return false;
        DocumentType that = (DocumentType) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

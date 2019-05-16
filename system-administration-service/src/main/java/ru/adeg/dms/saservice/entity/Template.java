package ru.adeg.dms.saservice.entity;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Template")
@Table(name = "template", schema = "documents")
public class Template{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long template_id;

    @Column(name = "template_name", nullable = false, unique = true)
    private String name;

    @ManyToMany (mappedBy = "templates",  cascade=CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<DocumentType> documentTypes = new HashSet<>();

    @OneToMany(mappedBy = "template", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<TemplateAttributes> templateAttributes = new HashSet<TemplateAttributes>(0);

    public Template() {}

    public Template(String name) {
        this.name = name;
    }

    public void addAttribute(Attribute attribute, Boolean isMandotory) {
        TemplateAttributes temp = new TemplateAttributes(this, attribute, isMandotory);
        templateAttributes.add(temp);
        attribute.getTemplateAttributes().add(temp);
    }

    public void removeAttribute(Attribute attribute) {
        for (Iterator<TemplateAttributes> iterator = templateAttributes.iterator();
             iterator.hasNext(); ) {
            TemplateAttributes templatesAttributes = iterator.next();

            if (templatesAttributes.getTemplate().equals(this) &&
                    templatesAttributes.getAttribute().equals(attribute)) {
                iterator.remove();
                templatesAttributes.getAttribute().getTemplateAttributes().remove(templatesAttributes);
                templatesAttributes.setTemplate(null);
                templatesAttributes.setAttribute(null);
            }
        }
    }

    public Long getId() {
        return template_id;
    }

    public void setId(Long id) {
        this.template_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<DocumentType> getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(Set<DocumentType> documentTypes) {
        this.documentTypes = documentTypes;
    }

    public Set<TemplateAttributes> getTemplateAttributes() {
        return templateAttributes;
    }

    public void setTemplateAttributes(Set<TemplateAttributes> templateAttributes) {
        this.templateAttributes = templateAttributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Template)) return false;
        Template template = (Template) o;
        return Objects.equals(getName(), template.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}

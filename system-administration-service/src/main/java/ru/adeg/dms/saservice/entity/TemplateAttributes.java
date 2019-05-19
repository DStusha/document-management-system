package ru.adeg.dms.saservice.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "template_attributes", uniqueConstraints = { @UniqueConstraint( columnNames = { "template_id", "attribute_id" } ) } )
public class TemplateAttributes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long template_attributes_id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "template_id", referencedColumnName = "template_id")
    private Template template;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id", referencedColumnName = "attribute_id")
    private Attribute attribute;

    @Column(name = "is_mandatory", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isMandatory;

    public TemplateAttributes() {}

    public TemplateAttributes(Template template, Attribute attribute, boolean isMandatory) {
        this.template = template;
        this.attribute = attribute;
        this.isMandatory = isMandatory;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }

    public Long getTemplate_attributes_id() {
        return template_attributes_id;
    }

    public void setTemplate_attributes_id(Long template_attributes_id) {
        this.template_attributes_id = template_attributes_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemplateAttributes)) return false;
        TemplateAttributes that = (TemplateAttributes) o;
        return Objects.equals(getTemplate(), that.getTemplate()) &&
                Objects.equals(getAttribute(), that.getAttribute());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTemplate(),getAttribute());
    }
}

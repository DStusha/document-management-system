package ru.adeg.dms.saservice.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "document_type_permissions", uniqueConstraints = { @UniqueConstraint( columnNames = { "document_type_id", "role_id" } ) })
public class DocumentTypePermissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long document_type_permissions_id;

    @ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "document_type_id", referencedColumnName = "document_type_id")
    private DocumentType document_type;

    @ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;

    @Column(name = "card_editing_permission", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean cardEditingPermission;

    @Column(name = "card_view_permission", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean cardViewPermission;

    @Column(name = "text_view_permission", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean textViewPermission;

    @Column(name = "delete_document_permission", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean deleteDocumentPermission;

    public DocumentTypePermissions() {
    }

    public DocumentTypePermissions(DocumentType document_type, Role role, boolean cardEditingPermission, boolean cardViewPermission, boolean textViewPermission, boolean deleteDocumentPermission) {
        this.document_type = document_type;
        this.role = role;
        this.cardEditingPermission = cardEditingPermission;
        this.cardViewPermission = cardViewPermission;
        this.textViewPermission = textViewPermission;
        this.deleteDocumentPermission = deleteDocumentPermission;
    }

    public DocumentType getDocument_type() {
        return document_type;
    }

    public void setDocument_type(DocumentType document_type) {
        this.document_type = document_type;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isCardEditingPermission() {
        return cardEditingPermission;
    }

    public void setCardEditingPermission(boolean cardEditingPermission) {
        this.cardEditingPermission = cardEditingPermission;
    }

    public boolean isCardViewPermission() {
        return cardViewPermission;
    }

    public void setCardViewPermission(boolean cardViewPermission) {
        this.cardViewPermission = cardViewPermission;
    }

    public boolean isTextViewPermission() {
        return textViewPermission;
    }

    public void setTextViewPermission(boolean textViewPermission) {
        this.textViewPermission = textViewPermission;
    }

    public boolean isDeleteDocumentPermission() {
        return deleteDocumentPermission;
    }

    public void setDeleteDocumentPermission(boolean deleteDocumentPermission) {
        this.deleteDocumentPermission = deleteDocumentPermission;
    }

    public Long getDocument_type_permissions_id() {
        return document_type_permissions_id;
    }

    public void setDocument_type_permissions_id(Long document_type_permissions_id) {
        this.document_type_permissions_id = document_type_permissions_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentTypePermissions)) return false;
        DocumentTypePermissions that = (DocumentTypePermissions) o;
        return getDocument_type().equals(that.getDocument_type()) &&
                getRole().equals(that.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDocument_type(), getRole());
    }
}
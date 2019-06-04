package ru.adeg.dms.drservice.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document(collection = "documents")
public class DocumentMetadata {
    @Id
    private ObjectId _id;
    private Date upload_date;
    private String directory_name;
    private String document_type;
    private String user;
    private String file_path;
    private String text;
    private List<Attribute> attributes;
    private Permissions permissions;

    public DocumentMetadata() { }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public Date getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(Date upload_date) {
        this.upload_date = upload_date;
    }

    public String getDirectory_name() {
        return directory_name;
    }

    public void setDirectory_name(String directory_name) {
        this.directory_name = directory_name;
    }

    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentMetadata)) return false;
        DocumentMetadata documentMetadata = (DocumentMetadata) o;
        return getDirectory_name().equals(documentMetadata.getDirectory_name()) &&
                getDocument_type().equals(documentMetadata.getDocument_type()) &&
                getUser().equals(documentMetadata.getUser()) &&
                getFile_path().equals(documentMetadata.getFile_path());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFile_path());
    }
}

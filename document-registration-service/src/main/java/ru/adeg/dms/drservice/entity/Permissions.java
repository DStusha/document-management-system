package ru.adeg.dms.drservice.entity;

import java.util.List;

public class Permissions {
    private List<String> card_editing;
    private List<String> card_view;
    private List<String> text_view;
    private List<String> delete;

    public Permissions() {
    }

    public Permissions(List<String> card_editing, List<String> card_view, List<String> text_view, List<String> delete) {
        this.card_editing = card_editing;
        this.card_view = card_view;
        this.text_view = text_view;
        this.delete = delete;
    }

    public List<String> getCard_editing() {
        return card_editing;
    }

    public void setCard_editing(List<String> card_editing) {
        this.card_editing = card_editing;
    }

    public List<String> getCard_view() {
        return card_view;
    }

    public void setCard_view(List<String> card_view) {
        this.card_view = card_view;
    }

    public List<String> getText_view() {
        return text_view;
    }

    public void setText_view(List<String> text_view) {
        this.text_view = text_view;
    }

    public List<String> getDelete() {
        return delete;
    }

    public void setDelete(List<String> delete) {
        this.delete = delete;
    }
}

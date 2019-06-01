package ru.adeg.dms.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Role {
    private Long id;
    private String name;
}

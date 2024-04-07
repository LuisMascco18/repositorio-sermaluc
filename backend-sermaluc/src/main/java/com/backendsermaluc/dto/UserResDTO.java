package com.backendsermaluc.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserResDTO {

    @EqualsAndHashCode.Include
    @Schema(name = "id", description = "codigo de usuario")
    private Integer id;

    @NotNull
    @Schema(name = "created", description = "fecha de creacion")
    private LocalDateTime created;

    @NotNull
    @Schema(name = "modified", description = "fecha de modificacion")
    private LocalDateTime modified;

    @NotNull
    @Schema(name = "last_login", description = "fecha de ultimo ingreso")
    private LocalDateTime last_login;

    @NotNull
    @Schema(name = "token", description = "token")
    private String token;

    @NotNull
    @Schema(name = "isActive", description = "activo")
    private boolean isActive;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String getCreated() {
        return this.created.format(FORMATTER);
    }

    public String getModified() {
        return this.modified.format(FORMATTER);
    }

    public String getLast_login() {
        return this.last_login.format(FORMATTER);
    }

}

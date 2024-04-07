package com.backendsermaluc.dto;

import com.backendsermaluc.model.Phone;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserReqDTO {
    @EqualsAndHashCode.Include
    @Schema(name = "idUser", description = "codigo de usuario")
    private Integer idUser;

    @NotNull
    @Schema(name = "name", description = "nombre de usuario")
    private String name;

    @NotNull
    @Schema(name = "email", description = "email de usuario")
    private String email;

    @NotNull
    @Schema(name = "password", description = "contraseña de usuario")
    private String password;

    @JsonManagedReference
    @NotNull
    @Schema(name = "phones", description = "lista de telefonos")
    private List<PhoneReqDTO> phones;

}

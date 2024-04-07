package com.backendsermaluc.dto;

import com.backendsermaluc.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PhoneReqDTO {
    @EqualsAndHashCode.Include
    @Schema(name = "idPhone", description = "codigo de telefono")
    private Integer idPhone;

    @JsonBackReference
    private UserReqDTO user;

    @NotNull
    @Schema(name = "number", description = "numero de telefono")
    private String number;

    @NotNull
    @Schema(name = "citycode", description = "codigo de ciudad")
    private String citycode;

    @NotNull
    @Schema(name = "contrycode", description = "codigo de pais")
    private String contrycode;
}

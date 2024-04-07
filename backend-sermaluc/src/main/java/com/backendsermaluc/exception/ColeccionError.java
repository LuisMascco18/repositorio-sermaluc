package com.backendsermaluc.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ColeccionError {
    public List<MensajeErrorDTO>obtenerError(String request){
        List<MensajeErrorDTO>listEl = listaError();
        return  listEl.stream().filter(x->x.getCodigo().equalsIgnoreCase(request)).collect(Collectors.toList());
    }

    public List<MensajeErrorDTO> listaError(){
        List<MensajeErrorDTO> response = new ArrayList<>();
        MensajeErrorDTO obj = new MensajeErrorDTO("01","El correo ya registrado");
        response.add(obj);
        MensajeErrorDTO obj2 = new MensajeErrorDTO("02","El correo no tiene el formato adecuado");
        response.add(obj2);
        MensajeErrorDTO obj3 = new MensajeErrorDTO("03","La contraseña no tiene el formado adecuado");
        response.add(obj3);
        return response;
    }
}

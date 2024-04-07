package com.backendsermaluc.service.impl;

import com.backendsermaluc.config.ApplicationProperties;
import com.backendsermaluc.dto.UserReqDTO;
import com.backendsermaluc.dto.UserResDTO;
import com.backendsermaluc.exception.ModelNotFoundException;
import com.backendsermaluc.model.User;
import com.backendsermaluc.repo.IUserRepo;
import com.backendsermaluc.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepo repo;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    private final ApplicationProperties ap;
    @Override
    public UserResDTO registrar(UserReqDTO request) {
        UserResDTO response = new UserResDTO();

        //Validamos si el correo es unico
        if(repo.findByEmail(request.getEmail())!=null){
            throw new ModelNotFoundException("01");
        }

        //Validamos si el correo tiene el formato adecuado
        if(!validarRegex(request.getEmail(),
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")){
            throw new ModelNotFoundException("02");
        }

        //Validamos si la contraseña tiene el formato adecuado
        if(!validarRegex(request.getPassword(),ap.getPasswordValue())){
            throw new ModelNotFoundException("03");
        }

        //Convertimos, insertamos registros y regresamos dto
        response = modelMapper.map(repo.save( modelMapper.map(request, User.class)),UserResDTO.class);

        return response;
    }


    /**
     * Este metodo es creado para validar segun un regex ingresado
     * @author. Luis Mascco
     * @version 06/04/2024
     */
    public boolean validarRegex(String request, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(request);
        return matcher.matches();
    }


}

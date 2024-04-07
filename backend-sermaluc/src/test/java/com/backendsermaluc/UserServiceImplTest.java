package com.backendsermaluc;


import com.backendsermaluc.config.ApplicationProperties;
import com.backendsermaluc.dto.PhoneReqDTO;
import com.backendsermaluc.dto.UserReqDTO;
import com.backendsermaluc.dto.UserResDTO;
import com.backendsermaluc.model.Phone;
import com.backendsermaluc.model.User;
import com.backendsermaluc.repo.IUserRepo;
import com.backendsermaluc.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl service;

    @Mock
     IUserRepo repo;

    @Mock
    ApplicationProperties ap;

    @Spy
    ModelMapper mp;

    @Test
    public void registrarUser(){
        UserReqDTO request = new UserReqDTO();
        request.setName("Juan Rodriguez");
        request.setEmail("juan@rodriguez.org");
        request.setPassword("hunter2");
            PhoneReqDTO phone = new PhoneReqDTO();
            phone.setNumber("1234567");
            phone.setCitycode("1");
            phone.setContrycode("57");
            List<PhoneReqDTO> listPho = new ArrayList<>();
            listPho.add(phone);
        request.setPhones(listPho);
        when(repo.save(any())).thenReturn(respuestaModel());
        when(ap.getPasswordValue()).thenReturn("^[a-zA-Z0-9]{7}$");
        UserResDTO response = service.registrar(request);
        Assertions.assertEquals(1,response.getId());
    }


    /**
     * Este metodo devuelve la respuesta del model
     * @author. Luis Mascco
     * @version 06/04/2024
     */
    public User respuestaModel(){
        User res = new User();
        res.setIdUser(1);
        res.setName("Juan Rodriguez");
        res.setEmail("juan@rodriguez.org");
        res.setPassword("hunter2");
        Phone phone = new Phone();
        phone.setIdPhone(1);
        phone.setNumber("1234567");
        phone.setCityCode("1");
        phone.setContryCode("57");
        List<Phone> listPho = new ArrayList<>();
        listPho.add(phone);
        res.setPhones(listPho);
        return res;
    }
}

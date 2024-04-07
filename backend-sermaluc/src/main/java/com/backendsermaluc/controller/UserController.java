package com.backendsermaluc.controller;

import com.backendsermaluc.dto.UserReqDTO;
import com.backendsermaluc.dto.UserResDTO;
import com.backendsermaluc.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService service;

    @PostMapping("/registrar")
    public ResponseEntity<UserResDTO> registrar(@Validated @RequestBody UserReqDTO request){
        UserResDTO obj = service.registrar(request);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}

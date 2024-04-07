package com.backendsermaluc.service;

import com.backendsermaluc.dto.UserReqDTO;
import com.backendsermaluc.dto.UserResDTO;
import com.backendsermaluc.model.User;

public interface IUserService {
    UserResDTO registrar (UserReqDTO request);
}

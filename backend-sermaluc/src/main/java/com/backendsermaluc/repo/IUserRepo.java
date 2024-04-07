package com.backendsermaluc.repo;

import com.backendsermaluc.model.User;

public interface IUserRepo extends IGenericRepo<User, Integer>{
    User findByEmail(String email);
}

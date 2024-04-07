package com.backendsermaluc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepo<T, ID> extends JpaRepository<T, ID> {
    // T: es una entidad
    //id : puede ser un integer o un tipo de dato que se defina en los hijos
}

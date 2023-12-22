package org.academiadecodigo.javabank.persistence.daos;


import org.academiadecodigo.javabank.model.Model;
import org.academiadecodigo.javabank.persistence.jdbc.exceptions.TransactionException;

import java.sql.ResultSet;

public interface Dao <T extends Model>{
    ResultSet findById(Integer id);
    ResultSet findAll();
    T saveOrUpdate(T t) throws TransactionException;
    void delete(Integer id);
}

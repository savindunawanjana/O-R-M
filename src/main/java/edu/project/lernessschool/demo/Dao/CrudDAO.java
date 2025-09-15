package edu.project.lernessschool.demo.Dao;


import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO {

    List<T> getAll() throws Exception;
    Boolean delete(String id)throws Exception;
    Boolean update(T t)throws Exception;
    Boolean save(T t)throws Exception;
    String getNextId()throws Exception;
    String findNameById(String Id)  throws  Exception; //I changed this to t


}

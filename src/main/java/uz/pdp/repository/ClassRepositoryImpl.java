package uz.pdp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import uz.pdp.entity.Class;

import java.util.List;
@Repository
public class ClassRepositoryImpl  implements  ClassRepository{
@Autowired
    JdbcTemplate jdbcTemplate;

    public ClassRepositoryImpl(DriverManagerDataSource dataSource) {
    }

    @Override
    public int create(Class class_name) {
        try{
            return  jdbcTemplate.update("insert into class values (?)",class_name.getClass_name());
        }catch (Exception e){
            return 0;
        }

    }

    @Override
    public List<Class> read() {

        return jdbcTemplate.query("select * from class", BeanPropertyRowMapper.newInstance(Class.class));
    }

    @Override
    public Class findByClassName(Class class_name) {
      return  jdbcTemplate.queryForObject("select * from class where class_name = ?",BeanPropertyRowMapper.newInstance(Class.class));
    }

    @Override
    public int update(Class clas) {
        try {
            jdbcTemplate.update("update class set class_name = ?",clas.getClass_name());
        }catch (Exception e ){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Class class_name) {
       return  jdbcTemplate.update("delete from class where class_name = ?",BeanPropertyRowMapper.newInstance(Class.class));
    }
}

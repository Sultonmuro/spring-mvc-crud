package uz.pdp.repository;

import uz.pdp.entity.Class;

import java.util.List;

public interface ClassRepository {
  public int  create(Class class_name);
    public List<Class> read();

    public Class findByClassName(Class class_name);
    public int update (Class class_name);
    public int delete(Class class_name);
}

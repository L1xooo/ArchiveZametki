package Interface;

import java.util.List;

public interface IManager <T> {
    void create(String name);
    void delete(int index);
    void edit(int index, String newName);
    String list();
    List<T> getAll();
}

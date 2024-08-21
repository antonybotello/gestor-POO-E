import java.util.List;

public interface GenericoDAO<T> {
    void add(T obj );
    T getById(int id);
    List<T> getAll();
    void update(T obj);
    void delete(int id);
    
}

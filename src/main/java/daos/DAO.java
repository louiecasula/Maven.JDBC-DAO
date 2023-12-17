package daos;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    T findById(int id);
    List<T> findAll();
    T create(T t);
    T update(T t);
    void delete(int id);
}

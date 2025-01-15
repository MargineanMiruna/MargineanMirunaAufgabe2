package Repository;

import java.util.Map;

public interface IRepository<T> {
    public void create(T obj);
    public T read(int id);
    public void update(int id, T obj);
    public void delete(T obj);
    public Map<Integer, T> getAll();
}

package Repository;

import java.util.HashMap;
import java.util.Map;

public class Repository<T> implements IRepository<T> {
    Map<Integer, T> objects = new HashMap<Integer, T>();

    private int generateId() {
        Map.Entry<Integer, T> lastEntry = null;

        for (Map.Entry<Integer, T> entry : objects.entrySet()) {
            lastEntry = entry;
        }

        if (lastEntry == null)
            return 1;
        return lastEntry.getKey() + 1;
    }

    @Override
    public void create(T obj) {
        objects.put(generateId(), obj);
    }

    @Override
    public T read(int id) {
        return objects.get(id);
    }

    @Override
    public void update(int id, T obj) {
        objects.put(id, obj);
    }

    @Override
    public void delete(T obj) {
        objects.remove(obj);
    }

    @Override
    public Map<Integer, T> getAll() {
        return objects;
    }
}

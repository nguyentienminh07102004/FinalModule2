package Repository.IMPL;

import Repository.IGerneric;
import Repository.mapper.IRowMapper;

import java.util.List;

public class AbstractRepository<T> implements IGerneric<T> {

    @Override
    public List<T> query(String source, IRowMapper<T> rowMapper) {
        return (new FileAction<T>()).readFromFile(source, rowMapper);
    }

    @Override
    public void insert(String source, IRowMapper<T> rowMapper, T t) {
        List<T> data = query(source, rowMapper);
        data.add(t);
        new FileAction<T>().writeToFile(source, rowMapper, data);
    }

    @Override
    public void update(String source, IRowMapper<T> rowMapper, T t) {
        List<T> data = query(source, rowMapper);
        for(int i = 0; i < data.size(); i++) {
            if(rowMapper.equal(t, data.get(i))) {
                data.remove(i);
                data.add(i, t);
            }
        }
        new FileAction<T>().writeToFile(source, rowMapper, data);
    }

    @Override
    public void delete(String source, IRowMapper<T> rowMapper, T t) {
        List<T> data = query(source, rowMapper);
        for(int i = 0; i < data.size(); i++) {
            if(rowMapper.writeToFile(data.get(i)).equals(rowMapper.writeToFile(t))) {
                data.remove(i);
                break;
            }
        }
        new FileAction<T>().writeToFile(source, rowMapper, data);
    }
}

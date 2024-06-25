package Repository;

import java.util.List;

import Repository.mapper.IRowMapper;

public interface IGerneric<T> {
    List<T> query(String source, IRowMapper<T> rowMapper);
    void insert(String source, IRowMapper<T> rowMapper, T t);
    void update(String source, IRowMapper<T> rowMapper, T t);
    void delete(String source, IRowMapper<T> rowMapper, T t);
}
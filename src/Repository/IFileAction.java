package Repository;

import Repository.mapper.IRowMapper;

import java.util.List;

public interface IFileAction<T> {
    List<T> readFromFile(String source, IRowMapper<T> rowMapper);
    void writeToFile(String source, IRowMapper<T> rowMapper, List<T> data);
}

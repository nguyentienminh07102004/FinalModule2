package Repository.mapper;

public interface IRowMapper<T> {
    T Mapper(String data);
    String writeToFile(T t);
    Boolean equal(T t1, T t2);
}

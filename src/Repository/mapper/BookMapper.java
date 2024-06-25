package Repository.mapper;

import Repository.entity.BookEntity;

import java.util.StringTokenizer;

public class BookMapper implements IRowMapper<BookEntity> {
    @Override
    public BookEntity Mapper(String data) {
        StringTokenizer st = new StringTokenizer(data, ",");

        Long id = Long.parseLong(st.nextToken());
        String name = st.nextToken().trim();
        Integer publicationYear = Integer.parseInt(st.nextToken().trim());
        Long typeId = Long.parseLong(st.nextToken().trim());
        Integer stock = Integer.parseInt(st.nextToken().trim());
        Double price = Double.parseDouble(st.nextToken().trim());
        Integer reprint = Integer.parseInt(st.nextToken().trim());

        BookEntity bookEntity = new BookEntity();

        bookEntity.setId(id);
        bookEntity.setName(name);
        bookEntity.setPublicationYear(publicationYear);
        bookEntity.setPrice(price);
        bookEntity.setReprint(reprint);
        bookEntity.setStock(stock);
        bookEntity.setTypeId(typeId);

        return bookEntity;
    }

    @Override
    public String writeToFile(BookEntity bookEntity) {
        return bookEntity.getId() + ", " + bookEntity.getName() + ", " + bookEntity.getPublicationYear() + ", " + bookEntity.getTypeId()
                + ", " + bookEntity.getStock() + ", " + bookEntity.getPrice()  + ", " + bookEntity.getReprint();
    }

    @Override
    public Boolean equal(BookEntity t1, BookEntity t2) {
        return t1.getId() == t2.getId();
    }
}

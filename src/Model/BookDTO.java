package Model;

public class BookDTO {
    private Long id;
    private String name;
    private Integer publicationYear;
    private String authorName;
    private String type;
    private Integer stock;
    private Double price;
    private Integer reprint;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getReprint() {
        return reprint;
    }

    public void setReprint(Integer reprint) {
        this.reprint = reprint;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "name='" + name + '\'' +
                ", publicationYear=" + publicationYear +
                ", authorName='" + authorName + '\'' +
                ", type='" + type + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", reprint=" + reprint +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

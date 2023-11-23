package Entity;

import lombok.Data;

@Data
public class BookEntity {

    private String title;
    private int amountStr;
    private int datePublish;
    private String genre;
    private AuthorEntity author;
    private PublisherEntity publisher;

    @Override
    public String toString() {
        return "Книга - " +
                "название: '" + title +
                "' | жанр: " + genre +
                " | количество страниц: " + amountStr +
                " | дата публикации: " + datePublish +
                " | автор: " + author.toString() +
                " | " + publisher.toString() ;
    }
}
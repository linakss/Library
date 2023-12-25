package Entity;

import lombok.Data;

@Data

public class PublisherEntity {
    private String namePublish;
    private String cityPublish;

    @Override
    public String toString() {
        return "издательство:" + namePublish + " - " + cityPublish;
    }
    public PublisherEntity() {
    }
}

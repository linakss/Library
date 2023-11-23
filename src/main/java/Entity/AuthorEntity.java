package Entity;

import lombok.Data;
@Data
public class AuthorEntity {
    private String surnameAuthor;
    private String nameAuthor;
    private String lastnameAuthor;


    @Override
    public String toString() {
        return surnameAuthor + ' ' + nameAuthor + ' ' + lastnameAuthor + ' ';
    }
}
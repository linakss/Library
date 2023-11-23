import Entity.AuthorEntity;
import Entity.BookEntity;
import Entity.ListBooks;
import Entity.PublisherEntity;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Рада приветствовать тебя в своей библиотеке!");
        Gson gson = new Gson();
        Scanner scan = new Scanner(System.in);
        ListBooks library = new ListBooks();
                //reader чтение строки арпр!!
        try{FileReader reader = new FileReader("./fileForJson.txt");
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        BookEntity book = new BookEntity();
        PublisherEntity publish = new PublisherEntity();
        AuthorEntity author = new AuthorEntity();

        int answer = 0;
        System.out.println("В библиотеке ~Bibl~ есть такой функционал:");
        do {
            System.out.print("1 - добавить книгу\n2 - удалить книгу\n3 - показать весь ассортимент книг\n4 - найти книгу в архиве\n10 - выйти из ~Bibl~\nответ котика- ");

            try {answer = Integer.parseInt(scan.nextLine());
                switch (answer) {
                    case 1:
                        System.out.println("Ура! Больше книг - больше мозгов!");
                        System.out.print("Напиши название книги:\nответ котика- ");
                        book.setTitle(scan.nextLine());
                        System.out.print("Напиши жанр, к которому она относится:\nответ котика- ");
                        book.setGenre(scan.nextLine());
                        System.out.print("Напиши сколько в ней страниц:\nответ котика- ");
                        book.setAmountStr(Integer.parseInt(scan.nextLine()));
                        System.out.print("Напиши в каком году ее опубликовали:\nответ котика- ");
                        book.setDatePublish(Integer.parseInt(scan.nextLine()));

                        scan.nextLine();
                        System.out.print("Напиши фамилию автора:\nответ котика- ");
                        author.setSurnameAuthor(scan.nextLine());
                        System.out.print("Напиши имя автора:\nответ котика- ");
                        author.setNameAuthor(scan.nextLine());
                        System.out.print("Напиши отчество автора:\nответ котика- ");
                        author.setLastnameAuthor(scan.nextLine());
                        book.setAuthor(author);
                        System.out.print("Напиши название издательства:\nответ котика- ");
                        publish.setNamePublish(scan.nextLine());
                        System.out.print("Напиши в каком городе ее опубликовали:\nответ котика- ");
                        publish.setCityPublish(scan.nextLine());
                        book.setPublisher(publish);

                        if (library.getData() == null) {
                            List temp = new ArrayList<>();
                            temp.add(book);
                            library.setData(temp);
                            System.out.println("Еху! Спасибо, добрый человек, книга добавлена!");
                        } else {
                            library.getData().add(book);
                            System.out.println("Еху! Спасибо, добрый человек, книга добавлена!");
                        }
                        break;

                    case 2:
                        System.out.println("грущу\nнам очень грустно, что ты решил удалить книгу!");
                        System.out.print("Напиши название книги, которую хочешь удалить:\nответ котика- ");

                        break;
                    case 3:
                        System.out.println("Мы богаты этими произведениями:");
                        library.getData().forEach(System.out::println);
                        break;

                    case 4:
                        System.out.println("Интерпол отдыхает, начался поиск книг нашей базы!");
                        break;


                    case 10:
                        try{ File fileForJson = new File("./fileForJson.txt");
                            if (!fileForJson.exists())
                                fileForJson.createNewFile();
                            FileWriter fw;
                            fw = new FileWriter(fileForJson);
                            fw.write(gson.toJson(library));
                            fw.close();
                            System.out.println("Запись завершена. До скорых встреч, кот!");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода грущу");
            }
        } while (answer != 10);

    }
}

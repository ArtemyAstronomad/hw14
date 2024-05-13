
import java.util.Objects;

class Book {
    private final String title;
    private final Author author;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    public Book(String title, Author author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

class Author {
    private  static String toString;
    private final String firstName;
    private final String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return "Автор {имя='" + this.firstName + "', фамилия='" + this.lastName + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public class Library {
        public static void main(String[] args) {

            Author author1 = new Author("Михаил", "Черный");
            Author author2 = new Author("Саша", "Белый");

            Book book1 = new Book("Книга 1", author1, 2000);
            Book book2 = new Book("Книга 2", author2, 2010);

            System.out.println(book1.getTitle() + " : " + author1+ " (" + book1.getYear() + ")");
            System.out.println(book2.getTitle() + " : " + author2+ " (" + book1.getYear() + ")");
            book1.setYear(2005);
            System.out.println(book2.equals(book2));
            System.out.println(author2.equals(author1));
            System.out.println("Измененный год публикации первой книги " + book1.getYear());
        }
    }
}
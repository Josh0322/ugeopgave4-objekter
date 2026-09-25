import java.util.ArrayList;

    class Book {
        private String title;
        private String author;
        private boolean available;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.available = true;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isAvailable() {
            return available;
        }

        public void borrow() {
            if (available) {
                available = false;
                System.out.println("You've loaned: " + title);
            } else {
                System.out.println(title + " is not avaiable");
            }
        }

        public void returnBook() {
            available = true;
            System.out.println("You've returned: " + title);
        }

        public String toString() {
            String status = available ? "Avaiable" : "Loaned";
            return title + " by " + author + " - " + status;
        }
    }

    class Library {
        private String libraryName;
        private ArrayList<Book> books;

        public Library(String libraryName) {
            this.libraryName = libraryName;
            this.books = new ArrayList<>();
        }

        public void addBook(Book book) {
            if (book != null) {
                books.add(book);
                System.out.println("Added book to libary - " + book.getTitle());
            }
        }

        public ArrayList<Book> findAvailableBooks() {
            ArrayList<Book> available = new ArrayList<>();
            for (Book book : books) {
                if (book.isAvailable()) {
                    available.add(book);
                }
            }
            return available;
        }

        public Book findBookByTitle(String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
            return null;
        }

        public void printAllBooks() {
            System.out.println(" ");
            System.out.println("=== " + libraryName + " ===");
            System.out.println("All books:");
            for (Book book : books) {
                System.out.println("- " + book);
            }
        }
    }
    void main() {
        Library library = new Library("Copenhagens Libary");

        library.addBook(new Book("Game of Thrones", "George R.R. Martin"));
        library.addBook(new Book("A dance with dragons", "George R.R. Martin"));
        library.addBook(new Book("Harry Potter 1", "J.K. Rowling"));
        library.addBook(new Book("Harry Potter 2", "J.K. Rowling"));

        // Lån bøger:
        System.out.println(" ");
        System.out.println("--- Loaned books ---");
        Book book1 = library.findBookByTitle("Game of Thrones");
        if (book1 != null) {
            book1.borrow();
        }

        Book book2 = library.findBookByTitle("Harry Potter 2");
        if (book2 != null) {
            book2.borrow();
        }

        // Tilgænglige bøger:
        System.out.println(" ");
        System.out.println("--- Avaiable books ---");
        ArrayList<Book> available = library.findAvailableBooks();
        for (Book book : available) {
            System.out.println("- " + book);
        }
        System.out.println(" ");

        System.out.println("--- Returned books ---");
        if (book1 != null) {
            book1.returnBook();
        }

        library.printAllBooks();
}
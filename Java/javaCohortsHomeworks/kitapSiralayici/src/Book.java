import java.util.*;

class Book implements Comparable<Book> {
    private String title;
    private int pageCount;
    private String authorName;
    private Date publishDate;

    public Book(String title, int pageCount, String authorName, Date publishDate) {
        this.title = title;
        this.pageCount = pageCount;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    // Getters and setters (not shown for brevity)

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

}
package InflearnJava8.Stream;

public class OnlineClass {

    private Integer id;

    private String title;

    private boolean closed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public OnlineClass(Integer id, String titie, boolean closed) {
        this.id = id;
        this.title = titie;
        this.closed = closed;
    }
}

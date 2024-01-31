package Entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private LocalDateTime date;
    private String title;
    private String content;
    private Integer likes;
    //Composition
    private List<Comment> comment = new ArrayList<>();
    public Post(){

    }

    public Post(LocalDateTime date, String title, String content, Integer likes, List<Comment> comment) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.comment = comment;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getLikes() {
        return likes;
    }

}

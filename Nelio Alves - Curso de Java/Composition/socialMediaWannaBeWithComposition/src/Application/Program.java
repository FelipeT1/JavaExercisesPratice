package Application;

import Entities.Comment;
import Entities.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/* This program initializes objects and presents them in the console.
    It was made for practice with the composition subject.
 */
public class Program {
    public static void main(String[] args) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
        Comment comment1 = new Comment("A");
        Comment comment2 = new Comment("É");
        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        Post post = new Post(LocalDateTime.now(), "Estudando no quarto", "Aprendendo cada vez mais!", 0,comments);
        System.out.printf("%s%n", post.getTitle());
        System.out.printf("%d Likes - %s%n", post.getLikes(), post.getDate().format(dt));
        System.out.printf("%s%n", post.getContent());
        System.out.println("Comments:");
        for(Comment c : post.getComment()){
            System.out.printf("%s%n", c.getText());
        }
    }
}

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // global para local -> é necessário informar o time zone desejado.
        // geralmente é o próprio da máquina

        Instant inst01 = Instant.parse("2022-02-22T23:23:21Z");
        LocalDate lc01 = LocalDate.ofInstant(inst01,ZoneId.of("Egypt"));
        LocalDateTime lc02 = LocalDateTime.ofInstant(inst01,ZoneId.of("Portugal"));
        DateTimeFormatter dt01 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

        System.out.println("dt01 = " + dt01.format(inst01));
        System.out.println("lc01 = " + lc01);
        System.out.println("lc02 = " + lc02);
    }
}
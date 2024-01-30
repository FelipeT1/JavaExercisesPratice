import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        //Utilizando getters podemos conseguir dados específicos
        //Dos objetos Data-Hora
        //Lembrando que são de datas locais

        LocalDate lc01 = LocalDate.parse("2024-04-22");
        LocalDateTime lc02 = LocalDateTime.parse("2024-04-22T10:55:55");
        //Instant inst01 = Instant.now();
        //DateTimeFormatter fmt01 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").withZone(ZoneId.systemDefault());

        System.out.println("lc01 " + lc01.getDayOfMonth());
        System.out.println("lc02 " + lc02.getNano());
        //System.out.println("inst01 " + fmt01.format(inst01));
    }
}
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;
        LocalDate lc1 = LocalDate.parse("23/02/2333",fmt1);
        LocalDate lc2 = LocalDate.parse("2022-04-23");
        LocalDateTime lct1 = LocalDateTime.parse("2022-03-23T14:43:22");
        Instant inst1 = Instant.now();

        System.out.println("d1 = " + lc1);
        System.out.println("d2 = " + lc2.format(fmt1));
        System.out.println("d3 = " + lc2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("d4 = " + fmt1.format(lc2));
        System.out.println("d5 = " + fmt1.format(LocalDate.parse("2022-04-23")));
        System.out.println("d6 = "  + lct1);
        System.out.println("d7 = "  + lct1.format(fmt1));
        System.out.println("d8 = "  + lct1.format(fmt2));
        System.out.println("d9 = "  + inst1);
        // Dará erro pois Instant é um horário global e mudará a depender do fuso
        // Por isso fmt3 é criado, pois declara o fuso.
        //System.out.println("d10 = " + fmt2.format(inst1));
        System.out.println("d10 = " + fmt3.format(inst1));
        System.out.println("d11 = " + fmt3.format(inst1));
        System.out.println("d12 = "  + lct1.format(fmt4));
        // ISO DATE TIME É UMA DATA LOCAL (SEM FUSO) POR ISSO DARÁ EXCESSÃO
        //System.out.println("d13 = "  + fmt4.format(inst1));
        System.out.println("d13 = "  + fmt5.format(inst1));


    }
}
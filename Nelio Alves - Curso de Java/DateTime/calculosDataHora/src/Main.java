import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        // Objetos data hora são imnutáveis.
        // Se precisar de outro dia/horário instancie outro

        LocalDate ld02 = LocalDate.parse("2024-08-17");
        LocalDate ld01 = LocalDate.parse("2024-01-30");

        LocalDateTime ldt01 = LocalDateTime.now();
        LocalDateTime ldt02 = LocalDateTime.parse("2024-08-17T17:00:00");

        Duration duration03 = Duration.between(ldt01,ldt02);
        Duration duration01 = Duration.between(ld02.atTime(0,0),ld01.atTime(0,0));
        Duration duration02 = Duration.between(ld01.atStartOfDay(),ld02.atStartOfDay());

        LocalDate menosXdias = ld02.minusDays(70);

        Instant inst01 = Instant.now();


        System.out.println("Instant = " + inst01.minus(7, ChronoUnit.DAYS));
        System.out.println("Subtracao = " + menosXdias);


        System.out.println("Duração entre dois objeto LocalDate " );
        System.out.println("ld01 - ld02  " + duration03.toDays());

    }
}
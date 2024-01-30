import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        // Data-Hora local (sem o fuso horário)
        LocalDateTime dt01 = LocalDateTime.now();
        System.out.println("dt01 " + dt01);

        //Data-Hora global (COM fuso horário)
        Instant inst1 = Instant.now();
        System.out.println("inst01 " + inst1);

        // Le um texto no padrão ISO 8601
        // Hora Data local (sem fuso horário)
        LocalDateTime dt02 = LocalDateTime.parse("2024-01-29T15:37:40");
        System.out.println("dt02 " + dt02);

        // Agora com o instant com o padrão UTC, GMT, Zulu time
        // Horário de Londres
        Instant inst02 = Instant.parse("2024-01-29T15:37:40Z");
        System.out.println("inst02 " + inst02);

        // Se for informado um GMT como -03:00 teremos o horário
        // Em londres adiantado. Colocamos um horário qualquer
        // E pedimos ao Java para se virar e devolver o horário em Londres
        // Depois desse GMT, basicamente.
        Instant inst03 = Instant.parse("2024-01-29T15:37:40-03:00");
        System.out.println("inst03 " + inst03);

        // Agora lendo outro formato de texto, sem ser o padrão ISO 8601
        // Vai dizer o que cada coisa é. Converte String para objeto DataHora
        // É preciso passar o objeto formatado para o parse ser lido corretamente
        // É necessário ver a documentação dessa classe para saber os formatos suportados
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dt05 = LocalDateTime.parse("29/01/2024 13:22", fmt1);
        System.out.println("dt05 " + dt05);

        // lembrando que é necessário um objeto, não necessariamente uma variável que o referencia
        // como podemos ver abaixo.
        LocalDateTime dt06 = LocalDateTime.parse("29/01/2024 13:22",  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println("dt06 " + dt06);

        // Agora vamos instanciar DIA MES ANO
        LocalDateTime dt07 = LocalDateTime.of(2024,1,2,12,30);
        System.out.println("dt07 "+ dt07);
    }
}
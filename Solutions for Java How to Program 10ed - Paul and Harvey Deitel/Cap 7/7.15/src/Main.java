
//7.15
public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            // Converte o primeiro argumento para um inteiro
            int intValue = Integer.parseInt(args[0]);

            // Agora, você pode usar o valor inteiro conforme necessário
            System.out.println("Valor inteiro: " + intValue);
        } else {
            System.out.println("Nenhum argumento fornecido.");
        }
    }
}

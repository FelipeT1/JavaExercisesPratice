import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Funcionarios> listaDeFuncionarios = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        int quantidade;
        System.out.print("How many people will be registered ");
        quantidade = teclado.nextInt();
        for(int i = 1; i <= quantidade; i++){
            System.out.printf("Employee #%d%n",i);
            System.out.print("Id: ");
            Integer id = teclado.nextInt();
            while(verificaId(listaDeFuncionarios,id)){
                System.out.print("O id já foi escolhido, tente outro: ");
                id = teclado.nextInt();
            }
            teclado.nextLine();
            System.out.print("Nome: ");
            String nome = teclado.nextLine();
            System.out.print("Salario: ");
            Double salario = teclado.nextDouble();
            Funcionarios func = new Funcionarios(nome, id, salario);
            listaDeFuncionarios.add(func);
            System.out.println();
        }
        System.out.print("Digite o ID para o aumento no salário ");
        Integer idToPromotion = teclado.nextInt();
        if(verificaId(listaDeFuncionarios, idToPromotion)){
            Funcionarios faaaa = listaDeFuncionarios.stream().filter(x->x.getId().equals(idToPromotion)).findFirst().orElse(null);
            System.out.print("DIGITE A PORCENTAGEM  DE AUMENTO ");
            double porcentagem = teclado.nextDouble();
            faaaa.aumentaSalarioPorcentagem(porcentagem);
        }
        else{
            System.out.println("Id não existe");
        }
        for(Funcionarios f : listaDeFuncionarios){
            System.out.println(f);
        }
    }
    public static boolean verificaId(List<Funcionarios> funcionarios, int id){
        Funcionarios funcionario = funcionarios.stream().filter(x->x.getId().equals(id)).findAny().orElse(null);
        return funcionario != null;
    }
}
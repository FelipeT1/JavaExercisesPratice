import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Employee> listaDeFuncionarios = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        int quantidade;
        System.out.print("How many people will be registered ");
        quantidade = teclado.nextInt();
        for(int i = 1; i <= quantidade; i++){
            System.out.printf("Employee #%d%n",i);
            System.out.print("Id: ");
            Integer id = teclado.nextInt();
            while(idHasBeenChosen(listaDeFuncionarios,id)){
                System.out.print("ID HAS BEEN CHOSEN, CHOOSE ANOTHER ");
                id = teclado.nextInt();
            }
            teclado.nextLine();
            System.out.print("Nome: ");
            String nome = teclado.nextLine();
            System.out.print("Salario: ");
            Double salario = teclado.nextDouble();
            Employee employee = new Employee(nome, id, salario);
            listaDeFuncionarios.add(employee);
            System.out.println();
        }
        System.out.print("Digite o ID para o aumento no salário ");
        Integer idToPromotion = teclado.nextInt();
        if(idPositionInList(listaDeFuncionarios, idToPromotion)!=-1){
            System.out.print("DIGITE A PORCENTAGEM ");
            double porcentagem = teclado.nextDouble();
            listaDeFuncionarios
                    .get(idPositionInList(listaDeFuncionarios, idToPromotion))
                    .aumentaSalarioPorcentagem(porcentagem);
        }
        else{
            System.out.println("ID NÃO EXISTE");
        }
        System.out.println("LIST OF EMPLOYESS");
        for(Employee e : listaDeFuncionarios){
            System.out.println(e);
        }
    }
    public static Integer idPositionInList(List<Employee> employees, Integer id){
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    public static boolean idHasBeenChosen(List<Employee> employees, Integer id){
        Employee emp = employees.stream()
                .filter(x->x.getId().equals(id))
                .findAny()
                .orElse(null);

        return emp != null;
    }
}
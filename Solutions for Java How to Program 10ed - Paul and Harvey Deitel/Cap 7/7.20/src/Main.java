import java.util.Scanner;
//7.20
public class Main {
    private static final int FUNCIONARIOS = 4;
    private static final int PRODUTOS = 5;
    private static int[][] sales = new int[FUNCIONARIOS][PRODUTOS];

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int escolha = 0;
        System.out.println(sales[0].length);
        do {
            atribuiVendaMes(vendaNoMes());
            System.out.print("0 - SAI\n1-CONTINUA\t");
            escolha = teclado.nextInt();
        }while(escolha!=0);

        imprimeTabelaDeVenda(sales);

    }
    public static void imprimeTabelaDeVenda(int[][] vendas){
        System.out.print("PRODUTOS\t");
        for(int i = 0; i<PRODUTOS; i++){
            System.out.printf("%d\t", i+1);
        }
        System.out.println();
        for(int i = 0; i<FUNCIONARIOS;i++){
            int somaFuncionario = 0;
            System.out.printf("FUNCI   %d\t",i+1);
            for(int c = 0; c<PRODUTOS; c++){
                somaFuncionario += sales[i][c];
                System.out.printf("%d\t",sales[i][c]);
            }
            System.out.printf(" = %d", somaFuncionario);
            System.out.println();
        }
        System.out.print("PRO SOMA\t");
        for(int i = 0; i<PRODUTOS; i++){
            int somaProdutos = 0;
            for(int linha = 0; linha<FUNCIONARIOS;linha++){
                somaProdutos+=sales[linha][i];
            }
            System.out.printf("%d\t", somaProdutos);
        }
        System.out.println();
    }
    public static void atribuiVendaMes(int[] vendas){
        int idFuncionario, idProduto, quantidade;
        idFuncionario = vendas[0];
        idProduto = vendas[1];
        quantidade = vendas[2];
        switch (idProduto){
            case 0:
                sales[idFuncionario][idProduto] += quantidade*10;
                break;
            case 1:
                sales[idFuncionario][idProduto] += quantidade*20;
                break;
            case 2:
                sales[idFuncionario][idProduto] += quantidade*30;
                break;
            case 3:
                sales[idFuncionario][idProduto] += quantidade*40;
                break;
            case 4:
                sales[idFuncionario][idProduto] += quantidade*50;
                break;
        }
    }
    public static int[] vendaNoMes(){
        Scanner teclado = new Scanner(System.in);
        int[] venda = new int[3];
        int escolha;
        System.out.print("SISTEMA INICIANDO\n");
        System.out.print("DIGITE:\nID DO FUNCIONARIO(1-4)\t");
        escolha = teclado.nextInt();
        venda[0] = escolha-1;
        System.out.print("DIGITE:\nID DO PRODUTO(1-5)\t");
        escolha = teclado.nextInt();
        venda[1] = escolha-1;
        System.out.printf("DIGITE:\nQUANTIDADE\t");
        escolha = teclado.nextInt();
        venda[2] = escolha;
        return venda;
    }
}


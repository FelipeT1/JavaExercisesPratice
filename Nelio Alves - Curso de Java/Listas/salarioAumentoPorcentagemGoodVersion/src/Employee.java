public class Employee {
    private String nome;
    private Integer id;
    private Double salario;
    public Employee(){
    }
    public Employee(String name, Integer id, Double salario){
        this.nome = name;
        this.id = id;
        this.salario = salario;
    }
    public void aumentaSalarioPorcentagem(Double aumentoEmPorcentagem){
        Double aumento = getSalario() * (1+(aumentoEmPorcentagem/100));
        System.out.println();
        System.out.printf("Seu salário aumentou %.2f! E agora é: %.2f%n", aumento-getSalario(), aumento);
        System.out.println();
        setSalario(aumento);
    }
    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return this.id
                + ", "
                + this.nome
                + ", "
                + String.format("%.2f", this.salario);
    }

    public Integer getId() {
        return id;
    }
}

public class Funcionarios {
    private String nome;
    private Integer id;
    private Double salario;
    public Funcionarios(){
    }
    public Funcionarios(String name, Integer id, Double salario){
        this.nome = name;
        this.id = id;
        this.salario = salario;
    }
    public void aumentaSalarioPorcentagem(Double aumentoEmPorcentagem){
        Double aumento = getSalario() * (1+(aumentoEmPorcentagem/100));
        System.out.printf("Seu salário aumentou %.2f! E agora é: %.2f%n", aumento-getSalario(), aumento);
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
        return "Funcionarios{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", salario=" + salario +
                '}';
    }

    public Integer getId() {
        return id;
    }
}

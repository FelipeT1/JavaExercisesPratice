public class Matriz {
    private int[][] matriz;
    public Matriz(int tamanho){
        matriz = new int[tamanho][tamanho];
    }

    public int[][] getMatriz() {
        return matriz;
    }
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
}

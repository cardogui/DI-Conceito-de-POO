class Veiculo {
    String modelo;
    double valorDiario;

    public Veiculo(String modelo, double valorDiario) {
        this.modelo = modelo;
        this.valorDiario = valorDiario;
    }

    public double calcularAluguel(int dias) {
        return dias * valorDiario;
    }
}

class Locadora {
    public static void main(String[] args) {
        // Criando um veículo
        Veiculo carro = new Veiculo("Toyota Corolla", 150.0);

        // Número de dias de aluguel
        int diasAluguel = 5;

        // Calculando o valor total do aluguel
        double valorTotal = carro.calcularAluguel(diasAluguel);

        // Exibindo o resultado
        System.out.println("Modelo do veículo: " + carro.modelo);
        System.out.println("Valor diário de aluguel: R$ " + carro.valorDiario);
        System.out.println("Dias de aluguel: " + diasAluguel);
        System.out.println("Valor total do aluguel: R$ " + valorTotal);
    }
}
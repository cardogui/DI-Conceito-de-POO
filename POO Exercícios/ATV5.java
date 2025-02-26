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
     
        Veiculo carro = new Veiculo("Toyota Corolla", 150.0);
        
        int diasAluguel = 5;
       
        double valorTotal = carro.calcularAluguel(diasAluguel);
     
        System.out.println("Modelo do veículo: " + carro.modelo);
        System.out.println("Valor diário de aluguel: R$ " + carro.valorDiario);
        System.out.println("Dias de aluguel: " + diasAluguel);
        System.out.println("Valor total do aluguel: R$ " + valorTotal);
    }
}

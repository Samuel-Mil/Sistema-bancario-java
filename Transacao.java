import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private LocalDateTime data;
    private String tipo;
    private double valor;

    public Transacao(String tipo, double valor) {
        this.data = LocalDateTime.now();
        this.tipo = tipo;
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "Data: " + data.format(formatter) + ", Tipo: " + tipo + ", Valor: R$ " + valor;
    }
}

package Models;

public class Camion extends Vehiculo {
    private String toneladas;
    private String numEjes;

    public Camion(String marca, String modelo, String propietario, String fechaIngreso, String toneladas, String numEjes) {
        super(marca, modelo, propietario, fechaIngreso);
        this.toneladas = toneladas;
        this.numEjes = numEjes;
    }

    public Camion() {}

    // Getters y setters
    public String getToneladas() { return toneladas; }
    public void setToneladas(String toneladas) { this.toneladas = toneladas; }
    public String getNumEjes() { return numEjes; }
    public void setNumEjes(String numEjes) { this.numEjes = numEjes; }

    @Override
    public String toString() {
        return super.toString() + ", Toneladas: " + toneladas + ", Número de ejes: " + numEjes;
    }
}

package Models;

public class Taxi extends Vehiculo {
    private String tarifaKm;

    public Taxi(String marca, String modelo, String propietario, String fechaIngreso, String tarifaKm) {
        super(marca, modelo, propietario, fechaIngreso);
        this.tarifaKm = tarifaKm;
    }

    public Taxi() {}

    // Getter y setter
    public String getTarifaKm() { return tarifaKm; }
    public void setTarifaKm(String tarifaKm) { this.tarifaKm = tarifaKm; }

    @Override
    public String toString() {
        return super.toString() + ", Tarifa por km: " + tarifaKm;
    }
}

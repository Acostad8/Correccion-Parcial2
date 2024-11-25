
package Models;

public class Vehiculo {
    private String marca;
    private String modelo;
    private String propietario;
    private String fechaIngreso;

    public Vehiculo(String marca, String modelo, String propietario, String fechaIngreso) {
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
        this.fechaIngreso = fechaIngreso;
    }

    public Vehiculo() {}

    // Getters y setters
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getPropietario() { return propietario; }
    public void setPropietario(String propietario) { this.propietario = propietario; }
    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Propietario: " + propietario + ", Fecha de ingreso: " + fechaIngreso;
    }
}

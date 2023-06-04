public class Empleado {
    private String nombre;
    private String cedula;
    private float sueldo;
    private float aporteSeguro;
    private float ImpuestoRenta;
    private float sueldoNeto;
    public Empleado(String nombre, String cedula, float sueldo){
        this.nombre = nombre;
        this.cedula = cedula;
        this.sueldo = sueldo;
    }
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setSueldo(float sueldo) {this.sueldo = sueldo;}
    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public float getSueldo() {
        return sueldo;
    }
    public float getAporteSeguro() {
        return aporteSeguro;
    }
    public float getImpuestoRenta() {
        return ImpuestoRenta;
    }
    public float getSueldoNeto() {return sueldoNeto;}
    public void calcularSueldoNeto(){
        sueldoNeto = sueldo - aporteSeguro - ImpuestoRenta;
    }
    public void calcularAporte(){
        aporteSeguro = sueldo * 0.0935f;
    }
    public void calcularImpuestoRenta(){
        if((sueldo*12) <= 5000){
            ImpuestoRenta = 0;
        }else if((sueldo*12) > 5000 && (sueldo*12) <= 10000) {
            ImpuestoRenta = ((sueldo*12)  - 5000f) * 0.1f;
        }else if((sueldo*12) > 10000 && (sueldo*12) <= 18000) {
            ImpuestoRenta = ((sueldo*12)  - 10000f) * 0.2f;
        }else{
            ImpuestoRenta = ((sueldo*12)  - 18000f) * 0.3f;
        }
    }
}

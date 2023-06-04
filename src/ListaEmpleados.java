import javax.swing.*;
import java.util.ArrayList;

public class ListaEmpleados {
    ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    public void registrarEmpleado(Empleado empleado){
        if(verificarCedula(empleado.getCedula())){
            empleados.add(empleado);
            JOptionPane.showMessageDialog(null, "Empleado registrado");
        }
    }

    public boolean verificarCedula(String cedula){
        if(empleados.isEmpty()){
            return true;
        }else{
            for (Empleado empleado : empleados){
                if(empleado.getCedula().equalsIgnoreCase(cedula)){
                    JOptionPane.showMessageDialog(null, "Ya existe un empleado con esa cedula");
                    return false;
                }
            }
        }
        return true;
    }
    public Empleado buscarEmpleado(String cedula){
        if(empleados.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay empleados registrados");
        }else{
            for (Empleado empleado : empleados){
                if(empleado.getCedula().equalsIgnoreCase(cedula)){
                    return empleado;
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontro el empleado");
                }
            }
        }
        return null;
    }
    public void modificarEmpleado(String cedula,String nombre, float sueldo){
        if(empleados.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay empleados registrados");
        }else{
           if(buscarEmpleado(cedula) == null){
               JOptionPane.showMessageDialog(null, "No se encontro el empleado");
               return;
           }
               buscarEmpleado(cedula).setNombre(nombre);
               buscarEmpleado(cedula).setSueldo(sueldo);
               JOptionPane.showMessageDialog(null, "Empleado modificado");
        }
    }
    //metodo para eliminar un empleado
    public void eliminarEmpleado(String cedula){
        if(empleados.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay empleados registrados");
        }else{
            if(buscarEmpleado(cedula) == null){
                JOptionPane.showMessageDialog(null, "No se encontro el empleado");
                return;
            }
            empleados.remove(buscarEmpleado(cedula));
            JOptionPane.showMessageDialog(null, "Empleado eliminado");
        }
    }
    public void imprimirLista(JTextArea textArea){
        if(empleados.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay empleados registrados");
        }else{
            StringBuilder stringBuilder = new StringBuilder();
            for (Empleado empleado : empleados){
                empleado.calcularImpuestoRenta();
                empleado.calcularAporte();
                empleado.calcularSueldoNeto();
               stringBuilder.append("Nombre: ").append(empleado.getNombre()).append("\n")
                       .append("Cedula: ").append(empleado.getCedula()).append("\n")
                       .append("Sueldo: ").append(empleado.getSueldo()).append("\n")
                       .append("Aporte al seguro: ").append(empleado.getAporteSeguro()).append("\n")
                       .append("Impuesto a la renta: ").append(empleado.getImpuestoRenta()).append("\n")
                       .append("Sueldo liquido: ").append(empleado.getSueldoNeto()).append("\n")
                       .append("------------------------------------------------------------------------").append("\n");
            }
            textArea.setText(stringBuilder.toString());
        }
    }
}

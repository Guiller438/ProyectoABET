import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventana extends JFrame{
    private JTabbedPane tabbedPane1;
    private JTextField txtcedula;
    private JTextField txtnombre;
    private JTextField txtsueldo;
    private JButton agregarEmpleadoButton;
    private JPanel mainPanel;
    private JTextField txtcedulabuscar;
    private JButton buscarButton;
    private JTextField txtnombrenuevo;
    private JTextField txtsueldonueva;
    private JButton modificarButton;
    private JTextArea EmpleadosRegistrados;
    private JButton eliminarButton;

    public Ventana() {
        ListaEmpleados listaEmpleados = new ListaEmpleados();
        agregarEmpleadoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           if(txtcedula.getText().isEmpty() || txtnombre.getText().isEmpty() || txtsueldo.getText().isEmpty()) {
               JOptionPane.showMessageDialog(null, "No puede dejar campos vacios");
           }else{
                Empleado empleado = new Empleado(txtnombre.getText(), txtcedula.getText(), Float.parseFloat(txtsueldo.getText()));
                listaEmpleados.registrarEmpleado(empleado);
                listaEmpleados.imprimirLista(EmpleadosRegistrados);
           }
            txtcedula.setText("");
            txtnombre.setText("");
            txtsueldo.setText("");
        }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtcedulabuscar.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese la cedula del empleado a buscar");
                }else{
                    Empleado empleado = listaEmpleados.buscarEmpleado(txtcedulabuscar.getText());
                    if(empleado != null){
                        txtnombrenuevo.setText(empleado.getNombre());
                        txtsueldonueva.setText(String.valueOf(empleado.getSueldo()));
                    }
                }

            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaEmpleados.modificarEmpleado(txtcedulabuscar.getText(),txtnombrenuevo.getText(), Float.parseFloat(txtsueldonueva.getText()));
                listaEmpleados.imprimirLista(EmpleadosRegistrados);
                txtnombrenuevo.setText("");
                txtsueldonueva.setText("");
            }
        });
        txtcedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(txtcedula.getText().length() == 10){
                    JOptionPane.showMessageDialog(null, "Solo se permiten 10 digitos");
                    e.consume();
                }
                if(!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE){
                    e.consume();
                }
            }
        });
        txtnombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(txtcedula.getText().length() == 30){
                    JOptionPane.showMessageDialog(null, "Solo se permiten 30 caracteres");
                    e.consume();
                }
                if(!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_SPACE){
                    e.consume();
                }
            }
        });
        txtsueldo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(txtcedula.getText().length() == 30){
                    JOptionPane.showMessageDialog(null, "Solo se permiten 10 digitos");
                    e.consume();
                }
                if(!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE){
                    e.consume();
                }
            }
        });
        txtcedulabuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(txtcedulabuscar.getText().length() == 10){
                    JOptionPane.showMessageDialog(null, "Solo se permiten 10 digitos");
                    e.consume();
                }
                if(!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE){
                    e.consume();
                }
            }
        });
        txtnombrenuevo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(txtcedula.getText().length() == 30){
                    JOptionPane.showMessageDialog(null, "Solo se permiten 30 caracteres");
                    e.consume();
                }
                if(!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_SPACE){
                    e.consume();
                }
            }
        });
        txtsueldonueva.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(txtcedula.getText().length() == 30){
                    JOptionPane.showMessageDialog(null, "Solo se permiten 10 digitos");
                    e.consume();
                }
                if(!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE){
                    e.consume();
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaEmpleados.eliminarEmpleado(txtcedulabuscar.getText());
                listaEmpleados.imprimirLista(EmpleadosRegistrados);
                txtnombrenuevo.setText("");
                txtsueldonueva.setText("");
            }
        });
    }
    public JPanel getJpanel(){
        return mainPanel;
    }
}

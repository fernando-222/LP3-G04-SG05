package actividad1;
import javax.swing.*;

public class AppProducto {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Binding Manual - Producto");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Modelo
        Producto prod = new Producto("Sin nombre", 0.0, 0, "Sin categoría");

        JLabel l1 = new JLabel("Nombre:");
        JLabel l2 = new JLabel("Precio:");
        JLabel l3 = new JLabel("Stock:");
        JLabel l4 = new JLabel("Categoría:");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();

        JButton btn = new JButton("Actualizar Producto");
        JLabel salida = new JLabel("<html>Producto:<br>---</html>");

        l1.setBounds(20,20,100,25);
        t1.setBounds(120,20,150,25);
        l2.setBounds(20,60,100,25);
        t2.setBounds(120,60,150,25);
        l3.setBounds(20,100,100,25);
        t3.setBounds(120,100,150,25);
        l4.setBounds(20,140,100,25);
        t4.setBounds(120,140,150,25);

        btn.setBounds(20,180,250,30);
        salida.setBounds(20,220,300,80);

        btn.addActionListener(e -> {
            prod.setNombre(t1.getText());
            prod.setPrecio(Double.parseDouble(t2.getText()));
            prod.setCantidadStock(Integer.parseInt(t3.getText()));
            prod.setCategoria(t4.getText());

            salida.setText("<html>Producto:<br>"
                    + "Nombre: " + prod.getNombre() + "<br>"
                    + "Precio: " + prod.getPrecio() + "<br>"
                    + "Stock: " + prod.getCantidadStock() + "<br>"
                    + "Categoría: " + prod.getCategoria() + "</html>");
        });

        frame.add(l1); frame.add(t1);
        frame.add(l2); frame.add(t2);
        frame.add(l3); frame.add(t3);
        frame.add(l4); frame.add(t4);
        frame.add(btn); frame.add(salida);

        frame.setVisible(true);
    }
}


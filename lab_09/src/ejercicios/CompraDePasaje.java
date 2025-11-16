package ejercicios;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CompraDePasaje extends JFrame {

    private final JTextField tfNombre = new JTextField(20);
    private final JTextField tfDocumento = new JTextField(12);
    private final JTextField tfFecha = new JTextField(10);

    private final JCheckBox cbAudifonos = new JCheckBox("Audífonos");
    private final JCheckBox cbManta = new JCheckBox("Manta");
    private final JCheckBox cbRevistas = new JCheckBox("Revistas");

    private final JRadioButton rbPrimerPiso = new JRadioButton("1er piso");
    private final JRadioButton rbSegundoPiso = new JRadioButton("2do piso");

    private final JComboBox<String> cbOrigen = new JComboBox<>(new String[]{"Arequipa", "Lima", "Cusco", "Trujillo"});
    private final JComboBox<String> cbDestino = new JComboBox<>(new String[]{"Lima", "Arequipa", "Cusco", "Trujillo"});

    private final JList<String> listCalidad = new JList<>(new String[]{"Económico", "Standard", "VIP"});

    private final JButton btnResumen = new JButton("Generar Resumen");
    private final JButton btnReset = new JButton("Resetear");

    public CompraDePasaje() {
        super("Compra de Pasaje ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel datosPanel = new JPanel(new GridBagLayout());
        datosPanel.setBorder(new TitledBorder("Datos del pasajero"));
        GridBagConstraints d = new GridBagConstraints();
        d.insets = new Insets(4, 4, 4, 4);
        d.anchor = GridBagConstraints.WEST;

        d.gridx = 0; d.gridy = 0; datosPanel.add(new JLabel("Nombre:"), d);
        d.gridx = 1; datosPanel.add(tfNombre, d);

        d.gridx = 0; d.gridy = 1; datosPanel.add(new JLabel("Documento:"), d);
        d.gridx = 1; datosPanel.add(tfDocumento, d);

        d.gridx = 0; d.gridy = 2; datosPanel.add(new JLabel("Fecha viaje (dd/mm/aaaa):"), d);
        d.gridx = 1; datosPanel.add(tfFecha, d);

        JPanel serviciosPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        serviciosPanel.setBorder(new TitledBorder("Servicios opcionales"));
        serviciosPanel.add(cbAudifonos);
        serviciosPanel.add(cbManta);
        serviciosPanel.add(cbRevistas);

        JPanel pisoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pisoPanel.setBorder(new TitledBorder("Piso"));
        ButtonGroup groupPiso = new ButtonGroup();
        groupPiso.add(rbPrimerPiso);
        groupPiso.add(rbSegundoPiso);
        rbPrimerPiso.setSelected(true);
        pisoPanel.add(rbPrimerPiso);
        pisoPanel.add(rbSegundoPiso);

        JPanel orPanel = new JPanel(new GridLayout(2, 2, 6, 6));
        orPanel.setBorder(new TitledBorder("Trayecto"));
        orPanel.add(new JLabel("Origen:"));
        orPanel.add(cbOrigen);
        orPanel.add(new JLabel("Destino:"));
        orPanel.add(cbDestino);

        JPanel calidadPanel = new JPanel(new BorderLayout());
        calidadPanel.setBorder(new TitledBorder("Calidad de servicio"));
        listCalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listCalidad.setVisibleRowCount(3);
        calidadPanel.add(new JScrollPane(listCalidad), BorderLayout.CENTER);

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.weightx = 1;
        mainPanel.add(datosPanel, gbc);

        gbc.gridy = 1; gbc.gridwidth = 2;
        mainPanel.add(serviciosPanel, gbc);

        gbc.gridy = 2; gbc.gridwidth = 1; gbc.weightx = 0.5;
        mainPanel.add(pisoPanel, gbc);

        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0.5;
        mainPanel.add(calidadPanel, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        mainPanel.add(orPanel, gbc);

        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botonesPanel.add(btnReset);
        botonesPanel.add(btnResumen);

        add(mainPanel, BorderLayout.CENTER);
        add(botonesPanel, BorderLayout.SOUTH);

        btnResumen.addActionListener(e -> mostrarResumen());
        btnReset.addActionListener(e -> resetearFormulario());

        pack();
        setSize(560, 420);
        setLocationRelativeTo(null);
    }

    private void mostrarResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("----- Resumen de Pasajero -----\n\n");
        sb.append("Nombre: ").append(tfNombre.getText().trim()).append("\n");
        sb.append("Documento: ").append(tfDocumento.getText().trim()).append("\n");
        sb.append("Fecha de viaje: ").append(tfFecha.getText().trim()).append("\n\n");

        sb.append("Origen: ").append(cbOrigen.getSelectedItem()).append("\n");
        sb.append("Destino: ").append(cbDestino.getSelectedItem()).append("\n\n");

        sb.append("Calidad: ");
        String calidad = listCalidad.getSelectedValue();
        sb.append(calidad == null ? "No seleccionado" : calidad).append("\n\n");

        sb.append("Piso: ");
        if (rbPrimerPiso.isSelected()) sb.append("1er piso\n");
        else if (rbSegundoPiso.isSelected()) sb.append("2do piso\n");

        sb.append("\nServicios opcionales: ");
        boolean any = false;
        if (cbAudifonos.isSelected()) { sb.append("Audífonos"); any = true; }
        if (cbManta.isSelected()) { if (any) sb.append(", "); sb.append("Manta"); any = true; }
        if (cbRevistas.isSelected()) { if (any) sb.append(", "); sb.append("Revistas"); any = true; }
        if (!any) sb.append("Ninguno");

        JTextArea ta = new JTextArea(sb.toString());
        ta.setEditable(false);
        ta.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(ta);
        scroll.setPreferredSize(new Dimension(420, 260));
        JOptionPane.showMessageDialog(this, scroll, "Resumen de compra", JOptionPane.INFORMATION_MESSAGE);
    }

    private void resetearFormulario() {
        tfNombre.setText("");
        tfDocumento.setText("");
        tfFecha.setText("");
        cbAudifonos.setSelected(false);
        cbManta.setSelected(false);
        cbRevistas.setSelected(false);
        rbPrimerPiso.setSelected(true);
        cbOrigen.setSelectedIndex(0);
        cbDestino.setSelectedIndex(0);
        listCalidad.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CompraDePasaje ventana = new CompraDePasaje();
            ventana.setVisible(true);
        });
    }
}

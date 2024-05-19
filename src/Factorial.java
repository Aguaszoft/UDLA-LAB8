import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Factorial extends Component {
    private JPanel panelGeneral;
    private JTable tbResultado;
    private JButton btnCalcular;
    private JLabel lblNumero;
    private JTextField txtNumero;

    public Factorial() {
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = txtNumero.getText();
                try {
                    int number = Integer.parseInt(inputText);
                    long factorial = calcularFactorial(number);

                    // Displaying the result in a JTable
                    DefaultTableModel model = new DefaultTableModel(new Object[]{"Número", "Factorial"}, 0);
                    model.addRow(new Object[]{number, factorial});
                    tbResultado.setModel(model);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Factorial.this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private long calcularFactorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * calcularFactorial(n - 1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Factorial");
        frame.setContentPane(new Factorial().panelGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

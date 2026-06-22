import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WrappedWindow fenetre = new WrappedWindow();
            fenetre.setVisible(true);
        });
    }
}
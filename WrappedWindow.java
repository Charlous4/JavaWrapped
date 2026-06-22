import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class WrappedWindow extends JFrame {

    private JTextField txtPseudo;
    private JTextArea txtResultat;
    private JButton btnLancer;

    public WrappedWindow() {
        setTitle("Java Spotify Wrapped 2026");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        JPanel panelHaut = new JPanel();
        panelHaut.setBackground(new Color(18, 18, 18)); 
        panelHaut.setLayout(new FlowLayout());

        JLabel lblPseudo = new JLabel("Pseudo Last.fm : ");
        lblPseudo.setForeground(Color.WHITE);
        
        txtPseudo = new JTextField("Charlous4", 15);
        
        btnLancer = new JButton("Générer mon Wrapped");
        btnLancer.setBackground(new Color(30, 215, 96)); 
        btnLancer.setForeground(Color.BLACK);
        btnLancer.setFont(new Font("Arial", Font.BOLD, 12));

        panelHaut.add(lblPseudo);
        panelHaut.add(txtPseudo);
        panelHaut.add(btnLancer);
        add(panelHaut, BorderLayout.NORTH);

        txtResultat = new JTextArea();
        txtResultat.setEditable(false);
        txtResultat.setBackground(new Color(24, 24, 24)); 
        txtResultat.setForeground(Color.WHITE);
        txtResultat.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtResultat.setMargin(new Insets(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(txtResultat);
        add(scrollPane, BorderLayout.CENTER);

        btnLancer.addActionListener(e -> {
            txtResultat.setText("Connexion aux serveurs Last.fm en cours...\nChargement de tes stats en direct...");
            
            new Thread(() -> {
                try {
                    ApiClient api = new ApiClient();
                    String pseudo = txtPseudo.getText().trim();
                    String json = api.recupererScrobblesEnDirect(pseudo);
                    ArrayList<Ecoute> liste = api.convertirJsonEnEcoutes(json);

                    StatistiquesService statsService = new StatistiquesService();
                    String texteFinal = statsService.genererTexteWrapped(liste, 5);

                    txtResultat.setText(texteFinal);

                } catch (Exception ex) {
                    txtResultat.setText("Erreur : " + ex.getMessage());
                }
            }).start();
        });
    }
}
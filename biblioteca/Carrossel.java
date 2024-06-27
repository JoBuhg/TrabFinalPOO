package biblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Carrossel {
    Biblioteca biblioteca = Biblioteca.getInstance();
    Livro index = biblioteca.getLivro(0);

    private JPanel panel;
    private JLabel label;
    private JLabel nomeText;
    private JButton previousButton, nextButton;
    private int currentIndex = 0;
    
    private ArrayList<String> capas;
    private ArrayList<String> nomes;
    private int imageWidth = 195;
    private int imageHeight = 235;

    public Carrossel() {
        capas = new ArrayList<>();
        nomes = biblioteca.getNomesLivros();
        initUI();
    }

    private void initUI() {
        // Configuração do JPanel
        panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(400, 250));

        // Configuração do JLabel para exibir capas
        label = new JLabel();
        
        // label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0, 0, 195, 235);

        //label dos nomes dos livros
        nomeText = new JLabel(nomes.get(currentIndex));
        
        // Botões anterior e próximo
        previousButton = createNavigationButton("<");
        // previousButton.setBounds(0, 125, 50, 50);
        
        nextButton = createNavigationButton(">");
        // nextButton.setBounds(350, 125, 50, 50);
        
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousImage();
            }
        });
        
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });
        
        // Adicionar componentes ao JPanel
        
        panel.add(label);
        updateNome();
        updateImage();
    }
    
    private JButton createNavigationButton(String text) {
        JButton button = new JButton(text);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        return button;
    }
    
    private void updateImage() {
        if (!capas.isEmpty()) {
            ImageIcon icon = new ImageIcon(capas.get(currentIndex));
            Image image = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(image));
        } else {
            label.setIcon(null);
        }
    }
    
    private void updateNome() {
        if (!nomes.isEmpty()) {
            String nome = nomes.get(currentIndex);
            nomeText.setText(nome);
        } else {
            nomeText.setText("");
        }
    }
    
    //----------------------------------------------------------------------------------------
    private void showPreviousImage() {
        if (!capas.isEmpty() && !nomes.isEmpty()) {
            currentIndex = (currentIndex - 1 + capas.size()) % capas.size();
            updateImage();
            updateNome();
        }
    }
    
    private void showNextImage() {
        if (!capas.isEmpty() && !nomes.isEmpty()) {
            currentIndex = (currentIndex + 1) % capas.size();
            updateImage();
            updateNome();
        }
    }
    //---------------------------------------------------------------------------------------------
    public void addCapa(String path) {
        capas.add(path);
        if (capas.size() == 1) {
            updateImage();
        }
    }
    
    public void removeCapa(String path) {
        capas.remove(path);
        if (currentIndex >= capas.size()) {
            currentIndex = 0;
        }
        updateImage();
    }
    
    public JLabel getNomeText(){
        return nomeText;
    }
    public JButton getpreviousButton(){
        return previousButton;
    }
    
    public JButton getnextButton(){
        return nextButton;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setImageSize(int width, int height) {
        this.imageWidth = width;
        this.imageHeight = height;
        updateImage();
    }
  
    public int getCurrentIndex() {
        return currentIndex;
    }
}

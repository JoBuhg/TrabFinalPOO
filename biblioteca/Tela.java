package biblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame {
    private ImageIcon fundo;
    private ImageIcon bAtualizarImg;
    private ImageIcon bAdicionarImg;
    private String nomedol; //colocando os nomes dos livros em uma variavel para ultilizar com o path para a capa
    private int index;
    int endereco;
    
    public Tela() {
        
        fundo = new ImageIcon("C:\\Users\\joaov\\Documents\\2024\\POO\\TrabalhoFinal\\source\\1.png");
        bAtualizarImg = new ImageIcon("C:\\Users\\joaov\\Documents\\2024\\POO\\TrabalhoFinal\\source\\BotãoAtualizar.png");
        bAdicionarImg = new ImageIcon("C:\\Users\\joaov\\Documents\\2024\\POO\\TrabalhoFinal\\source\\botãoAdicionar.png");
        
        Biblioteca biblioteca = Biblioteca.getInstance();
        
        // Tela configuração
        setTitle("Aplicação de biblioteca");
        setSize(500, 800);
        setLocationRelativeTo(null); // Centralizar a janela na tela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        // Painel personalizado para desenhar a imagem de fundo
        JPanel painelfundo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(fundo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        painelfundo.setLayout(null); // Para usar setBounds nos botões
        
        // Setando os botões:
        int buttonWidth = 200;
        int buttonHeight = 50;
        // Criação do carrossel
        Carrossel carrossel = new Carrossel();
        index = carrossel.getCurrentIndex();
        //instanciação das capas
        for(int i = 0 ;i<biblioteca.getLivros().size() ;i++){
            nomedol = biblioteca.getNomeLivro(i);
            carrossel.addCapa("C:\\Users\\joaov\\Documents\\2024\\POO\\TrabalhoFinal\\capas\\"+nomedol+".jpg");
        }
        nomedol = biblioteca.getNomeLivro(index);
    
        
    
        // Redimensionamento do carrossel
        carrossel.setImageSize(100, 200);
    
        // Configurações de tamanho e posição do painel do carrossel
        JPanel carrosselPanel = carrossel.getPanel();
        carrosselPanel.setBounds(150, 150, 192, 232);
    
        // botões de ir para o próximo livro e o anterior
        JButton bFrente = carrossel.getnextButton();
        bFrente.setBounds(395, 250, 50, 50);
        bFrente.setBorderPainted(false);
        bFrente.setFocusPainted(false);
        bFrente.setOpaque(false);
        bFrente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe a nova janela
                endereco = endereco + 1;
                if (endereco > (biblioteca.getNomesLivros().size()-1)){
                    endereco = 0;
                    
                }
                
            }
        });
        
    
        JButton bAtras = carrossel.getpreviousButton();
        bAtras.setBounds(50, 250, 50, 50);
        bAtras.setBorderPainted(false);
        bAtras.setFocusPainted(false);
        bAtras.setOpaque(false);
        bAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe a nova janela
                endereco = endereco- 1;
                if (endereco < 0) {
                    endereco =  (biblioteca.getNomesLivros().size()-1);
                }
                
                
            }
        });
    
    
        // Criando o label de nome dos livros
        JLabel livroNome = carrossel.getNomeText();
        livroNome.setBounds((500 - 400) / 2, 400, 400, 100);
        livroNome.setHorizontalAlignment(SwingConstants.CENTER);
        livroNome.setFont(new Font("Times New Roman", 0, 30));
        livroNome.setForeground(new Color(203, 169, 130));

        // Redimensiona a imagem do ícone
        Image scaledImage = bAtualizarImg.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JButton bAtualizar = new JButton(scaledIcon);
        bAtualizar.setBounds(100, 650, buttonWidth, buttonHeight);

        // Tornar o botão transparente
        bAtualizar.setContentAreaFilled(false);
        bAtualizar.setBorderPainted(false);
        bAtualizar.setFocusPainted(false);
        bAtualizar.setOpaque(false);

        // Adiciona um listener para o botão
        bAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe a nova janela
                new Tela2(endereco);
                dispose();
            }
        });
        scaledImage = bAdicionarImg.getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(scaledImage);
        JButton bAdicionar = new JButton(scaledIcon);
        bAdicionar.setBounds( 325, 650, 50, buttonHeight);

        // Tornar o botão transparente
        bAdicionar.setContentAreaFilled(false);
        bAdicionar.setBorderPainted(false);
        bAdicionar.setFocusPainted(false);
        bAdicionar.setOpaque(false);

           // Adiciona um listener para o botão
        bAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe a nova janela
                new TelaAdicioar();
                dispose();
            }
        });





        // Adiciona os componentes ao painel de fundo
        painelfundo.add(bAtualizar);
        painelfundo.add(bAdicionar);
        painelfundo.add(bFrente);
        painelfundo.add(bAtras);
        painelfundo.add(livroNome);
        painelfundo.add(carrosselPanel);

        // Adiciona o painel de fundo ao JFrame
        add(painelfundo);

        // Torna a janela visível
        setVisible(true);
    }
}

package biblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela3 extends JFrame {
    private String nomedol;
    private ImageIcon fundo;
    private int index;

    public Tela3(int index) {
        this.index = index;

        fundo = new ImageIcon("C:\\Users\\joaov\\Documents\\2024\\POO\\TrabalhoFinal\\source\\3.png");

        // Configurações da nova janela
        setTitle("Editar Informações");
        setSize(500, 800);
        setLocationRelativeTo(null); // Centralizar a janela na tela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        setResizable(false);
        
        // Painel personalizado para desenhar a imagem de fundo
        JPanel painelFundo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(fundo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        painelFundo.setLayout(null); // Usaremos null layout para posicionar os componentes manualmente
        

        // Setando o carrossel
        Biblioteca biblioteca = Biblioteca.getInstance();
        nomedol = biblioteca.getNomeLivro(index);
        Carrossel carrossel = new Carrossel();
        carrossel.setImageSize(100, 200);
        carrossel.addCapa("C:\\Users\\joaov\\Documents\\2024\\POO\\TrabalhoFinal\\capas\\"+nomedol+".jpg");

        // Configurações de tamanho e posição do painel do carrossel
        JPanel carrosselPanel = carrossel.getPanel();
        carrosselPanel.setBounds(72, 41, 115, 140);
        
        
        // Criar os JTextFields transparentes
        JTextField nomeLivroField = new JTextField(biblioteca.getNomeLivro(index));
        nomeLivroField.setBounds((getWidth() - 300) / 2, 275, 300, 30); // Centralizar o JTextField horizontalmente
        nomeLivroField.setHorizontalAlignment(SwingConstants.CENTER);
        nomeLivroField.setFont(new Font("Times New Roman", 0, 30));
        nomeLivroField.setOpaque(false); // Torna o JTextField transparente
        nomeLivroField.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda

        JTextField nomeAutorField = new JTextField(biblioteca.getNomeAutor(index));
        nomeAutorField.setBounds((getWidth() - 300) / 2, 365, 300, 30); // Centralizar o JTextField horizontalmente
        nomeAutorField.setHorizontalAlignment(SwingConstants.CENTER);
        nomeAutorField.setFont(new Font("Times New Roman", 0, 30));
        nomeAutorField.setOpaque(false); // Torna o JTextField transparente
        nomeAutorField.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda

        JLabel paginaslidasJLabel = new JLabel("Paginas lidas/Total");
        paginaslidasJLabel.setBounds((getWidth() - 350) / 2, 415, 300, 30);
        paginaslidasJLabel.setFont(new Font("Times New Roman", 0, 25));
        paginaslidasJLabel.setForeground(new Color(203, 169, 130));

        JTextField numPaginasField = new JTextField(biblioteca.getPaginaLida(index));
        numPaginasField.setBounds((getWidth() - 300) / 2, 455, 300, 30); // Centralizar o JTextField horizontalmente
        numPaginasField.setHorizontalAlignment(SwingConstants.CENTER);
        numPaginasField.setFont(new Font("Times New Roman", 0, 30));
        numPaginasField.setOpaque(false); // Torna o JTextField transparente
        numPaginasField.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda

        // Adiciona as Checkboxes
        JTextField lendoField = new JTextField("Lendo");
        lendoField.setBounds((getWidth() - 300) / 2, 555, 300, 30); // Centralizar a Checkbox horizontalmente
        lendoField.setOpaque(false); // Torna a Checkbox transparente
        lendoField.setForeground(new Color(203, 169, 130)); // Define a cor do texto
        lendoField.setFont(new Font("Times New Roman", 0, 20));

        // Adiciona um botão de deletar com texto transparente
        JButton botaoDeletar = new JButton("Deletar Livro");
        botaoDeletar.setBounds((getWidth() - 300) / 2, 625, 300, 30); // Centralizar o JButton horizontalmente
        botaoDeletar.setContentAreaFilled(false); // Tornar o botão transparente
        botaoDeletar.setBorderPainted(false); // Remove a borda
        botaoDeletar.setFocusPainted(false); // Remove o foco
        botaoDeletar.setForeground(new Color(203, 169, 130)); // Define a cor do texto
        botaoDeletar.setFont(new Font("Times New Roman", 0, 30));
        botaoDeletar.setOpaque(false); // Torna o botão transparente

        // Adiciona um botão de salvar com uma imagem
        ImageIcon salvarImg = new ImageIcon("C:\\Users\\joaov\\Documents\\2024\\POO\\TrabalhoFinal\\source\\BotãoSalvar.png");
        Image scaledImage = salvarImg.getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        JButton botaoSalvar = new JButton(scaledIcon);
        botaoSalvar.setBounds(300, 700, 150, 55); // Centralizar o JButton horizontalmente
        botaoSalvar.setContentAreaFilled(false); // Tornar o botão transparente
        botaoSalvar.setBorderPainted(false); // Remove a borda
        botaoSalvar.setFocusPainted(false); // Remove o foco
        botaoSalvar.setOpaque(false); // Torna o botão transparente

       
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Biblioteca biblioteca = Biblioteca.getInstance();

                biblioteca.setNomeLivro(index, nomeLivroField.getText());
                biblioteca.setPaginaLida(index, numPaginasField.getText());

                biblioteca.setNomeAutor(index, nomeAutorField.getText());
                biblioteca.setStatuslivro(index, lendoField.getText());
               
                new Tela();
                dispose();
            }
        });
        // Adiciona um botão de descartar com uma imagem
        ImageIcon descartarImg = new ImageIcon("C:\\Users\\joaov\\Documents\\2024\\POO\\TrabalhoFinal\\source\\BotãoDescartar.png");
        Image scaledImageDescartar = descartarImg.getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDescartar = new ImageIcon(scaledImageDescartar);

        JButton botaoDescartar = new JButton(scaledIconDescartar);
        botaoDescartar.setBounds(50, 700, 150, 55); // Centralizar o JButton horizontalmente
        botaoDescartar.setContentAreaFilled(false); // Tornar o botão transparente
        botaoDescartar.setBorderPainted(false); // Remove a borda
        botaoDescartar.setFocusPainted(false); // Remove o foco
        botaoDescartar.setOpaque(false); // Torna o botão transparente

        // Adiciona um ActionListener ao botão descartar para fechar a janela
        botaoDescartar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Biblioteca biblioteca = Biblioteca.getInstance();
                biblioteca.delLivro(index);
                biblioteca.delNomeLivro(index);
                biblioteca.delPaginaLida(index);
                biblioteca.delNomeAutor(index);
                biblioteca.delStatuslivro(index);

                dispose(); // Fecha a janela atual
                new Tela();
            }
        });

        // Adiciona os componentes ao painel de fundo
        painelFundo.add(carrosselPanel);
        painelFundo.add(nomeLivroField);
        painelFundo.add(nomeAutorField);
        painelFundo.add(paginaslidasJLabel);
        painelFundo.add(numPaginasField);
        painelFundo.add(lendoField);
        painelFundo.add(botaoDeletar);
        painelFundo.add(botaoSalvar);
        painelFundo.add(botaoDescartar);

        // Adiciona o painel à janela
        add(painelFundo);

        // Torna a janela visível
        setVisible(true);
    }

    // public static void main(String[] args) {
    //     new Tela3();
    // }
}

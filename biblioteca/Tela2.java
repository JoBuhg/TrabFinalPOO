package biblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela2 extends JFrame {

    private ImageIcon fundo;
    private ImageIcon bVoltarImg;
    private ImageIcon bEditarImg;
    public int index;
    private String nomedol;
    

    public Tela2(int index) {
        Biblioteca biblioteca = Biblioteca.getInstance();
        
        fundo = new ImageIcon("C:\\Users\\joaov\\Documents\\2024\\POO\\TrabalhoFinal\\source\\2.png");

        // Tela configuração
        setTitle("Informações de Leitura");
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



        Carrossel carrossel = new Carrossel();
        
        // Configurações de tamanho e posição do painel do carrossel
        JPanel carrosselPanel = carrossel.getPanel();
        carrosselPanel.setBounds(167, 58, 157, 192);
        //instanciação das capas
        this.index = index;
        System.out.println(index);
        
        nomedol = biblioteca.getNomeLivro(index);
        carrossel.addCapa("C:\\Users\\joaov\\Documents\\2024\\POO\\TrabalhoFinal\\capas\\"+nomedol+".jpg");
        

        // Adiciona os JLabel
        JLabel nomelivro = new JLabel(biblioteca.getNomeLivro(index));
        nomelivro.setBounds((getWidth() - 400) / 2, 300, 400, 30); // Centralizar o JLabel horizontalmente
        nomelivro.setHorizontalAlignment(SwingConstants.CENTER);
        nomelivro.setFont(new Font("Times New Roman", 0, 30));
        nomelivro.setForeground(new Color(203, 169, 130));

        JLabel nomeautor = new JLabel(biblioteca.getNomeAutor(index));
        nomeautor.setBounds((getWidth() - 400) / 2, 400, 400, 30);
        nomeautor.setHorizontalAlignment(SwingConstants.CENTER);
        nomeautor.setFont(new Font("Times New Roman", 0, 30));
        nomeautor.setForeground(new Color(203, 169, 130));

        JLabel numdeapag = new JLabel(biblioteca.getPaginaLida(index));
        numdeapag.setBounds((getWidth() - 200) / 2, 500, 200, 30);
        numdeapag.setHorizontalAlignment(SwingConstants.CENTER);
        numdeapag.setFont(new Font("Times New Roman", 0, 30));
        numdeapag.setForeground(new Color(53, 24, 13));

        JLabel Status = new JLabel(biblioteca.getStatuslivro(index));
        Status.setBounds((getWidth() - 200) / 2, 630, 200, 30);
        Status.setHorizontalAlignment(SwingConstants.CENTER);
        Status.setFont(new Font("Times New Roman", 0, 25));
        Status.setForeground(new Color(203, 169, 130));

        // Adiciona os componentes ao painel de fundo
        painelFundo.add(carrosselPanel);
        painelFundo.add(nomelivro);
        painelFundo.add(nomeautor);
        painelFundo.add(numdeapag);
        painelFundo.add(Status);

        // Setando os botões:
        int buttonWidth = 60;
        int buttonHeight = 45;

        // Pegando a imagem do botão
        bVoltarImg = new ImageIcon("C:\\Users\\joaov\\Documents\\2024\\POO\\TrabalhoFinal\\source\\BotãoVoltar.png");
        Image scaledImage = bVoltarImg.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Adiciona um botão para fechar a janela
        JButton botaoFechar = new JButton(scaledIcon);
        botaoFechar.setBounds(100, 675, 125, 80); // Centralizar o JButton horizontalmente
        // Tornar o botão transparente
        botaoFechar.setContentAreaFilled(false);
        botaoFechar.setBorderPainted(false);
        botaoFechar.setFocusPainted(false);
        botaoFechar.setOpaque(false);
        botaoFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Tela();
                dispose(); // Fecha apenas esta janela
            }
        });
        painelFundo.add(botaoFechar);

        // Botão editar
        bEditarImg = new ImageIcon("C:\\Users\\joaov\\Documents\\2024\\POO\\TrabalhoFinal\\source\\BotãoEditar.png");
        Image scaledImage2 = bEditarImg.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);

        // Adiciona um botão para editar
        JButton botaoEditar = new JButton(scaledIcon2);
        botaoEditar.setBounds(265, 675, 125, 80); // Centralizar o JButton horizontalmente
        // Tornar o botão transparente
        botaoEditar.setContentAreaFilled(false);
        botaoEditar.setBorderPainted(false);
        botaoEditar.setFocusPainted(false);
        botaoEditar.setOpaque(false);
        botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Tela3(index); // Abre a nova janela EditarInformacoes
            }
        });
        painelFundo.add(botaoEditar);

        // Adiciona o painel de fundo ao JFrame
        add(painelFundo);

        // Torna a janela visível
        setVisible(true);
    }

    // public static void main(String[] args) {
    //     new Tela2();
    // }
}

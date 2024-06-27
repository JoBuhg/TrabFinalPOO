package biblioteca;

class Livro {
    private int index;
    private String nome;
    private String autor;
    private String paginasLidas;
    private String status;

    // Instância única da classe
    private static Livro INSTANCE;

    // Construtor privado para impedir a criação de novas instâncias
    private Livro() {
    }

    // Método estático para obter a instância única
    public static Livro getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Livro();
        }
        return INSTANCE;
    }

    // Getters e setters
    public int getIndex() {return index;}
    public int setindex (int index) {
        index = index + this.index;
        return index;

    }


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getPaginasLidas() { return paginasLidas; }
    public void setPaginasLidas(String paginasLidas) { this.paginasLidas = paginasLidas; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Método toString para retornar uma representação em forma de string do objeto
    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", autor='" + autor + '\'' +
                ", paginasLidas='" + paginasLidas + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

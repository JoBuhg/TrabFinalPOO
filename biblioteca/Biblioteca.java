package biblioteca;

import java.util.ArrayList;


public class Biblioteca {
    private static Biblioteca instanciaUnica;

    private ArrayList<Livro> livros;
    private ArrayList<String> nomesLivros;
    private ArrayList<String> autoresLivros;
    private ArrayList<String> paginasLidasLivros;
    private ArrayList<String> status;

    private Biblioteca() {
        livros = new ArrayList<>();
        nomesLivros = new ArrayList<>();
        autoresLivros = new ArrayList<>();
        paginasLidasLivros = new ArrayList<>();
        status = new ArrayList<>();
    }

    public static Biblioteca getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new Biblioteca();
        }
        return instanciaUnica;
    }

    
    public ArrayList<Livro> getLivros() {
        return livros;
    }
    
    public String getNomeLivro(int index) {
        return nomesLivros.get(index);

    }

    public ArrayList<String> getNomesLivros() {
        return nomesLivros;
    }
    
    public Livro getLivro(int index) {
        if (index >= 0 && index < livros.size()) {
            return livros.get(index);
        } else {
            return null; // ou lançar uma exceção se preferir
        }
    }
    public void delLivro(int index) {
        livros.remove(index);
    }
    public void setNomeLivro(int index,String autor) {
        nomesLivros.set(index,autor);
     }
     public void delNomeLivro(int index) {
        nomesLivros.remove(index);
    }
    
    public ArrayList<String> getAutoresLivros() {
        return autoresLivros;
    }
    public String getNomeAutor(int index) {
        return autoresLivros.get(index);
    }
    public void delNomeAutor(int index) {
        autoresLivros.remove(index);
    }
    public void setNomeAutor(int index,String autor) {
       autoresLivros.set(index,autor);
    }

    public ArrayList<String> getPaginasLidasLivros() {
        return paginasLidasLivros;
    }
    public String getPaginaLida(int index) {
        return paginasLidasLivros.get(index);
    }
    public void delPaginaLida(int index) {
        paginasLidasLivros.remove(index);
    }
    public void setPaginaLida(int index,String autor) {
        paginasLidasLivros.set(index,autor);
     }

    public ArrayList<String> getStatus() {
        return status;
    }
    public String getStatuslivro(int index) {
        return status.get(index);

    }
    public void delStatuslivro(int index) {
        status.remove(index);
    }
    public void setStatuslivro(int index,String autor) {
        status.set(index,autor);
     }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        nomesLivros.add(livro.getNome());
        autoresLivros.add(livro.getAutor());
        paginasLidasLivros.add(livro.getPaginasLidas());
        status.add(livro.getStatus());
    }
}

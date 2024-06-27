package biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca minhabiblioteca = Biblioteca.getInstance();
        Livro meulivro = Livro.getInstance();
        meulivro.setNome("A Magic Steeped in Poison");
        meulivro.setAutor(" Judy I Lin");
        meulivro.setPaginasLidas("200/400");
        meulivro.setStatus("lendo");
        minhabiblioteca.adicionarLivro(meulivro);
        
        
        meulivro.setNome("A Study in Drowning");
        meulivro.setAutor("Ava Reid");
        meulivro.setPaginasLidas("200/400");
        meulivro.setStatus("lendo");
        minhabiblioteca.adicionarLivro(meulivro);
        
        
        meulivro.setNome("Blood Orange");
        meulivro.setAutor("Harriet Tyce");
        meulivro.setPaginasLidas("200/400");
        meulivro.setStatus("lendo");
        minhabiblioteca.adicionarLivro(meulivro);

        
        meulivro.setNome("Once Upon a Broken Heart");
        meulivro.setAutor("Stephanie Garber");
        meulivro.setPaginasLidas("200/400");
        meulivro.setStatus("lendo");
        minhabiblioteca.adicionarLivro(meulivro);

        
        meulivro.setNome("Powerless");
        meulivro.setAutor("Lauren Roberts");
        meulivro.setPaginasLidas("200/400");
        meulivro.setStatus("lendo");
        minhabiblioteca.adicionarLivro(meulivro);
    

        
        
        
         new Tela();
    }
}

//singleton factory

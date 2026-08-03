package cinevento.irl;

import java.io.Serializable;

public class Filme implements Serializable {
    private int id; //id interno do filme
    private String titulo;
    private String genero;
    private int duracao; // em segundos
    private String classificacaoIndicativa; //L, 10, 12, 16, 18

    public Filme(int id, String titulo, String genero, int duracao, String classificacaoIndicativa){
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setNome(String nome) {
        this.titulo = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    @Override
    public String toString() {
        return "(" + id + ")" + titulo +
                " | Gênero: " + genero +
                " | Duração: " + duracao +
                "s| [" + classificacaoIndicativa + "]";
    }
}

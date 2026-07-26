package cinevento.irl;

public class Filme {
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
        this.titulo = titulo;
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
        return "Filme:" + id +"(Nome: " + titulo +
                "| Gênero: " + genero +
                "| Duração(em sec): " + duracao +
                "| Classificação Indicativa: " + classificacaoIndicativa;
    }
}

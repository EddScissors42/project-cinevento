package cinevento.irl;

import cinevento.repository.TipoSala;

import java.io.Serializable;
import java.util.Map;

public class Sessao implements Serializable {
    private int numero;
    private TipoSala tipo;
    private Map<String, Cadeira> cadeiras;
    private Filme filme;

    public Sessao(int numero, TipoSala tipo, Map<String, Cadeira> cadeiras, Filme filme){
        this.numero = numero;
        this.tipo = tipo;
        this.cadeiras = cadeiras;
        this.filme = filme;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoSala getTipo() {
        return tipo;
    }

    public void setTipo(TipoSala tipo) {
        this.tipo = tipo;
    }

    public Map<String, Cadeira> getCadeiras() {
        return cadeiras;
    }

    public void setCadeiras(Map<String, Cadeira> cadeiras) {
        this.cadeiras = cadeiras;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return "Sessão " + numero + " " + tipo + " Cadeiras disponiveis: " + cadeiras + "\nFilme: " + filme;
    }
}
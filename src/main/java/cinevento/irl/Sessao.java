package cinevento.irl;

import cinevento.repository.TipoSala;
import java.util.Map;

public class Sessao {
    private int numero;
    private TipoSala tipo; // Sala 3D, Macro XE, IMAX
    private Map<String, Cadeira> cadeiras; // cadeira lol

    public Sessao(int numero, TipoSala tipo, Map<String, Cadeira> cadeiras){
        this.numero = numero;
        this.tipo = tipo;
        this.cadeiras = cadeiras;
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

    @Override
    public String toString() {
        return "Sessão " + numero + tipo + "Numero de cadeiras: " + cadeiras;
    }
}

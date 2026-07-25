package cinevento.irl;

public class Cadeira {

    private String codigo;
    private boolean ocupada;

    public Cadeira(String codigo, boolean ocupada){
        this.codigo = codigo;
        this.ocupada = ocupada;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}

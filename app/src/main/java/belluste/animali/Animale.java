package belluste.animali;

import java.util.Objects;

public class Animale {

    private String nome;
    private int immagine;
    private int verso;

    public Animale(String nome, int immagine, int verso) {
        this.nome = nome;
        this.immagine = immagine;
        this.verso = verso;
    }

    public String getNome() {
        return nome;
    }

    public int getImmagine() {
        return immagine;
    }

    public int getVerso() {
        return verso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animale animale = (Animale) o;
        return immagine == animale.immagine &&
                verso == animale.verso &&
                Objects.equals(nome, animale.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, immagine, verso);
    }
}

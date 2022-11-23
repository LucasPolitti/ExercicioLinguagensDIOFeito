import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Linguagem {

    public static void main(String[] args) {


        System.out.println("ORDEM ALEATÓRIA: ");

        Set<Language> minhasLinguagens = new HashSet<>() {{
            
            add(new Language("Java", "NetBeans", 1991));
            add(new Language("Kotlin", "Intellij", 2011));
            add(new Language("Dart", "AndroidStudio", 2011));


        }};

        for (Language language : minhasLinguagens) System.out.println(language.getNome() + " - " + language.getIde() + " - " + language.getAnoCriacao());


        System.out.println("ORDEM NATURAL(ANO DE CRIAÇÃO");
        
        Set<Language> minhasLinguagens1 = new TreeSet<>(minhasLinguagens);
        for (Language language : minhasLinguagens1) System.out.println(language.getNome() + " - " + language.getIde() + " - " + language.getAnoCriacao());


        System.out.println("ORDEM NOME/IDE/ANO CRIAÇÃO");

        Set<Language> minhasLinguagens2 = new TreeSet<>(new ComparatorNomeIDEanoCriacao());
        minhasLinguagens2.addAll(minhasLinguagens);

        for (Language language : minhasLinguagens2) System.out.println(language.getNome() + " - " + language.getIde() + " - " + language.getAnoCriacao());




        
        


    }







}













class Language implements Comparable <Language> { 

    private String nome;
    private String ide;
    private Integer anoCriacao;
    
    
    public Language(String nome, String ide, Integer anoCriacao) {
        this.nome = nome;
        this.ide = ide;
        this.anoCriacao = anoCriacao;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getIde() {
        return ide;
    }


    public void setIde(String ide) {
        this.ide = ide;
    }


    public Integer getAnoCriacao() {
        return anoCriacao;
    }


    public void setAnoCriacao(Integer anoCriacao) {
        this.anoCriacao = anoCriacao;
    }


    @Override
    public String toString() {
        return "[nome=" + nome + ", ide=" + ide + ", anoCriacao=" + anoCriacao + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((ide == null) ? 0 : ide.hashCode());
        result = prime * result + ((anoCriacao == null) ? 0 : anoCriacao.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Language other = (Language) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (ide == null) {
            if (other.ide != null)
                return false;
        } else if (!ide.equals(other.ide))
            return false;
        if (anoCriacao == null) {
            if (other.anoCriacao != null)
                return false;
        } else if (!anoCriacao.equals(other.anoCriacao))
            return false;
        return true;
    }


    @Override
    public int compareTo(Language language) {

        int anoCriacao = Integer.compare(this.getAnoCriacao(), language.getAnoCriacao());
        if (anoCriacao !=0) return anoCriacao;
        
        return this.getIde().compareTo(language.getIde());
    
    }


}

class ComparatorNomeIDEanoCriacao implements Comparator<Language> {

    @Override
    public int compare(Language lang1, Language lang2) {
        
        int nome = lang1.getNome().compareTo(lang2.getNome());
        if (nome !=0) return nome;
        
        int ide = lang1.getIde().compareTo(lang2.getIde());
        if (ide !=0) return ide;
        
        return Integer.compare(lang1.getAnoCriacao(), lang2.getAnoCriacao());
        
        
        

        
    }

    


}


package jo;

public enum Sexe {
    HOMME("homme"), FEMME("femme");

    private final String genre;

    private Sexe(String genre){
        this.genre = genre;
    }

    public String getGenre(){
        return this.genre;
    }


}
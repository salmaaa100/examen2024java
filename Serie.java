package examen2024;

public class Serie extends Content {

    private int nbEpisodes;
    private int dureeEpisode; 

    public Serie(String title, String genre, boolean isFree, int nbEpisodes, int dureeEpisode) {
        super(title, genre, isFree);
        this.nbEpisodes = nbEpisodes;
        this.dureeEpisode = dureeEpisode;
    }

    public void afficheDetails() {
        System.out.println("Série : " + title + " | Genre : " + genre+ " | " + (isFree ? "Gratuit" : "Payant")+ " | Épisodes : " + nbEpisodes + " | Durée par épisode : " + dureeEpisode + " min" + " | Durée totale : " + getDuration() + " min");
    }

    public int getDuration() {
        return nbEpisodes * dureeEpisode;
    }
}
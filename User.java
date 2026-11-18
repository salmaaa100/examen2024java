package examen2024;

public class User {
    String name;
    boolean isSubscribed;
    Content[] watchedContent;
    int nbWatched;
    public static final int MAX_WATCHED = 100;

    public User(String name, boolean isSubscribed) {
        this.name = name;
        this.isSubscribed = isSubscribed;
        this.watchedContent = new Content[MAX_WATCHED];
        this.nbWatched = 0;
    }

    public String getName() { 
    	return name; 
    }

    public boolean canPlay(Content content) {
        return isSubscribed || content.isFree();
    }

    public void addWatchedContent(Content content) {
        if (nbWatched < MAX_WATCHED) {
            watchedContent[nbWatched] = content;
            nbWatched++;
        }
    }
    public boolean hasWatched(Content content) {
        for (int i = 0; i < nbWatched; i++) {
            if (watchedContent[i] == content) {
                return true;
            }
        }
        return false;
    }

    public String[] getWatchedGenres() {
        String[] temp = new String[nbWatched];
        int count = 0;
        for (int i = 0; i < nbWatched; i++) {
            String g = watchedContent[i].getGenre();
            boolean exists = false;
            for (int j = 0; j < count; j++) {
                if (temp[j].equals(g)) {
                    exists = true;
                }
            }
            if (!exists) {
                temp[count] = g;
                count++;
            }
        }
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }
}
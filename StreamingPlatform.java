package examen2024;

public class StreamingPlatform {
    private Content[] contents;
    private User[] users;
    private int nbContents;
    private int nbUsers;

    public StreamingPlatform(int capContents, int capUsers) {
        contents = new Content[capContents];
        users = new User[capUsers];
        nbContents = 0;
        nbUsers = 0;
    }

    public void addContent(Content content) {
        if (nbContents < contents.length) {
            contents[nbContents] = content;
            nbContents++;
        }
    }

    public void addUser(User user) {
        if (nbUsers < users.length) {
            users[nbUsers] = user;
            nbUsers++;
        }
    }
    //chercher un coontenu 	avec son titre
    public Content findContent(String title) throws ContentNotFoundException {
        for (int i = 0; i < nbContents; i++) {
            if (contents[i].getTitle().equals(title)) {
                return contents[i];
            }
        }
        throw new ContentNotFoundException("Contenu introuvable : " + title);
    }
    public void playContent(User user, String title)
            throws ContentNotFoundException, AccessDeniedException {
        Content c = findContent(title);
        if (!user.canPlay(c)) {
            throw new AccessDeniedException(user.getName()
                    + " n'a pas accès au contenu payant : " + title);
        }
        c.play();
        user.addWatchedContent(c);
    }

    public Content[] getRecommendations(User user) {
        Content[] reco = new Content[10];
        int n = 0;
        String[] genres = user.getWatchedGenres();

        for (int i = 0; i < nbContents && n < 10; i++) {
            Content c = contents[i];
            if (!user.hasWatched(c)) {
                for (int j = 0; j < genres.length; j++) {
                    if (c.getGenre().equals(genres[j])) {
                        reco[n] = c;
                        n++;
                        break;
                    }
                }
            }
        }

        Content[] result = new Content[n];
        for (int i = 0; i < n; i++) {
            result[i] = reco[i];
        }
        return result;
    }
}

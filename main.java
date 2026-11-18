package examen2024;

public class main {
    public static void main(String[] args) {
        StreamingPlatform p = new StreamingPlatform(10, 10);

        Content c1 = new Movie("Inception", "Sci-Fi", false, 148);
        Content c2 = new Serie("Stranger Things", "Thriller", false, 25, 50);
        Content c3 = new Movie("Charlie Chaplin", "Comedy", true, 75);
        Content c4 = new Serie("Friends", "Comedy", true, 236, 22);

        p.addContent(c1);
        p.addContent(c2);
        p.addContent(c3);
        p.addContent(c4);

        c1.afficheDetails();
        c2.afficheDetails();
        c3.afficheDetails();
        c4.afficheDetails();

        User user1 = new User("Imene", false);
        User user2 = new User("Jihene", true);
        p.addUser(user1);
        p.addUser(user2);

        try {
            p.playContent(user1, "Inception");
        } catch (ContentNotFoundException | AccessDeniedException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        try {
            p.playContent(user1, "Charlie Chaplin");
            p.playContent(user2, "Stranger Things");
            p.playContent(user2, "Friends");
        } catch (ContentNotFoundException | AccessDeniedException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("Recommandations pour Jihene :");
        Content[] reco = p.getRecommendations(user2);
        for (int i = 0; i < reco.length; i++) {
            reco[i].afficheDetails();
        }
    }
}
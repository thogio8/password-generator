import java.security.SecureRandom;
import java.util.Scanner;

public class GenerateurMDP {

    // Méthode pour lire le choix de l'utilisateur concernant les caractéristiques du mot de passe
    static boolean lireChoixCaracteres (Scanner scanner, String prompt){
        String choix;
        do {
            System.out.println(prompt); // Affiche la question à l'utilisateur
            choix = scanner.next().toUpperCase(); // Lit la réponse et la convertit en majuscules pour la comparaison
        } while (!choix.equals("O") && !choix.equals("N")); // Répète jusqu'à obtenir une réponse valide
        return choix.equals("O"); // Retourne true si l'utilisateur choisit "O"
    }

    // Méthode pour lire la longueur souhaitée du mot de passe, en respectant une longueur minimale
    static int lireChoixLongueur(Scanner scanner, int longueurMinimale){
        int longueur;
        while (true) {
            System.out.println("La longueur minimale du mot de passe est : " + longueurMinimale + "\nVeuillez saisir la longueur du mot de passe : ");
            if (scanner.hasNextInt()) {
                longueur = scanner.nextInt();
                scanner.nextLine(); // Nettoie le buffer du scanner
                if (longueur >= longueurMinimale) {
                    return longueur; // Retourne la longueur si elle est valide
                } else {
                    System.out.println("La longueur saisie est inférieure à la longueur minimale requise.");
                }
            } else {
                System.out.println("La valeur saisie n'est pas correcte, veuillez entrer un nombre entier.");
                scanner.next(); // Nettoie le buffer du scanner pour la prochaine itération
            }
        }
    }

    // Méthode pour générer le mot de passe selon les critères spécifiés
    static String generationMotDePasse(int longueur, boolean maj, boolean num, boolean spec){
        SecureRandom secureRandom = new SecureRandom(); // Utilise SecureRandom pour une génération de nombres aléatoires sécurisée
        StringBuilder mdp = new StringBuilder(); // Crée un StringBuilder pour construire le mot de passe
        String pool = "abcdefghijklmnopqrstuvwxyz"; // Pool de base de caractères
        String majuscules = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        String caracteresSpeciaux = "!@#$%^&*()";
        // Ajout des caractères supplémentaires selon les choix de l'utilisateur
        if (maj) {
            mdp.append(majuscules.charAt(secureRandom.nextInt(majuscules.length())));
            pool += majuscules;
        }
        if (num) {
            mdp.append(numeros.charAt(secureRandom.nextInt(numeros.length())));
            pool += numeros;
        }
        if (spec) {
            mdp.append(caracteresSpeciaux.charAt(secureRandom.nextInt(caracteresSpeciaux.length())));
            pool += caracteresSpeciaux;
        }
        // Génère le reste du mot de passe
        for (int i = mdp.length(); i < longueur; i++) {
            mdp.append(pool.charAt(secureRandom.nextInt(pool.length())));
        }
        // Mélange les caractères du mot de passe pour plus de sécurité
        char[] mdpArray = mdp.toString().toCharArray();
        for (int i = mdpArray.length - 1; i > 0; i--) {
            int j = secureRandom.nextInt(i + 1);
            char temp = mdpArray[i];
            mdpArray[i] = mdpArray[j];
            mdpArray[j] = temp;
        }
        return new String(mdpArray); // Retourne le mot de passe mélangé
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); // Initialise le scanner pour lire l'entrée de l'utilisateur
        // Lecture des choix de caractéristiques du mot de passe
        boolean maj = lireChoixCaracteres(scanner, "Voulez-vous que votre mot de passe contienne des majuscules ? (O/N)");
        boolean num = lireChoixCaracteres(scanner, "Voulez-vous que votre mot de passe contienne des numéros ? (O/N)");
        boolean spec = lireChoixCaracteres(scanner, "Voulez-vous que votre mot de passe contienne des caractères spéciaux ? (O/N)");

        // Calcul et lecture de la longueur du mot de passe
        int longueurMinimale = 1 + (maj ? 1 : 0) + (num ? 1 : 0) + (spec ? 1 : 0);
        int longueur = lireChoixLongueur(scanner, longueurMinimale);

        // Génération et affichage du mot de passe
        System.out.println("Votre mot de passe généré est : " + generationMotDePasse(longueur, maj, num, spec));

        scanner.close(); // Ferme le scanner à la fin du programme
    }
}
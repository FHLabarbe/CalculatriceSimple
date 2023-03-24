import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> historiqueDeCalcul = new ArrayList<ArrayList<String>>();
        System.out.println("Bonjour, et bienvenue dans votre calculatrice 1.0");
        System.out.println("Veuillez trouver le menu ci dessous et sélectionner votre opération :");
        int choix = 0;
        boolean condition = false;
        while(true) {
            // vérifier que le numéro de quitter correspond à la condition de sortie de la boucle !
            System.out.println("1 - Addition");
            System.out.println("2 - Soustraction");
            System.out.println("3 - Multiplication");
            System.out.println("4 - Division");
            System.out.println("5 - Visionner l'historique de calcul");
            System.out.println("6 - Quitter");
            Scanner scanner = new Scanner(System.in);
            choix = scanner.nextInt();
            scanner.nextLine();
            while (condition == false){
                if (choix != 1 && choix != 2 && choix != 3 && choix != 4 && choix != 5 && choix != 6) {
                    System.out.println("Votre réponse ne figure pas dans les choix disponibles, veuillez recommencer");
                    choix = scanner.nextInt();
                    scanner.nextLine();
                }
                else{
                    condition = true;
                }
            }
            if (choix != 6 && choix != 5){
                historiqueDeCalcul.add(calculatrice(choix));
            }
            else if (choix == 5) {
                System.out.println(historiqueDeCalcul);
            }
            else{
                System.out.println("Au revoir et à bientôt !");
                scanner.close();
                break;
            }
        }
    }
    public static ArrayList<String> calculatrice(int choix){
        int resultat = 0;
        ArrayList<String> listeTemporaire = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le premier nombre :");
        int number1 = scanner.nextInt();
        listeTemporaire.add(intToString(number1));
        scanner.nextLine();
        System.out.println("Entrez le deuxième nombre :");
        int number2 = scanner.nextInt();
        listeTemporaire.add(intToString(number2));
        scanner.nextLine();
        if (choix == 1){
            listeTemporaire.add("addition");
            resultat = number1 + number2;
        } else if (choix == 2) {
            listeTemporaire.add("soustraction");
            resultat = number1 - number2;
        } else if (choix == 4) {
            listeTemporaire.add("division");
            resultat = number1 / number2;
        } else if (choix == 3) {
            listeTemporaire.add("multiplication");
            resultat = number1 * number2;
        }
        listeTemporaire.add(intToString(resultat));
        System.out.println("Le résultat est : " + resultat);
        System.out.println("Désormais, quel calcul souhaitez vous effectuer ?");
        return listeTemporaire;
    }
    public static String intToString(int chiffre){
        return ""+chiffre;
    }
}
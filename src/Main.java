import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entre un nombre N :");
        int N = scanner.nextInt();

        int[] listeN = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            listeN[i] = i + 1;
        }

        /* Permet de tester si ma liste affiche bien de 1 à N+1
        System.out.println(Arrays.toString(listeN));*/

        Random nombreAleatoire = new Random();
        int indexNombreAleatoire = nombreAleatoire.nextInt(listeN.length);
        int nombreManquant = listeN[indexNombreAleatoire];

        /*Pour vérifier que le nombre manquant a bien été choisi
        System.out.println("Nombre manquant : " + nombreManquant); */

        int[] listeSansNombreManquant = new int[N];
        int j = 0;
        for (int i = 0; i < listeN.length; i++) {
            if (i != indexNombreAleatoire) {
                listeSansNombreManquant[j] = listeN[i];
                j++;
            }
        }
        //Pour vérifier que le nouveau tableau s'affiche sans le nombre manquant:
        System.out.println(Arrays.toString(listeSansNombreManquant));


        int sommeListeN = calculerSomme(listeN);
        int sommeListeSansNombreManquant = calculerSomme(listeSansNombreManquant);
        int resultatNombreManquant = sommeListeN - sommeListeSansNombreManquant;

        /*Pour vérifier les sommes:
        System.out.println("Somme ListeN :" + sommeListeN);
        System.out.println("Somme liste sans nombre manquant :" +sommeListeSansNombreManquant);*/
        System.out.println(resultatNombreManquant);
    }

    public static int calculerSomme(int[] tableau) {
        int somme = 0;
        for (int i = 0; i < tableau.length; i++) {
            somme += tableau[i];
        }
        return somme;
    }

}

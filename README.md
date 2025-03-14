# Nombre manquant

### Enoncé

On vous donne un tableau d'entiers **de taille N contenant des nombres uniques de 1 à N+1**, mais **un seul nombre manque**.
Votre mission est d’**écrire un algorithme efficace** en Java pour **trouver le nombre manquant**. <br>

### Exemples

<span style="color:green;">
Entrée : [1, 2, 4, 5, 6]  <br>  
Sortie : 3  <br>
<br>
Entrée : [2, 3, 1, 5]  <br>  
Sortie : 4
</span>

### Code

Je pars du postulat que la liste, sous forme d'un tableau, est `de 1 à N+1` est initialisée suite à la requête utilisateur d'une valeur N. Ensuite je considère que le nombre manquant est retiré **aléatoirement**.
Mis en commentaires par la suite, les `System.out.println` permettent d'afficher et de vérifier le bon fonctionnement à l'avancement du code.
Mise en pratique de la méthodologie évoquée en cours: `Extraire, trier, afficher`.

Donc dans un premier temps, il faut générer le tableau.
le `[N+1]`permet de générer un tableau avec un nombre d'éléments correspondant à `N`+1

```java
  int[] listeN = new int[N + 1];

for (int i = 0; i < N + 1; i++) {
    listeN[i] = i + 1;
}
```

Donc si `N=20` alors il y aura 21 éléments dans le tableau.  \
La boucle `for` couplée avec `listeN[i]= i+1` permet donc d'avoir un tableau avec des valeurs de `1 à N+1`, soit en l'espèce `21`.

La génération du nombre manquant se fait de manière aléatoire, et le résultat est récupéré dans deux variables l'une pour l'index et l'autre pour la valeur.

```java
Random nombreAleatoire = new Random();
int indexNombreAleatoire = nombreAleatoire.nextInt(listeN.length);
int nombreManquant = listeN[indexNombreAleatoire];
```
Ensuite il faut initialiser une liste reprenant les éléments de la liste initiale sans le nombre manquant, avec une longueur -1 par rapport à la `listeN`, soit `N`.

```java
int[] listeSansNombreManquant = new int[N];
int j = 0;
for (int i = 0; i < listeN.length; i++) {
    if (i != indexNombreAleatoire) {
        listeSansNombreManquant[j] = listeN[i];
        j++;
     }
}
```
Après avoir initialisé le nouveau tableau, en bouclant à chaque index de la liste N, on compare si l'index i est différent de l'index du nombre manquant, si c'est le cas l'élément i est ajouté à au nouveau tableau à l'index j, qui est incrémenté avant de poursuivre.  \
A la fin le nouveau tableau aura tous les éléments de `listeN` sauf le nombre manquant.

Il suffit alors de faire la somme de tous les éléments de la `listeN` - la somme de tous les éléments de la `listeSansNombreManquant`

Avec la méthode `calculerSomme`:
```java
public static int calculerSomme(int[] tableau) {
    int somme = 0;
    for (int i = 0; i < tableau.length; i++) {
        somme += tableau[i];
    }
    return somme;
}

```
La méthode calcule la somme de tous les éléments du tableau en paramètre par l'intermédaire d'une boucle.  \
Ensuite une fois que la méthode est définie, il ne reste plus qu'à passer les deux tableaux en paramètres et d'en affecter les variables correspondantes:

```java
int sommeListeN = calculerSomme(listeN);
int sommeListeSansNombreManquant = calculerSomme(listeSansNombreManquant);
int resultatNombreManquant = sommeListeN - sommeListeSansNombreManquant;
```
Et d'afficher le résultat:
```java
System.out.println("Nombre manquant : " + resultatNombreManquant);
```

Avec les affichages de contrôles :
```console
Entre un nombre N :
 10
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
Nombre manquant : 2
Le tableau sans le nombre manquant : [1, 3, 4, 5, 6, 7, 8, 9, 10, 11]
Somme ListeN :66
Somme liste sans nombre manquant :64
Nombre manquant : 2
```

Avec les affichages de contrôle en commentaires (et modification du texte pour ressembler davantage à l'affichage de l'énoncé):
```console
Entre un nombre N :
10
[1, 3, 4, 5, 6, 7, 8, 9, 10, 11]
2
```



### Sources

- [Array.toString](https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Global_Objects/Array/toString)
- [Stackoverflow: randomly pick](https://stackoverflow.com/questions/8065532/how-to-randomly-pick-an-element-from-an-array)
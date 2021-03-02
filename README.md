# Cours3-localStorage
utilisation du SharedPreference pour sauvegarder localement + libray Gson + Design Pattern Singleton

- SharedPreference pour sauveagrder des donnees dasn un fichier local propre a l'application, se fichier reste en memoire meme si l'on ferme l'application, en la rouvrant on pourra retrouver les donnees.
- SharedPreference n'axepte que les primitifs
- Pour inserer un Objet ou une liste d'objet on utilise la library Gson qui permet de convertire un Objet en String et inversement
- Le String creer est formatte selon l'architecture JSON CAD sous forme de paires Key/Value (ci dessous un exemple de Json et de classe correspondante)
- La class SharedPref est construite selon le design pattern singleton qui ne permet de creer qu'une seul instance d'une class (constructor private + fonction public static getInstance qui creer une instance si l'instance est null et quoi qui l'arrive la retourne)

Exemple de Json pour la class User:

public class User{
private String name = "Patrick";
private int age = 25;
}

Json:

{
"name":"Patrick",
"age":25
}

une liste de User donnerait:

[
{
"name":"Patrick",
"age":25
},
{
"name":"Jean",
"age":26
}
]

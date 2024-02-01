# Générateur de Mots de Passe en Java

## 📖 Présentation du Projet

Ce projet est un générateur de mots de passe écrit en Java, conçu pour fournir des mots de passe sécurisés et personnalisables selon les besoins de l'utilisateur. Il permet de générer des mots de passe aléatoires avec la possibilité d'inclure des majuscules, des chiffres et des caractères spéciaux, ainsi que de définir la longueur souhaitée du mot de passe.

## 🚀 Utilisation

### Exécution du Programme

Pour exécuter le programme, assurez-vous que Java est installé sur votre machine. Téléchargez le fichier `GenerateurMDP.java`, compilez-le et exécutez-le depuis votre terminal :

```shell
javac GenerateurMDP.java
java GenerateurMDP
```

### Exemples d'Utilisation

Lorsque vous exécutez le programme, il vous demandera successivement si vous souhaitez inclure des majuscules, des chiffres et des caractères spéciaux dans votre mot de passe, puis la longueur souhaitée pour ce dernier.

```matematica
Voulez-vous que votre mot de passe contienne des majuscules ? (O/N): O
Voulez-vous que votre mot de passe contienne des numéros ? (O/N): O
Voulez-vous que votre mot de passe contienne des caractères spéciaux ? (O/N): O
La longueur minimale du mot de passe est : 4
Veuillez saisir la longueur du mot de passe : 8
Votre mot de passe généré est : aB3$eF7@
```

## 🛠 Concepts Utilisés

- **SecureRandom** : Pour une génération aléatoire sécurisée des caractères du mot de passe.
- **StringBuilder** : Pour construire efficacement le mot de passe avant de le convertir en chaîne.
- **Boucles et Conditions** : Pour lire les entrées de l'utilisateur et générer le mot de passe selon les critères spécifiés.
- **Modularité** : Les différentes fonctionnalités du programme sont encapsulées dans des méthodes distinctes pour une meilleure lisibilité et maintenabilité.

## 🎯 Objectif du Projet

Ce projet a été développé avec l'intention d'approfondir ma compréhension de la programmation Java, en particulier l'utilisation de concepts tels que la génération aléatoire sécurisée et la manipulation de chaînes. Il vise également à fournir un outil utile pouvant être intégré dans d'autres applications nécessitant la création de mots de passe sécurisés.

## 🔗 Intégration dans Vos Projets

Pour intégrer ce générateur de mots de passe dans vos propres projets Java, vous pouvez simplement copier la classe `GenerateurMDP` dans votre projet. Assurez-vous d'appeler la méthode `main` ou `generationMotDePasse` depuis votre code en passant les paramètres appropriés, en fonction des besoins spécifiques de votre application en matière de sécurité des mots de passe.

N'hésitez pas à contribuer au projet ou à me faire part de vos suggestions et commentaires !

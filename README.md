# Bienvenue à toi, nouveau joueur !

Ce jeu a été réalisé dans le cadre du projet d'informatique de fin de 1ère année par des étudiantes de l'INSA Lyon.
Vous trouverez le diagramme UML et le cahier des charges dans les fichiers.

## Le but du jeu

**Le principe**

Basé sur l'univers de Magic The Gathering, on a changé les règles (un peu, beaucoup, beaucoup trop) si bien que ça ne ressemble plus vraiment au jeu de base, mais le gameplay est palpitant et mémorable, à tel point que 1 joueur sur 42 a dit que sa vision du monde en a été changée depuis (en bien, évidement).

Tu commences la partie avec 20 PV (points de vie) et le but du jeu c'est de tuer ton adversaire avant qu'il ne te tue (PV<=0), en attaquant avec des créatures.

**Déroulement de la partie**

Tu disposes donc de créatures, dotées d'une force, d'un prix et d'un numéro de probablilité de réussite (qui servira pour la phase d'attaque, mais rassure toi cher aventurier, on va tout t'expliquer).

A chaque tour, tu gagnes du mana (c'est comme de l'argent) qui va te servir à payer les coûts de tes créatures, qui sont pour l'instant dans ta main. Tu gagnes un nombre de mana égal au numéro de ton tour (et donc 1, puis 2, puis 3...).
Le mana que tu n'auras pas dépensé est conservé pour le tour d'après. 

Dès lors que tu payes le coût en mana d'une créature, celle-ci se rend sur le champ de bataille. Tu peux payer autant de créatures que tu veux dans la mesure où tu dispose d'assez de mana.
Si tu ne veux pas payer de créature pour économiser ton mana, tu peux bien évidemment le faire.

Une fois que tu as lancé les créatures que tu veux, la phase d'attaque peut commencer.
Tu peux attaquer avec 3 crétures maximum, il faut bien choisir.
La réussite de l'attaque repose sur le hasard: pour chaque créature attaquante, un numéro aléatoire est généré. De savants calculs mathématiques font que, avec (rapelle toi) le numéro de probabilité de réussite de ta créature, l'attaque réussit ou non.
Plus la créature est petite, plus elle a de chances de réussir son attaque. 

3 cas sont possibles:
  - l'attaque réussit, et l'adversaire perd un nombre de PV égal à la foce de la créature
  - L'attaque échoue, mais il ne se passe rien
  - L'attaque est un véritable échec, et non seulement l'adversaire ne perd pas de PV, mais en plus cette créature d'auto-détruit.
  
Les créatures qui ont survécu sont conservées pour les tours suivant sur le champ de bataille.

## Avant de jouer !

**Git LFS, un outil pour gérer le fichier son volumineux**

Au lancement du jeu, de la musique véritablement épique se lance, pour vous accompagner dans votre aventure. Malheureusement c'est un fichier assez volumineux. On a donc utilisé un outil permettant de stocker les fichiers sur des serveurs, et de remplacer le chemin d'accès habituel par une ligne de texte.
Soit vous avez GitHub Desktop, et vous n'avez rien à faire, soit vous pouvez le télécharger ici: https://git-lfs.github.com/

**Notice pour lancer le jeu**

Une façon simple de lancer le jeu, c'est de passer par le terminal. 
Il faut se mettre à la racine du projet.
On peut le faire par exemple en passant pas GitHub Desktop, où il faut choisir le bon repository, et cliquer sur "open in command prompt"
![Avec Git Hub Desktop](https://i.imgur.com/mbvGbIn.png)

Un fois le terminal ouvert à la racine du projet, il suffit de taper la commande suivante: ```gradlew run --console=plain```

Si malgré tous nos efforts, le jeu s'obstinerait à ne pas vouloir se lancer, il faut abandonner l'interface graphique, en ne laissant que ```Partie nouvellePartie = new Partie();``` dans le main de la classe Rastley.java

Sur ce, nous vous souhaitons un très bon jeu !!

## Remerciements

Par ordre d'affection décroissante:
   - Raoul pour l'huile d'olive Puget
   - Rick Astley pour sa musique de qualité
   - Eddy Malou pour son savoir
   - Benoît magimel pour sa filmographie de qualité (on est fan)
   - The coconut man pour the second floor
   - Les Moulins de Don Quichotte, grâce à eux nous sommes désormais aptes à dépasser notre réflexion pavlovienne dénuée de sens et exprimer à voix haute nos interrogations

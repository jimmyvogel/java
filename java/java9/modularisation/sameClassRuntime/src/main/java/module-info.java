/*
DECLARATION:
module ${module-name} {
        requires ${module-name};
        exports ${package-name};
}

//Possible uses
requires ${module-name};   <-- ajoute une dépendance au module/projet, pas de compilation si dépendance introuvable.
exports ${package-name} to ${comma-separated-list-of-modules}; <-- donne accès qu'à certains modules
exports ${package-name};   <-- donne accès à certains packages du module aux modules externes.
opens ${package-name} to ${comma-separated-list-of-modules};
                                    <-- donne accès qu'à certains modules par réflexion(only)
opens ${package-name};              <-- donne accès à tous par réflexion(only)
requires transitive ${module-name}; <-- Java 9 permet grâce au mot clé transitive d’indiquer que par transitivité,
                                    <-- les utilisateurs d'un module vont pouvoir accéder aux modules enfants.
                                    <-- Cela permettra plus facilement des changements d’implémentation
                                    <-- et une facilité d’utilisation.
requires transitive ${module-name}; <-- Le mot clé requires static représente ce concept de dépendance optionnelle
                                    <-- un tel module est :
                                    <-- obligatoire à la compilation : une erreur de compilation sera levée
                                    <-- si le module n’est pas présent dans le module path à la compilation.
                                    <-- optionnel à l’exécution : le module ne sera pas pris en compte dans
                                    <-- la phase de sanity check au démarrage de l’application.
                                    <-- L’application pourra démarrer même si le module n’est pas présent.
provides ${package-name}.${service-class-file} with ${package-name}.${service-class-file-impl}
                                    <-- donne une implémentation d'une interface d'un autre module
                                    <-- pour pouvoir injecter des implémentations et les interchanger
                                    <-- rapidement sans utiliser de framework comme Spring.
*/
module modularisation.sameClassRuntime.com.jv.sameClass {
    opens com.jv.sameClass;
}
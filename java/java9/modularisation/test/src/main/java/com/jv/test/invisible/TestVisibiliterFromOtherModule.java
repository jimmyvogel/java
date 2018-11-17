package com.jv.test.invisible;

//import com.jv.moduleOne.visibility.invisible.Invisible;

import com.jv.visibility.visible.Visible;

public class TestVisibiliterFromOtherModule {

    public static void main(String args[]){
        Visible v = new Visible();

        //Invible car pas exporter par le moduleOne
        // Rmq : Attention si ce projet est en JAVA 8 il pourra accéder à la classe Invisible,
        // cependant il faudra supprimer le fichier module-info.java.
        //Invisible.action();
    }
}

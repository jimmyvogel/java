package com.jv.visibility.visible;

import com.jv.visibility.invisible.Invisible;

public class Visible {

    public Visible(){
        //Visible car dans le même module.
        Invisible invisible = new Invisible();
    }
}

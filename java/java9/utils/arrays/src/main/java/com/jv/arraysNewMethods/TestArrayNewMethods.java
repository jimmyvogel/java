package com.jv.arraysNewMethods;

import java.util.Arrays;

/**
 * Modification found on :
 * http://www.loicmathieu.fr/wordpress/informatique/les-nouveautes-de-java-9-pour-les-developeurs/
 */
public class TestArrayNewMethods {

    public static void main(String args[]){
        int[] tab = new int[]{ 1,2,3};
        int[] tab2 = new int[]{ 1,2,3};
        int[] tab3 = new int[]{ 1,2,3,4};
        System.out.println("Arrays.equals");
        System.out.println(Arrays.equals(tab, tab2));
        System.out.println("Arrays.compare");
        System.out.println(Arrays.compare(tab, tab2));
        System.out.println("Arrays.mismatch + position first mismatch");
        System.out.println(Arrays.mismatch(tab, tab3));
    }
}

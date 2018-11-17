package com.jv.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestNewUnmodifiableCollection {

    public static void main(String args[]){
        List<Integer> list = List.of(1, 2, 3);
        list.forEach(System.out::println);

        Set<Integer> set = Set.of(1, 2, 3);
        set.forEach(System.out::println);

        Map<Integer, String> map = Map.of(1, "a", 2, "b", 3, "c");
        set.forEach(System.out::println);

        System.out.println("Les listes crées avec of ne sont pas modifiables");
        try{
            list.set(0, 1);
        }catch(UnsupportedOperationException e){
            System.out.println(e.toString());
        }
        try{
            set.remove(1);
        }catch(UnsupportedOperationException e){
            System.out.println(e.toString());
        }
        try{
            map.put(4, "b");
        }catch(UnsupportedOperationException e){
            System.out.println(e.toString());
        }
    }
}

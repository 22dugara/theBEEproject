package com.company;

import java.util.*;

public class fieldGenerator {
    public static Hashtable<List<Integer>, Node> generateField(int h, boolean random){
        Hashtable<List<Integer>, Node> nodes = new Hashtable<List<Integer>, Node>();
        Random rand = new Random();
        for(int x = 0; x <= h; x++){
            for(int y = 0; y <= h; y++){
                for(int z = 0; z <= h; z++){
                    if(random) {
                        int randomNum = rand.nextInt((100) + 1) + 1;
                        if (randomNum < 30) {
                            nodes.put(Arrays.asList(x, y, z), new Node(x, y, z, true));
                        } else {
                            nodes.put(Arrays.asList(x, y, z), new Node(x, y, z, false));
                        }
                    }
                    else{
                        nodes.put(Arrays.asList(x, y, z), new Node(x, y, z, false));
                    }



                }
            }
        }
        return nodes;
    }
}

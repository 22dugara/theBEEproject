package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Hashtable<List<Integer>, Node> nodes = new Hashtable<List<Integer>, Node>();
        for(int x = 0; x < 15; x++){
            for(int y = 0; y < 15; y++){
                for(int z = 0; z < 15; z++){
                    if(z == 7 && x ==3){
                        nodes.put(Arrays.asList(x,y,z), new Node(x,y,z,true));
                    }
                    else{
                        nodes.put(Arrays.asList(x,y,z), new Node(x,y,z,false));
                    }

                }
            }
        }
        PathFinder test = new PathFinder(nodes, new Node(0,0,0, false), new Node[]{new Node(8,10,9,false)});
        ArrayList<Node> path = test.calcPath();

    }
}

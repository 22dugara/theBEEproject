package com.company;

import java.util.ArrayList;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {

        Hashtable<int[], Node> nodes = new Hashtable<int[], Node>();
        for(int x = 0; x < 5; x++){
            for(int y = 0; y < 5; y++){
                for(int z = 0; z < 5; z++){
                    nodes.put(new int[]{x,y,z}, new Node(x,y,z,false));
                }
            }
        }
        PathFinder test = new PathFinder(nodes, new Node(0,0,0, false), new Node[]{new Node(5,5,5,false)});
        ArrayList<Node> path = test.calcPath();

    }
}

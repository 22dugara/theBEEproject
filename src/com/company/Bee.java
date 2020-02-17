package com.company;

import java.util.Hashtable;
import java.util.List;

public class Bee {
    private PathFinder pathfinder;
    private int beeNumber;

    public PathFinder getPathfinder() {
        return pathfinder;
    }

    public void setPathfinder(PathFinder pathfinder) {
        this.pathfinder = pathfinder;
    }

    public int getBeeNumber() {
        return beeNumber;
    }

    public void setBeeNumber(int beeNumber) {
        this.beeNumber = beeNumber;
    }

    public Bee(Hashtable<List<Integer>, Node> nodes, Node start, Node[] endNodes, int n){
        pathfinder = new PathFinder(nodes, start, endNodes);
        this.beeNumber = n;

    }
    public String displayPath(){
        String response = "Bee " + beeNumber + " Started at" + pathfinder.getStart() + "\n";
        /*for(int x = 0; x < path.size(); x++){
           response += "\n Bee moved to " + (path.get(x).toString());
        }*/
        response += "Bee moved into " + pathfinder.getGoalNode() +" in " + pathfinder.getMoves() + " moves \n";

        return response;
    }
}

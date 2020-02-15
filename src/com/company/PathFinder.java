package com.company;
import java.util.ArrayList;
import java.util.Hashtable;

public class PathFinder {
    private Hashtable<int[], Node> Nodes;
    //Creates the set of nodes of which the path finding algorithim will use.
    // The Key is an int array representing coordinates. the Value is the Node object
    private ArrayList<Node> open;
    private ArrayList<Node> closed;
    private ArrayList<Node> path;
    private Node start;
    private Node[] endNodes;
    private Node goalNode;

    public PathFinder(Hashtable<int[], Node> nodes, Node start, Node[] endNodes) {
        Nodes = nodes;
        this.start = start;
        this.endNodes = endNodes;
        calcGoalNode();
    }

    public void calcGoalNode(){//Needs to be done
        //CalcGoalNode based on which out of the 15 is closest. This is a flawed way of selecting. But we can imporve this later
    }

    public ArrayList<Node> calcPath(){
        Node current;
        open.add(start);
        while(true){
        current = findLowestFcost(open);
        open.remove(current);
        closed.add(current);
        if(current.equals(goalNode)){
            break;
        }

        }
       return path;
    }

    public Node findLowestFcost(ArrayList<Node> list){
        CalcFcost(list);
        Node lowestFcost = list.get(0);
        for(int x = 1; x < list.size(); x++){
            if(lowestFcost.getfCost() > list.get(x).getfCost()){
                lowestFcost = list.get(x);
            }
            else if(lowestFcost.getfCost() == list.get(x).getfCost()){
                if(lowestFcost.getgCost() > list.get(x).getgCost()){
                    lowestFcost = list.get(x);
                }
            }
        }
        return lowestFcost;
    }

    public void CalcFcost(ArrayList<Node> list){
        for(int x = 0; x < list.size(); x++){
            list.get(x).setgCost(goalNode.distance(list.get(x)));
            list.get(x).sethCost(start.distance(list.get(x)));
            list.get(x).calcfCost();
        }

    }

    public ArrayList<Node> findNeighbors(Node c){//Needs to be done
        ArrayList<Node> neighbors = new ArrayList<Node>();
        return neighbors;
    }
}

package com.company;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class PathFinder {
    private Hashtable<List<Integer>, Node> Nodes;
    //Creates the set of nodes of which the path finding algorithim will use.
    // The Key is an int array representing coordinates. the Value is the Node object
    private ArrayList<Node> open = new ArrayList<Node>();
    private ArrayList<Node> closed = new ArrayList<Node>();
    private ArrayList<Node> path= new ArrayList<Node>();
    private Node start;
    private Node[] endNodes;
    private Node goalNode;

    public PathFinder(Hashtable<List<Integer>, Node> nodes, Node start, Node[] endNodes) {
        Nodes = nodes;
        this.start = start;
        this.start.sethCost(0);
        this.start.setfCost(0);
        this.endNodes = endNodes;
        calcGoalNode();
    }

    public void calcGoalNode(){//Needs to be done
        //CalcGoalNode based on which out of the 15 is closest. This is a flawed way of selecting. But we can imporve this later
        this.goalNode = endNodes[0];
        for(int x = 0; x < endNodes.length; x++){
            if(this.goalNode.distance(this.start) > endNodes[x].distance(this.start)){
                this.goalNode = endNodes[x];
            }
        }
    }

    public ArrayList<Node> calcPath(){
        System.out.println("Starting PathFinding");
        Node current;
        open.add(start);
        while(true){
        current = findLowestFcost(open);
        System.out.println("Current node is" + current);
        open.remove(current);
        closed.add(current);
        if(current.equals(goalNode)){
            System.out.println("Goal reached");
            break;
        }
        ArrayList<Node> neigbors = findNeighbors(current);
            //System.out.println(neigbors.get(0));
        for(int x = 0; x < neigbors.size(); x++){
           // System.out.println("Neigbor" + x + neigbors.get(x));
            if(neigbors.get(x).blocked == false && closed.contains(neigbors.get(x)) == false){
                if(neigbors.get(x).gethCost() > current.gethCost() + 1 || open.contains(neigbors.get(x)) == false){
                    neigbors.get(x).setParent(current);
                    CalcFcost(neigbors.get(x));
                    //System.out.println("here");
                    if(open.contains(neigbors.get(x)) == false){
                        //System.out.println("Open Set additon");
                        open.add(neigbors.get(x));
                    }
                }
            }
        }


        }

        while(true){

            path.add(0, current);
            current = current.getParent();
            if(current.equals(start)){
                break;
            }
        }
       return path;
    }

    public Node findLowestFcost(ArrayList<Node> list){
        Node lowestFcost = list.get(0);
        for(int x = 0; x < list.size(); x++){
           /* System.out.println(list.get(x));
            System.out.println(list.get(x).getfCost());
            System.out.println(list.get(x).getgCost());*/
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

    public void CalcFcost(Node s){

            s.setgCost(goalNode.distance(s));
            s.sethCost(s.getParent().gethCost() + s.getParent().distance(s));
            s.calcfCost();


    }

    public ArrayList<Node> findNeighbors(Node c){//Needs to be done
        //System.out.println("Updating Neigbors for" + c);
        ArrayList<Node> neighbors = new ArrayList<Node>();
        int[][] placeholder = new int[26][3];
        placeholder[0] = new int[]{1,1,1};
        placeholder[1] = new int[]{1,0,1};
        placeholder[2] = new int[]{1,0,0};
        placeholder[3] = new int[]{1,1,0};
        placeholder[4] = new int[]{1,1,-1};
        placeholder[5] = new int[]{1,0,-1};
        placeholder[6] = new int[]{1,-1,1};
        placeholder[7] = new int[]{1,-1,0};
        placeholder[8] = new int[]{1,-1,-1};
        placeholder[9] = new int[]{0,1,1};
        placeholder[10] = new int[]{0,0,1};
        placeholder[11] = new int[]{0,1,0};
        placeholder[12] = new int[]{0,1,-1};
        placeholder[13] = new int[]{0,0,-1};
        placeholder[14] = new int[]{0,-1,1};
        placeholder[15] = new int[]{0,-1,0};
        placeholder[16] = new int[]{0,-1,-1};
        placeholder[17] = new int[]{-1,1,1};
        placeholder[18] = new int[]{-1,0,1};
        placeholder[19] = new int[]{-1,0,0};
        placeholder[20] = new int[]{-1,1,0};
        placeholder[21] = new int[]{-1,1,-1};
        placeholder[22] = new int[]{-1,0,-1};
        placeholder[23] = new int[]{-1,-1,1};
        placeholder[24] = new int[]{-1,-1,0};
        placeholder[25] = new int[]{-1,-1,-1};


        for(int x = 0; x < 26; x++){


            if(Nodes.containsKey(Arrays.asList(c.getX()+ placeholder[x][0],c.getY()+ placeholder[x][1], c.getZ()+ placeholder[x][2]))) {
                //System.out.println("Adding Neihbor");
                //System.out.println(Nodes.get(Arrays.asList(c.getX()+ placeholder[x][0],c.getY()+ placeholder[x][1], c.getZ()+ placeholder[x][2])));
                neighbors.add(Nodes.get(Arrays.asList(c.getX()+ placeholder[x][0],c.getY()+ placeholder[x][1], c.getZ()+ placeholder[x][2])));
            }
        }
        return neighbors;
    }
    /*public boolean contains(int[] c){//needs to be tuned
        for (int[] key : Nodes.keySet()) {
            if(Arrays.equals(key,c)){
                return true;
            }
        }
        return false;
    }*/
}

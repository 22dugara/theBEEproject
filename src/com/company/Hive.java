package com.company;

import java.io.File;
import java.util.*;

public class Hive  {
    File info;
    private Node[] goalNodes = new Node[15];
    private Hashtable<List<Integer>, Node> field;
    private int cubeLength;
    private double amountObs = 0;
    private int hivenumber;
    private ArrayList<Bee> bees = new ArrayList<Bee>();
    private String Simresults = "";
    private double totalmoves = 0;


    public Hive(File info) throws java.io.FileNotFoundException {
        this.info = info;
        setInfo();

    }

    public void runSim(){
        for(Bee x : bees){
            x.getPathfinder().calcGoalNode();
            x.getPathfinder().calcPath();
            Simresults += x.displayPath();
            totalmoves += x.getPathfinder().getMoves();
        }
        Simresults += "\n Total Moves are " + this.totalmoves;
    }

    public String results(){
        return Simresults;
    }

    private void setInfo() throws java.io.FileNotFoundException{
        Scanner s = new Scanner(this.info);
        int count = 0;
        while(s.hasNextLine()){
            count++;

            String line = s.nextLine();
            String[] arr = line.split(",");
            if(count == 1){
                this.hivenumber = Integer.parseInt(arr[0]);
            }
            else if(count == 2){
                this.cubeLength = Integer.parseInt(arr[0]);
                field = fieldGenerator.generateField(this.cubeLength, false);
            }
            else if(count <= 17){
                goalNodes[count - 3] = (new Node(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), false));
            }
            else if(count <= 32){
                bees.add(new Bee(this.field, new Node(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), false), this.goalNodes, (count - 17)));
            }
            else if(count == 33){
                amountObs = Integer.parseInt(arr[0]);
            }
            else if(count<= (33 + amountObs)){
                field.get(Arrays.asList(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]))).setBlocked(false);
            }
        }

    }

    public File getInfo() {
        return info;
    }

    public void setInfo(File info) {
        this.info = info;
    }



    public int getCubeLength() {
        return cubeLength;
    }

    public void setCubeLength() {
        this.cubeLength = cubeLength;
    }

    public ArrayList<Bee> getBees() {
        return bees;
    }

    public void setBees(ArrayList<Bee> bees) {
        this.bees = bees;
    }


}

package com.company;

public class Node {
    private Node parent;
    private int x;
    private int y;
    private int z;
    public boolean blocked;
    public double gCost;
    // gCost is distance from end
    public double hCost;
    // hCost is distance from start node
    public double fCost;
    //hCost + gCost = fCost

    public Node(int x, int y, int z, boolean blocked) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.blocked = blocked;
    }

    public String toString(){
        String response = "Point " + this.x + ","+ this.y + ","+ this.z;
        return response;
    }

    public void calcfCost() {
        this.fCost = this.gCost + this.hCost;
    }

    public double distance(Node s){
        //return the distance between this node and Node S
        double distance = 0;
        distance = Math.abs(s.x - this.x) + Math.abs(s.y - this.y) + Math.abs(s.z - this.z);
        return distance;
    }

    public boolean equals(Node s){
        boolean equals;
        if(this.x == s.x && this.y == s.y && this.z == s.z){
            equals = true;
        }
        else{
            equals = false;
        }
        return equals;
    }
    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public double getgCost() {
        return gCost;
    }

    public void setgCost(double gCost) {
        this.gCost = gCost;
    }

    public double gethCost() {
        return hCost;
    }

    public void sethCost(double hCost) {
        this.hCost = hCost;
    }

    public double getfCost() {
        return fCost;
    }

    public void setfCost(double fCost) {
        this.fCost = fCost;
    }
}


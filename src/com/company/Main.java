package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Main  {

    public static void main(String[] args) throws java.io.FileNotFoundException {

    File Hive1info = new File("/Users/aaravdugar/Documents/theBEEproject/src/com/company/beesetup1.txt");
    Hive hive1 = new Hive(Hive1info);
    hive1.runSim();
    System.out.println(hive1.results());
    File Hive2info = new File("/Users/aaravdugar/Documents/theBEEproject/src/com/company/beesetup2.txt");
    Hive hive2 = new Hive(Hive2info);
    hive2.runSim();
    System.out.println(hive2.results());
    File Hive3info = new File("/Users/aaravdugar/Documents/theBEEproject/src/com/company/beesetup3.txt");
    Hive hive3 = new Hive(Hive3info);
    hive3.runSim();
    System.out.println(hive3.results());


    }
}

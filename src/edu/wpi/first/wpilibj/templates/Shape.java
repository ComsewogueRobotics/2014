/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

public class Shape{
    private String name;
    private double confidence;
    private int hotLoc;
    public Shape(double[] raw, String ShapesPath) throws StringIndexOutOfBoundsException, ArrayIndexOutOfBoundsException{
        try{
        hotLoc = ShapesPath.indexOf("Hot");
        System.out.println("Full ShapesPath: "+ShapesPath);
        System.out.println("index of 'Hot' = "+hotLoc);
        System.out.println("Substring of the index of Hot = "+ShapesPath.substring(hotLoc));
        System.out.println(raw[7]);
        if(raw[7]==hotLoc){
            name = "Hot";
        } else 
            name = "Cold";
        confidence = raw[0]/1000.0;
    }catch(Exception e){
        name = "Cold";
        confidence = raw[0]/1000.0;
    } 
    
    }
    public String getName(){
        return name;
    }
    public double getConf(){
        return confidence;
    }
}
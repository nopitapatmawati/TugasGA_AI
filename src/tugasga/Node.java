/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasga;

import static java.lang.Math.random;

/**
 *
 * @author ASUS
 */
public class Node {
    public int nama;
    public int x;
    public int y;

    public Node(int nama, int x, int y) {
        this.nama = nama;
        this.x = x;
        this.y = y;
    }

    public Node() {
        this.nama = (int)(Math.random()*16);  //Menggenerate nilai nama di dalam range 0-16
        this.x = (int)(Math.random()*100);      //Menggenerate nilai x dan y didalam range 0-100
        this.y = (int)(Math.random()*100);
    }    

    public int getNama() {
        return nama;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setNama(int nama) {
        this.nama = nama;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public double Jarak(Node node){
        int x2;
        int y2;
        double jarak;
        x2 = Math.abs(getX()-node.getX());                    //Mencari jarak x antar 2 node
//        System.out.println(getX());
//        System.out.println(node.getX());
        y2 = Math.abs(getY()- node.getY());                   //Mencari jarak y antar 2 node
//        System.out.println(getY());
//        System.out.println(node.getY());
        jarak = Math.sqrt((x2*x2)+(y2*y2));      //Mencari jarak dengan menggunakan rumus pythagoras
        return jarak;
    }
    
}

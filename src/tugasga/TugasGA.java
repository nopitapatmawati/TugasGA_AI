/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasga;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class TugasGA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Node node = new Node(0, 82, 76);
        DNA.addNode(node);
        Node node1 = new Node(1, 96, 44);
        DNA.addNode(node1);
        Node node2 = new Node(2, 50, 5);
        DNA.addNode(node2);
        Node node3 = new Node(3, 49, 8);
        DNA.addNode(node3);
        Node node4 = new Node(4, 13, 7);
        DNA.addNode(node4);
        Node node5 = new Node(5, 29, 89);
        DNA.addNode(node5);
        Node node6 = new Node(6, 58, 30);
        DNA.addNode(node6);
        Node node7 = new Node(7, 84, 39);
        DNA.addNode(node7);
        Node node8 = new Node(8, 14, 24);
        DNA.addNode(node8);
        Node node9 = new Node(9, 2, 39);
        DNA.addNode(node9);
        Node node10 = new Node(10, 3, 82);
        DNA.addNode(node10);
        Node node11 = new Node(11, 5, 10);
        DNA.addNode(node11);
        Node node12 = new Node(12, 98, 52);
        DNA.addNode(node12);
        Node node13 = new Node(13, 84, 25);
        DNA.addNode(node13);
        Node node14 = new Node(14, 61, 59);
        DNA.addNode(node14);
        Node node15 = new Node(15, 1, 65);
        DNA.addNode(node15);
        
        Populasi pop = new Populasi(100, true);
        int Gen = 72;
        int cadangan = 0;
        int tmp = pop.getFittest().getJarak();
//        System.out.println("Initial distance: " + pop.getFittest().getJarak());
        pop = GA.evolusiPopulasi(pop);
        for (int i = 0; i < Gen; i++) {
            pop = GA.evolusiPopulasi(pop);
            if(tmp>pop.getFittest().getJarak()){
                tmp=pop.getFittest().getJarak();
                cadangan=i;
            }
        }

        System.out.println("Generasi ke-"+cadangan);
        System.out.println("cost: " + tmp);
        System.out.println("cost: " + pop.getFittest().getJarak());
        System.out.println("Rute Terbaik:");
        System.out.println(pop.getFittest());
    }
    
}

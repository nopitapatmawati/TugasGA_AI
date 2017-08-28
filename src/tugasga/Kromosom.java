/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasga;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;
import java.util.Collections;

public class Kromosom{

    private ArrayList kromosoms = new ArrayList<Node>();
    private double fitness = 0;
    private int jarak = 0;
    
    public Kromosom(){
        for (int i = 0; i < DNA.jumNode(); i++) {
            kromosoms.add(null);
        }
    }
    
    public Kromosom(ArrayList kromosom){
        this.kromosoms = kromosom;
    }

    public void membuatKromosom() {
        for (int iNode = 0; iNode < DNA.jumNode(); iNode++) {
          setNode(iNode, DNA.getNode(iNode));
        }
        Collections.shuffle(kromosoms);             //Mengubah urutan Kromosom
    }

    public Node getNode(int Posisi) {           //Mereturn nilai Node yang ada pada array Kromosom
        return (Node)kromosoms.get(Posisi);
    }

    public void setNode(int Posisi, Node node) {    
        kromosoms.set(Posisi, node);
        fitness = 0;                                //Mengganti nilai di array Kromosom dengan isi node sesuai dengan indexnya
        jarak = 0;                                  //Mereset nilai fitness dan jarak node
    }
    
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getJarak();     //Mencari Minimasi
        }
        return fitness;
    }
    
    public int getJarak(){                  //Menghitung cost
        if (jarak == 0) {
            int jarakNode = 0;
            for (int iNode=0; iNode < KromosomSize(); iNode++) {
                Node NodeAwal = getNode(iNode);                     //Karna dibutuhkan 2 node untuk menghitung jarak dengan mencari selisih antara 2 node tersebut
                Node NodeAkhir;
                if(iNode+1 < KromosomSize()){
                    NodeAkhir = getNode(iNode+1);
                }
                else{
                    NodeAkhir = getNode(0);
                }
                jarakNode += NodeAwal.Jarak(NodeAkhir);
            }
            jarak = jarakNode;
        }
        return jarak;
    }

    public int KromosomSize() {
        return kromosoms.size();
    }
    
    public boolean containsKromosom(Node node){   //Mengecek apakah node sudah ada didalam array kromosom
        return kromosoms.contains(node); 
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < KromosomSize(); i++) {
            geneString += getNode(i).nama+"|";
        }
        return geneString;
    }
}

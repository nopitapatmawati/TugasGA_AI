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
public class DNA {
    private static ArrayList daftarNode = new ArrayList<Node>();
    
    public static void addNode(Node node){  //Menambahkan node kedalam daftar node
        daftarNode.add(node);
    }
    
    public static Node getNode(int j){             //Mengambil Node dari dalam daftar node berdasarkan index
        return (Node) daftarNode.get(j);
    }
    
    public static int jumNode(){
        return daftarNode.size();
    }
}

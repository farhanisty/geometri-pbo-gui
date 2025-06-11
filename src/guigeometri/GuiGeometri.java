/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guigeometri;

import geometri.benda.geometri.BangunDatar;
import geometri.benda.geometri.Benda;
import geometri.benda.geometri.persegi.Persegi;

/**
 *
 * @author farhannivta
 */
public class GuiGeometri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BangunDatar benda = new Persegi(12);
        System.out.println(benda.hitungKeliling());
    }
    
}

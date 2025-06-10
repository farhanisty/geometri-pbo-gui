/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri.benda.geometri;

import guigeometri.Inputable;

/**
 *
 * @author farhannivta
 */
public abstract class BangunDatar implements Benda, Inputable {
    public abstract double hitungLuas();
    public abstract double hitungKeliling();
    
    public abstract double getLuas();
    public abstract double getKeliling();
}

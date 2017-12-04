/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.main;

import com.java.tools.PrintReport;
import java.util.HashMap;

/**
 *
 * @author laravel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //simple report tanpa parameter
        new PrintReport("./report/pegawai.jasper", "", "");
        //simple report dengan satu parameter idpegawai di ireport
        new PrintReport("./report/pegawai.jasper", "idpegawai", "0001");
        //contoh report dengan banyak parameter
        HashMap map = new HashMap();
        map.put("idpegawai", "0001");
        map.put("idepartemen", "005");
        new PrintReport("./report/pegawaidept.jasper", map);
        
        //silahkan dipiluh salah satu diatas
        //buat folder report sejajar dengan SRC folder di root folder, sudah ane buatin
    }
    
}

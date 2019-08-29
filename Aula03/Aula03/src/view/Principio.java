package view;

import controller.ProController;

public class Principio {

    public static void main(String[] args) {
        ProController pc = new ProController();
//
        String so = pc.os();
//
        System.out.println(so);
//
        String processo = "tasklist /fo table";
//
//        pc.chamaProcesso(processo);
        pc.leProcesso(processo);
        
//        String param = "Notepad.exe";
        
//        pc.mataProcesso(param);
    }
}
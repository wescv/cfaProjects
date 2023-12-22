package org.cadeforall.ooptimus;

public class Main {
    public static void main(String[] args) {

    MyKeyBoard myKeyBoard = new MyKeyBoard();
    MapEdit layout = new MapEdit(myKeyBoard);
    myKeyBoard.setLayout(layout);
    myKeyBoard.handler();


    }
}
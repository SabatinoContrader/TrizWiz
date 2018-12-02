package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class MatrixMView implements View {

    private String param1;
    private String param2;

    public void showResults (Request request) {

    }


    public void showOptions () {
        System.out.println("-----Matrix----");
        System.out.println("Inserire ID Parametro da migliorare:");
        param1 = getInput();
        System.out.println("Inserire ID Parametro da non peggiorare:");
        param2 = getInput();
    }

    public void submit() {
        Request request = new Request();
        request.put("param1", param1);
        request.put("param2", param2);
        MainDispatcher.getInstance().callAction("Matrix", "doControl", request);
    }


    public String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    protected void send () {
    }


}

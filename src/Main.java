import modulos.ApiRequest;

import modulos.Menu;
import modulos.Moneda;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        ApiRequest apiRequest = new ApiRequest();
        HashMap<String, Float> monedas = apiRequest.getMoneda();


        Menu menu = new Menu();
        while (true){
            Scanner in = new Scanner(System.in);
            menu.MostrarMenu();


            int opcionMenu = in.nextInt();




            if (opcionMenu>7|| opcionMenu <0){
                System.out.println("\033[31m"+"-----------------opcion invalida, vuelva a intentarlo---------------------------"+"\u001B[0m");
            }else{

                System.out.println("Ingrese el valor que deseas convertir:");
                float valor = in.nextFloat();


                if (opcionMenu==1){
                    System.out.println("El valor "+valor+"[USD] corresponde al valor final de =>>>"+monedas.get("ARS")*valor+"[ARS]");
                    break;
                }else if(opcionMenu==2){

                    System.out.printf(String.format("El valor %.2f [ARS] corresponde al valor final de =>>> %.2f [USD] ",valor,valor/monedas.get("ARS")));
                    break;
                }else if(opcionMenu==3){

                    System.out.println(String.format("El valor %.2f [USD] corresponde al valor final de =>> %.2f [BRL]",valor,monedas.get("BRL")*valor));
                    break;
                }else if(opcionMenu==4){

                    System.out.printf(String.format("El valor %.2f [BRL] corresponde al valor final de =>>> %.2f [USD] ",valor,valor/monedas.get("BRL")));
                    break;
                }else if(opcionMenu==5){

                    System.out.println(String.format("El valor %.2f [USD] corresponde al valor final de =>> %.2f [COP]",monedas.get("COP")*valor));
                    break;
                }else if(opcionMenu==6){


                    System.out.printf(String.format("El valor %.2f [COP] corresponde al valor final de =>>> %.2f [USD] ",valor,valor/monedas.get("COP")));

                    break;
                } else if (opcionMenu==7) {
                    System.out.println("Fin del programa");
                    break;

                }
                }


        }





    }
}

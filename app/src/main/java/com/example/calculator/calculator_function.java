package com.example.calculator;

import java.lang.Math;

public class calculator_function {

    public static String tempic;
    public static boolean provjera;
    public static int brojac;

    public static String rezultat (String string){
        provjera = true;
        brojac = 0;
        tempic = string;


        while (provjera){
            if(tempic.charAt(brojac) == '+'){
                Provjera(brojac, '+');
            }
            else if(tempic.charAt(brojac) == '*'){
                Provjera(brojac, '*');
            }
            else if(tempic.charAt(brojac) == '/'){
                Provjera(brojac, '/');
            }
            else if(tempic.charAt(brojac) == '^'){
                Provjera(brojac, '^');
            }
            else if(tempic.charAt(brojac) == '-'){
                if(brojac == 0){
                }else{
                    Provjera(brojac, '-');
                }
            }
            brojac++;
        }

        return tempic;

    }

    private static boolean isNumeric(char c){
        if((c <= '9' && c >= '0') || c == '.')
            return true;

        return false;
    }

    public static void Provjera(int i, char znak){
        String lijeviBroj = "";
        String lijeviBroj_original = "";
        String pamtim_broj = "";
        String novi_tempic = "";

        String desniBroj = "";
        String original_tempic = tempic;

        int tempBroj = 0;
        int tempBroj2 = 0;
        int temp3 = 1;
        int temp_index = 0;

        boolean provjera_desnog_predzanka = false;
        int index_predznaka = 0;


            //lijeva strana                                     //POSTAVITI DRUGACIJE LIJEVU STRANU KAKO BI OPTIMIZOVAO FLOW
            for(int x = 0; x<i; x++){
                if(isNumeric(tempic.charAt(x)))
                    lijeviBroj = lijeviBroj + tempic.charAt(x);
                else{
                    if(tempic.charAt(0) == '-'){
                        lijeviBroj_original = lijeviBroj;
                        lijeviBroj = "-" + lijeviBroj_original;
                    }else
                        break;
                }

            }

            //desna strana

            for(int x = i + 1; x<tempic.length(); x++){
                if(isNumeric(tempic.charAt(x))) {
                    desniBroj = desniBroj + tempic.charAt(x);
                }
                else{
                    if(tempic.charAt(i + 1) == '-'){
                        desniBroj = "-";
                    }else{
                        temp_index = x;
                        break;
                    }
                }
            }


            tempBroj = Integer.parseInt(lijeviBroj);
            tempBroj2 = Integer.parseInt(desniBroj);

            //DODAVANJE PO ZNAKU
            if(znak == '+'){
                temp3 = tempBroj + tempBroj2;
            }
            else if(znak == '*'){
                temp3 = tempBroj * tempBroj2;
            }
            else if(znak == '*'){
                temp3 = tempBroj * tempBroj2;
            }
            else if(znak == '/'){
                temp3 = tempBroj / tempBroj2;
            }
            else if(znak == '-'){
                temp3 = tempBroj - tempBroj2;
            }
            else if(znak == '^'){
                temp3 = (int) Math.pow((double) tempBroj, (double) tempBroj2);
            }

            novi_tempic = ((Integer)temp3).toString();
            if(temp_index > 0){
                tempic = novi_tempic + original_tempic.substring(temp_index);
                brojac = 0;
            }else{
                tempic = novi_tempic;
                provjera = false;
            }



            //brojac = 0;


        }


}

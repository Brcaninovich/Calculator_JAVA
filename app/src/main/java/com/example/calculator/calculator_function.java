package com.example.calculator;

import android.util.Log;

import java.lang.Math;

public class calculator_function {

    public static String tempic;
    public static boolean provjera;
    public static int brojac;

    public static String rezultat (String string){
        provjera = true;
        brojac = 0;
        tempic = string;

        for(int i = 0; i < string.length(); i++){
            if(isNumeric(string.charAt(i))){
                brojac++;
            }
        }
        if (brojac == string.length()){
            provjera=false;
        }
        brojac = 0;
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

        double tempBroj = 0;
        double tempBroj2 = 0;
        double temp3 = 1;
        int temp_index = 0;

        //PROVJERA DA LI JE ZNAK SAM BUG FIX?
        boolean sam_znak_desno = false;
        if(i == tempic.length() - 1){
            sam_znak_desno = true;
        }


        boolean provjera_desnog_predzanka = false;
        boolean nema_dalje_indexa = false;
        int index_predznaka = 0;
        int index_pocetka = 0;
        String poseban_izraz = "";
        String izraz_random = "";
        //PROVJERA PREDNOSTI
        for(int x = i + 1; x < tempic.length(); x++){
            if (tempic.charAt(x) == '*' || tempic.charAt(x) == '/'){
                index_predznaka = x;
                provjera_desnog_predzanka = true;
                break;
            }
        }
        if(provjera_desnog_predzanka){
            //Log.d("PORUKA", "INDEX PREDZNAKA = " + ((Integer)index_predznaka).toString());
            //provjera desnog predznaka za substitute
            for(int x = index_predznaka + 1; x<tempic.length(); x++){
                if(isNumeric(tempic.charAt(x))) {
                    if(x == tempic.length() - 1){
                        temp_index = x;
                        nema_dalje_indexa = true;
                        break;
                    }
                }
                else{
                    if(tempic.charAt(index_predznaka + 1) == '-'){
                        continue;
                    }else{
                        temp_index = x;     //index predznaka za substitute
                        break;
                    }
                }
            }
            for(int x = index_predznaka - 1; x > 0; x--){
                if(isNumeric(tempic.charAt(x))){
                        continue;
                }else{
                    index_pocetka = x;
                    break;
                }
            }

            //Log.d("PORUKA", "Index pocetka: " + ((Integer)index_pocetka).toString());


            ///kraj provjere ako ima imat ce temp_index
                if(nema_dalje_indexa)
                    poseban_izraz = tempic.substring(index_pocetka + 1, temp_index + 1);
                else
                    poseban_izraz = tempic.substring(index_pocetka + 1, temp_index);
                //Log.d("PORUKA", "POSEBAN IZRAZ " + poseban_izraz);
                novi_tempic = rezultat(poseban_izraz);
                izraz_random = original_tempic.substring(0, index_pocetka + 1);
                //Log.d("PORUKA", "Sredina " + novi_tempic);
                if(nema_dalje_indexa)
                    tempic = izraz_random + novi_tempic + original_tempic.substring(temp_index + 1);
                else
                    tempic = izraz_random + novi_tempic + original_tempic.substring(temp_index);

                provjera = true;
                brojac = 0;
            }
            else
            {
            //lijeva strana
                    for (int x = 0; x < i; x++) {
                        if (isNumeric(tempic.charAt(x)))
                            lijeviBroj = lijeviBroj + tempic.charAt(x);
                        else {
                            if (tempic.charAt(0) == '-') {
                                lijeviBroj_original = lijeviBroj;
                                lijeviBroj = "-" + lijeviBroj_original;
                            } else
                                break;
                        }

                    }
                    }

            //desna strana
            if(!sam_znak_desno){
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
            }else{
                if(znak == '*' || znak == '/' || znak == '^'){
                    desniBroj = "1";
                }
                else {
                    desniBroj = "0";
                }

            }


            tempBroj = Double.parseDouble(lijeviBroj);
            //tempBroj = Integer.parseInt(lijeviBroj);
            tempBroj2 = Double.parseDouble(desniBroj);

            //DODAVANJE PO ZNAKU
            if(znak == '+'){
                temp3 = tempBroj + tempBroj2;
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
                temp3 = Math.pow( tempBroj, tempBroj2);
            }

            novi_tempic = ((Double)temp3).toString();
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


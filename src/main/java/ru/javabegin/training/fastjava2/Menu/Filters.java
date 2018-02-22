package ru.javabegin.training.fastjava2.Menu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filters {

      public static boolean filterForPos(String text){
          final boolean  result;
        Pattern p = Pattern.compile("^(true)|(false)$");
        Matcher m =p.matcher(text);
        if(m.find()==true){
            result = false;
        }else  result = true;
        return result;
    }

    public static boolean filterForGender(String text){
        final boolean  result;
        Pattern p = Pattern.compile("^(man)|(girl)$");
        Matcher m = p.matcher(text);
        if (m.find() == true){
            result = false;
        }else  result = true;
        return result;
    }


    public static boolean filterForname(String text){ //great complete
        final boolean  result;
       Pattern p= Pattern.compile("^([a-zA-Z])+$");
       Matcher m = p.matcher(text);
       if(m.find()==true){
           result = false;
       } else  result = true ;
       return  result;
    }
    public static boolean date(String text){ //great complete
         final boolean  result;
          Pattern p= Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((19|20)\\d\\d)$");
          Matcher m = p.matcher(text);
          if (m.find()==true){
              result = false;
          }else result = true ;
          return result;
    }
    public static boolean number(String text){ //great complete
        final boolean  result;
          Pattern p = Pattern.compile("^([2][459]|[3][3]|[4][4])([0-9][0-9][0-9][0-9][0-9][0-9][0-9])+$");
          Matcher m = p.matcher(text);
          if(m.find()==true){
              result = false;
          }else result = true ;
          return result;
    }

    public static boolean course(String text){
          final boolean  result;
          Pattern p = Pattern.compile("^[0-6]$");
          Matcher m = p.matcher(text);
          if (m.find()==true){
              result = false;
          }else  result = true ;
          return result;
    }
}

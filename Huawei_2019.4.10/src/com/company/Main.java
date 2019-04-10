package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner=new Scanner(System.in);
        String preString=scanner.nextLine();
        ArrayList<Integer> qiankuohao=new ArrayList<>();
        do{
            int houkuohao=0;
            for(int i=0;i<preString.length();i++){
               if(preString.charAt(i)=='{'||
                       preString.charAt(i)=='['||
                       preString.charAt(i)=='(')
               {
                   qiankuohao.add(i);
               }
                if(preString.charAt(i)=='}'||
                        preString.charAt(i)==']'||
                        preString.charAt(i)==')')
                {
                    qiankuohao.add(i);
                    if(houkuohao==1){
                        break;
                    }
                    else {
                        houkuohao+=1;
                    }
                }
            }
            if(qiankuohao.size()>2){
                int kuohao1=qiankuohao.get((qiankuohao.size()-4));
                int kuohao2=qiankuohao.get((qiankuohao.size()-3));
                int kuohao3=qiankuohao.get((qiankuohao.size()-2));
                int kuohao4=qiankuohao.get((qiankuohao.size()-1));
                String firstString=preString.substring(0,kuohao1);
                String secondString=preString.substring(kuohao1+1,kuohao2);
                String thirdString=preString.substring(kuohao2+1,kuohao3);
                String forthString=preString.substring(kuohao3+1,kuohao4);
                String fifthString=preString.substring(kuohao4+1);
                String beishu="";
                for (int i=0;i<secondString.length();i++){
                    if((secondString.charAt(i)>=48)&&(secondString.charAt(i)<=57)){
                        beishu+=secondString.charAt(i);
                    }
                }
                int beishuInt=Integer.parseInt(beishu);
                String tempString="";
                for(int i=0;i<beishuInt;i++){
                    tempString+=thirdString;
                }
                secondString=secondString.substring(0,secondString.length()-beishu.length());
                tempString=reverselString(forthString)+tempString+reverselString(secondString);
                preString=firstString+'['+tempString+']'+fifthString;
                qiankuohao.clear();
                houkuohao=0;
            }else {
                int kuohao1=qiankuohao.get((qiankuohao.size()-2));
                int kuohao2=qiankuohao.get((qiankuohao.size()-1));
                String firstString=preString.substring(0,kuohao1);
                String secondString=preString.substring(kuohao1+1,kuohao2);
                String thirdString=preString.substring(kuohao2+1);
                String beishu="";
                for (int i=0;i<firstString.length();i++){
                    if((firstString.charAt(i)>='0')&&(firstString.charAt(i)<='9')){
                        beishu+=firstString.charAt(i);
                    }
                }
                int beishuInt=Integer.parseInt(beishu);
                String tempString="";
                for(int i=0;i<beishuInt;i++){
                    tempString+=secondString;
                }
                firstString=firstString.substring(0,firstString.length()-beishu.length());
                preString=reverselString(thirdString)+tempString+reverselString(firstString);
                qiankuohao.clear();
                houkuohao=0;
            }

        }
        while (preString.contains("{")||preString.contains("}")||
                preString.contains("[")||preString.contains("]")||
                preString.contains("(")||preString.contains(")"));
        System.out.print(preString);
    }
    public static String reverselString(String str){
        return new StringBuffer(str).reverse().toString();
    }
}

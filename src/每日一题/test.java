package 每日一题;

import java.util.*;

class test{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        List<Integer> s=new LinkedList<>();
        for (int i=0;i<n;i++){
            s.add(sc.nextInt());
        }
        long r=0;
        if (a>=b/2.0 && a>=c/3.0){
            System.out.println(n*a);
        }else if (b/2.0>=a && b+a>=c){
            //优先二消
            boolean f=true;
            while (f){
                for (int i=0;i<s.size()-1;i++){
                    if (s.get(i)==s.get(i+1)){
                        r+=b;
                        s.remove(i);
                        s.remove(i);
                        break;
                    }
                }
                if (c/3.0>a){
                    while (f){
                        for (int i=0;i<s.size()-2;i++){
                            if (s.get(i)==s.get(i+1) && s.get(i+1)==s.get(i+2)){
                                r+=c;
                                s.remove(i);
                                s.remove(i);
                                s.remove(i);
                                break;
                            }
                        }
                        f=false;
                    }
                    r+=a*s.size();
                    System.out.println(r);
                }else {
                    System.out.println(r+=a*s.size());
                    return;
                }
                f=false;
            }
            f=true;
        }else{
            //三消
            boolean f=true;
            while (f){
                for (int i=0;i<s.size()-2;i++){
                    if (s.get(i)==s.get(i+1) && s.get(i+1)==s.get(i+2)){
                        r+=c;
                        s.remove(i);
                        s.remove(i);
                        s.remove(i);
                        break;
                    }
                }
                f=false;
            }
            f=true;
            if (b/2.0>a){
                while (f){
                    for (int i=0;i<s.size()-1;i++){
                        if (s.get(i)==s.get(i+1)){
                            r+=b;
                            s.remove(i);
                            s.remove(i);
                            break;
                        }
                    }
                    f=false;
                }
                r+=a*s.size();
                System.out.println(r);
            }else {
                System.out.println(r+=a*s.size());
            }
        }
    }
}
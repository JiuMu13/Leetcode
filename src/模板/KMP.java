package 模板;

public class KMP {
    private boolean kmp(String p,String c){
        int  fp=0,fc=0;
        char[] cp=p.toCharArray(),cc=c.toCharArray();
        int lp=cp.length,lc=cc.length;
        int[] next=new int[lc];
        getNext(c,next);
        while (fp<lp && fc<lc){
            if (cp[fp]==cc[fc]){
                fp++;
                fc++;
            } else if (fc==0) {
                fp++;
            }else {
                fc=next[fc];
            }
        }
        return fc == lc;
    }
    private void getNext(String s,int[] next){
        if (next.length<2) {
            next[0] = -1;
            return;
        }
        if (next.length<3){
            next[0]=-1;
            next[1]=0;
            return;
        }
        int fs=2,cn=0,ls=s.length();
        char[] cs=s.toCharArray();
        next[0]=-1;
        next[1]=0;
        while (fs<ls){
            if (cs[fs-1]==cs[cn]){
                next[fs++]=++cn;
            } else if (cn == 0) {
                next[fs++]=0;
            }else {
                cn=next[cn];
            }
        }
    }
}

package 每日一题;

//字典树实现模版
class Trie {
    int[][] tree;
    int[] cnt;
    int id;
    public Trie() {
        tree=new int[2000*26][26];
        cnt=new int[2000*26];
        id=0;
    }

    public void insert(String word) {
        char[] cs=word.toCharArray();
        int f=0;
        for (int i=0;i<cs.length;i++){
            int t=cs[i]-'a';
            if (tree[f][t]!=0){
                f=tree[f][t];
            }else {
                tree[f][t]=++id;
                f=id;
            }
        }
        cnt[f]++;
    }

    public boolean search(String word) {
        char[] cs=word.toCharArray();
        int f=0;
        for (int i=0;i<cs.length;i++){
            int t=cs[i]-'a';
            if (tree[f][t]!=0)
                f=tree[f][t];
            else
                return false;
        }
        if (cnt[f]!=0)
            return true;
        else
            return false;
    }

    public boolean startsWith(String prefix) {
        char[] cs=prefix.toCharArray();
        int f=0;
        for (int i=0;i<cs.length;i++){
            int t=cs[i]-'a';
            if (tree[f][t]!=0)
                f=tree[f][t];
            else
                return false;
        }
        return true;
    }
}
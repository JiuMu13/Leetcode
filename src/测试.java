import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class 测试{
    public static void main(String[] args) {
        List<String> l=new ArrayList<>();
        l.add("one.two@three");
        System.out.println(splitWordsBySeparator(l,'.'));
    }
    public class Io{
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        public int nextInt(){
            try {
                st.nextToken();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return (int)st.nval;
        }
    }
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> r=new ArrayList<>();
        String sep;
        if (separator=='.' || separator=='|' || separator=='$')
            sep=String.format("\\%c",separator);
        else
            sep=""+separator;
        for(String s:words){
            String[] ss=s.split(sep);
            for(String e:ss)
                r.add(e);
        }
        return r;
    }
}

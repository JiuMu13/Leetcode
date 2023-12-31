import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
class 测试{
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(32));

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
}

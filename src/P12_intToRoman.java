import static org.junit.Assert.*;
import org.junit.Test;

public class P12_intToRoman {
    /**
     * Using StringBuilder
     * @param x
     * @return
     */
    public String intToRoman(int x) {
        if (x < 1 || x >3999) {
            return "";
        }
        int M = x / 1000;
        x = x - M * 1000;

        int D = x / 500;
        x = x - D * 500;

        int C = x / 100;
        x = x - C * 100;

        int L = x / 50;
        x = x - L * 50;

        int X = x / 10;
        x = x - X * 10;

        int V = x / 5;
        x = x - V * 5;

        int I = x;

        StringBuilder str = new StringBuilder();
        for (int m = 0; m < M; m++) {
            str.append('M');
        }

        if (D == 1 && C == 4) {
            str.append("CM");
        } else if(C == 4) {
            str.append("CD");
        } else {
            for (int d = 0; d < D; d++) {
                str.append('D');
            }
            for (int c = 0; c < C; c++) {
                str.append('C');
            }
        }

        if (L == 1 && X ==4) {
            str.append("XC");
        } else if(X == 4) {
            str.append("XL");
        } else {
            for (int l = 0; l < L; l++){
                str.append('L');
            }
            for (int XX = 0; XX < X; XX++){
                str.append('X');
            }
        }

        if (V == 1 && I == 4) {
            str.append("IX");
        } else if(I == 4) {
            str.append("IV");
        } else {
            for (int v = 0; v < V; v++) {
                str.append("V");
            }
            for (int i = 0; i < I; i++) {
                str.append("I");
            }
        }
        return str.toString();
    }

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intTorRoman_method2(int x) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && x >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= x) {
                x -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }


    @Test
    public void test(){
        int test = 2349;
        assertEquals("MMCCCXLIX",intToRoman(test));
        assertEquals("MMCCCXLIX",intTorRoman_method2(test));

    }
}

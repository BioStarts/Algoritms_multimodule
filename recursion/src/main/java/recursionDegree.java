public class recursionDegree {
    public static void main(String[] args) {
        int x = 2;
        int y = 3;

        System.out.println(degreeOf(x, y));

    }

    public static double degreeOf(double num, int deg) {

        boolean z;

        if (deg == 1) {
            return num;
        }
        if ((deg < 0) & (num != 0)) {
            num = 1 / num;
            deg = Math.abs(deg);
            return degreeOf(num, deg);
        }
        if (deg % 2 == 0) {
            if (z = true) {
                num = num * Math.sqrt(num);
                deg = deg/2;
                z = false;
                return degreeOf(num, deg);
            }
            num = num * num;
            deg = deg / 2;
            return degreeOf(num, deg);
        } else {
            num = num * num;
            deg--;
            z = true;
            return degreeOf(num, deg);
        }

        /*
        while ( deg != 1) {
            num = num *
        }*/
    }
}

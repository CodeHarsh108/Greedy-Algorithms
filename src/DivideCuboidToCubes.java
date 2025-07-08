import java.util.Scanner;

public class DivideCuboidToCubes {

    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static void cube(int l, int b, int h){
        int side = gcd(l, gcd(b, h));
        int num = (l / side) * (b / side) * (h / side);
        System.out.println("Side of cube : " + side);
        System.out.println("Number of cubes : " + num);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of cuboid: ");
        int l = scanner.nextInt();

        System.out.print("Enter breadth of cuboid: ");
        int b = scanner.nextInt();

        System.out.print("Enter height of cuboid: ");
        int h = scanner.nextInt();

        cube(l, b, h);

        scanner.close();
    }
}

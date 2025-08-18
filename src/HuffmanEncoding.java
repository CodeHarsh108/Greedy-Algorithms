import java.util.*;

public class HuffmanEncoding {

    class Node implements Comparable<Node> {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
            this.left = null;
            this.right = null;
        }

        public int compareTo(Node other){
            return this.freq - other.freq;
        }
    }

    class Pair {
        int freq;
        String code;
        Pair(int freq, String code){
            this.freq = freq;
            this.code = code;
        }
    }

    public ArrayList<String> huffmanCodes(String S, int f[], int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            pq.add(new Node(S.charAt(i), f[i]));
        }

        while(pq.size() > 1){
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('\0', left.freq + right.freq);
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }

        Node root = pq.peek();

        HashMap<Character, String> map = new HashMap<>();
        generateCodes(root, "", map);

        ArrayList<Pair> temp = new ArrayList<>();
        for(int i = 0; i < N; i++){
            temp.add(new Pair(f[i], map.get(S.charAt(i))));
        }

        Collections.sort(temp, (a,b) -> a.freq - b.freq);

        ArrayList<String> result = new ArrayList<>();
        for(Pair p : temp){
            result.add(p.code);
        }

        return result;
    }

    private void generateCodes(Node node, String code, HashMap<Character, String> map){
        if(node == null) return;
        if(node.left == null && node.right == null){
            map.put(node.ch, code);
            return;
        }
        generateCodes(node.left, code + "0", map);
        generateCodes(node.right, code + "1", map);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HuffmanEncoding he = new HuffmanEncoding();

        System.out.print("Enter number of characters: ");
        int N = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter characters without spaces: ");
        String S = sc.nextLine();

        int[] f = new int[N];
        System.out.println("Enter frequencies of each character separated by space:");
        for(int i = 0; i < N; i++){
            f[i] = sc.nextInt();
        }

        ArrayList<String> codes = he.huffmanCodes(S, f, N);

        System.out.println("\nHuffman Codes (sorted by frequency ascending):");
        for(int i = 0; i < N; i++){
            System.out.println(S.charAt(i) + ": " + codes.get(i));
        }

        sc.close();
    }
}

import java.util.LinkedHashMap;
import java.util.Map;

class LeastRecentlyUsed<K, V> extends LinkedHashMap<K ,V> {
    private final int capacity;

    LeastRecentlyUsed(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
        return size() > capacity;
    }

    public static void main(String[] args) {
        LeastRecentlyUsed<Integer, String> lru = new LeastRecentlyUsed<>(3);

        lru.put(1, "A");
        lru.put(2, "B");
        lru.put(3, "C");
        System.out.println(lru);

        lru.get(1);
        lru.put(4, "D");
        System.out.println(lru);
    }

}

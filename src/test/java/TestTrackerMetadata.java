
public class TestTrackerMetadata {

    public static void main(String[] args) {
        String a = null;
        if ("a".equalsIgnoreCase(a)) {
            System.out.println("a");
        }



    }


    public static long key(int x, int z) {
        return ((long) x & 0xFFFF) << 32 | ((long) z & 0xFFFF);
    }

}

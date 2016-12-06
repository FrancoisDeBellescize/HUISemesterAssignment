package sample;

public class Vector3 {
    int x;
    int y;
    int z;

    Vector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    boolean compare(Vector3 other) {
        if (x == other.x && y == other.y && z == other.z)
            return true;
        return false;
    }

    boolean compare(int x, int y, int z) {
        if (this.x == x && this.y == y && this.z == z)
            return true;
        return false;
    }
}

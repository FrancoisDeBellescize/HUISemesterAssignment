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

    @Override
    public boolean equals(Object other) {
        Vector3 tmp = (Vector3) other;
        if (x == tmp.x && y == tmp.y && z == tmp.z)
            return true;
        return false;
    }


    @Override
    public int hashCode() {
        return (x * 10 + y * 20 + z * 30);
    }
}

import java.util.Objects;

public class MaterialData {

    private int id;
    private byte data;

    public MaterialData(int id, int data) {
        this.id = id;
        this.data = (byte) data;
    }

    public int getId() {
        return id;
    }

    public byte getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialData that = (MaterialData) o;
        return id == that.id &&
                data == that.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data);
    }
}


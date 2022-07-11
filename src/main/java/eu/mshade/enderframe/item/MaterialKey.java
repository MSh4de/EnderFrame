package eu.mshade.enderframe.item;

import java.util.Objects;

public interface MaterialKey {

    int getId();

    int getData();

    static MaterialKey from(int id, int data){
        return new MaterialData(id, data);
    }

    class MaterialData implements MaterialKey{

        private int id;
        private int data;

        public MaterialData(int id, int data) {
            this.id = id;
            this.data = data;
        }

        @Override
        public int getId() {
            return this.id;
        }

        @Override
        public int getData() {
            return this.data;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (!(o instanceof MaterialKey)) return false;
            MaterialKey materialKey = (MaterialKey) o;
            return id == materialKey.getId() && data == materialKey.getData();
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, data);
        }

        @Override
        public String toString() {
            return "MaterialData{" +
                    "id=" + id +
                    ", data=" + data +
                    '}';
        }
    }

}

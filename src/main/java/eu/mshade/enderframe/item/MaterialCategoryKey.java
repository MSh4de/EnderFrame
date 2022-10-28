package eu.mshade.enderframe.item;

import java.util.Objects;

public interface MaterialCategoryKey {

    String getName();


    static MaterialCategoryKey from(String name){
        return new DefaultMaterialCategoryKey(name);
    }

     class DefaultMaterialCategoryKey implements MaterialCategoryKey {

        private final String name;
        public DefaultMaterialCategoryKey(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if(!(o instanceof MaterialCategoryKey)) return false;
            MaterialCategoryKey materialCategoryKey = (MaterialCategoryKey) o;
            return Objects.equals(name, materialCategoryKey.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "DefaultMaterialCategoryKey{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}

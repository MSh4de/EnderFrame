package eu.mshade.enderframe.item;

import java.util.Objects;

public interface MaterialTagKey {

    String getName();


    static MaterialTagKey from(String name){
        return new DefaultMaterialTagKey(name);
    }

     class DefaultMaterialTagKey implements MaterialTagKey {

        private final String name;
        public DefaultMaterialTagKey(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if(!(o instanceof MaterialTagKey materialTagKey)) return false;
            return Objects.equals(name, materialTagKey.getName());
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

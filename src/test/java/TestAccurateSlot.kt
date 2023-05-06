import eu.mshade.enderframe.inventory.PlayerInventory

fun main() {
    for (i in 0..45) {
        println("$i -> ${PlayerInventory.accurateSlot(i)}")
    }
}
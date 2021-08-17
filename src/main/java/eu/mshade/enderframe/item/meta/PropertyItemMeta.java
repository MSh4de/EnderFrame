package eu.mshade.enderframe.item.meta;

import eu.mshade.enderframe.item.Enchantment;
import eu.mshade.enderframe.item.ItemFlag;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PropertyItemMeta {

    /**
     * Checks for existence of a display name.
     *
     * @return true if this has a display name
     */
    boolean hasDisplayName();

    /**
     * Gets the display name that is set.
     * <p>
     * Plugins should check that hasDisplayName() returns <code>true</code>
     * before calling this method.
     *
     * @return the display name that is set
     */
    String getDisplayName();

    /**
     * Sets the display name.
     *
     * @param name the name to set
     */
    void setDisplayName(String name);

    /**
     * Checks for existence of lore.
     *
     * @return true if this has lore
     */
    boolean hasLore();

    /**
     * Gets the lore that is set.
     * <p>
     * Plugins should check if hasLore() returns <code>true</code> before
     * calling this method.
     *
     * @return a list of lore that is set
     */
    List<String> getLore();

    /**
     * Sets the lore for this item.
     * Removes lore when given null.
     *
     * @param lore the lore that will be set
     */
    void setLore(String... lore);

    /**
     * Checks for the existence of any enchantments.
     *
     * @return true if an enchantment exists on this meta
     */
    boolean hasEnchants();

    /**
     * Checks for existence of the specified enchantment.
     *
     * @param enchantment enchantment to check
     * @return true if this enchantment exists for this meta
     */
    boolean hasEnchantment(Enchantment enchantment);

    /**
     * Checks for the level of the specified enchantment.
     *
     * @param enchantment enchantment to check
     * @return The level that the specified enchantment has, or 0 if none
     */
    int getEnchantmentLevel(Enchantment enchantment);

    /**
     * Returns a copy the enchantments in this ItemMeta. <br>
     * Returns an empty map if none.
     *
     * @return An immutable copy of the enchantments
     */
    Map<Enchantment, Integer> getEnchantments();

    /**
     * Adds the specified enchantment to this item meta.
     *
     * @param enchantment Enchantment to add
     * @param level Level for the enchantment
     * @return true if the item meta changed as a result of this call, false
     *     otherwise
     */
    void addEnchantment(Enchantment enchantment, int level);

    /**
     * Removes the specified enchantment from this item meta.
     *
     * @param enchantment Enchantment to remove
     * @return true if the item meta changed as a result of this call, false
     *     otherwise
     */
    void removeEnchant(Enchantment enchantment);

    /**
     * Set itemflags which should be ignored when rendering a ItemStack in the Client. This Method does silently ignore double set itemFlags.
     *
     * @param itemFlags The hideflags which shouldn't be rendered
     */
    void addItemFlags(ItemFlag... itemFlags);

    /**
     * Remove specific set of itemFlags. This tells the Client it should render it again. This Method does silently ignore double removed itemFlags.
     *
     * @param itemFlags Hideflags which should be removed
     */
    void removeItemFlags(ItemFlag... itemFlags);

    /**
     * Get current set itemFlags. The collection returned is unmodifiable.
     *
     * @return A set of all itemFlags set
     */
    Collection<ItemFlag> getItemFlags();

    /**
     * Check if the specified flag is present on this item.
     *
     * @param flag the flag to check
     * @return if it is present
     */
    boolean hasItemFlag(ItemFlag flag);





}

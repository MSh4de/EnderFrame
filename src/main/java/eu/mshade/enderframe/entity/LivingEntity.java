package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.world.Location;

import java.util.HashSet;
import java.util.Set;

public interface LivingEntity extends Entity {

    double getEyeHeight();

    double getEyeHeight(boolean ignoreSneaking);

    Location getEyeLocation();

    //List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance);

    //List<Block> getLineOfSight(Set<Material> transparent, int maxDistance);

    //Block getTargetBlock(HashSet<Byte> transparent, int maxDistance);

    //Block getTargetBlock(Set<Material> transparent, int maxDistance);

    //List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance);

    //List<Block> getLastTwoTargetBlocks(Set<Material> transparent, int maxDistance);

    //Egg throwEgg();

    //Snowball throwSnowball();

    //Arrow shootArrow();

    int getRemainingAir();

    void setRemainingAir(int ticks);

    int getMaximumAir();

    void setMaximumAir(int ticks);

    int getMaximumNoDamageTicks();

    void setMaximumNoDamageTicks(int ticks);

    double getLastDamage();

    int _INVALID_getLastDamage();

    void setLastDamage(double damage);

    void _INVALID_setLastDamage(int damage);

    int getNoDamageTicks();

    void setNoDamageTicks(int ticks);

    Player getKiller();

    //boolean addPotionEffect(PotionEffect effect);

    //boolean addPotionEffect(PotionEffect effect, boolean force);

    //boolean addPotionEffects(Collection<PotionEffect> effects);

    //boolean hasPotionEffect(PotionEffectType type);

    //void removePotionEffect(PotionEffectType type);

    //Collection<PotionEffect> getActivePotionEffects();

    boolean hasLineOfSight(Entity other);

    boolean getRemoveWhenFarAway();

    void setRemoveWhenFarAway(boolean remove);

    //EntityEquipment getEquipment();

    void setCanPickupItems(boolean pickup);

    boolean getCanPickupItems();

    boolean isLeashed();

    Entity getLeashHolder() throws IllegalStateException;

    boolean setLeashHolder(Entity holder);
}

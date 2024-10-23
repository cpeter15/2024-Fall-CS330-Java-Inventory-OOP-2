package edu.odu.cs.cs330.items;

import java.util.Scanner;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
public class Armour extends Item {
    /**
     * Durability decreases each time armour is used.
     */
    protected int durability;

    /**
     * The amount of damage that can be negated.
     */
    protected int  defense;

    /**
     * Base material out of which the armour is constructed.
     */
    protected String material;

    /**
     * Type of enchantment afforded (e.g. protection, feather_falling, or
     * unbreaking)
     */
    protected String modifier;

    /**
     * Enchantment level applied.
     */
    protected int modifierLevel;

    /**
     * Associated element--e.g., ice, fire, and lightning.
     */
    protected String element;

    /**
     * Default to a armour with an empty name, zero durability, zero defense,
     * blank material, no modifier a zero modifier level, and a blank element.
     */
    public Armour()
    {
        super("");
        durability = 0;
        defense = 0;
        material = "";
        modifier = "";
        modifierLevel = 0;
        element = "";
    }

    /**
     * Duplicate a piece of armour.
     *
     * @param src armour to duplicate
     */
    public Armour(Armour src)
    {
        super(new String(src.name));
        durability = src.durability;
        defense = src.defense;
        material = new String(src.material);
        modifier = new String(src.modifier);
        modifierLevel = src.modifierLevel;
        element = new String(src.element);
    }

    /**
     * Retrieve armour durability.
     *
     * @return remaining durability
     */
    public int getDurability()
    {
        return this.durability;
    }

    /**
     * Set armour durability.
     *
     * @param dur new durability value
     */
    public void setDurability(int dur)
    {
        this.durability = dur;
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense()
    {
        return this.defense;
    }

    /**
     * Update defense.
     *
     * @param def replacement defense
     */
    public void setDefense(int def)
    {
        this.defense = def;
    }

    /**
     * Retrieve armour material.
     *
     * @return base material
     */
    public String getMaterial()
    {
        return this.material;
    }

    /**
     * Set armour Material.
     *
     * @param mat replacement material type
     */
    public void setMaterial(String mat)
    {
        this.material = mat;
    }

    /**
     * Retrieve armour modifier.
     *
     * @return buff/debuff provided
     */
    public String getModifier()
    {
        return this.modifier;
    }

    /**
     * Set armour modifier.
     *
     * @param mod updated modifier
     */
    public void setModifier(String mod)
    {
        this.modifier = mod;
    }

    /**
     * Retrieve armour modifier level.
     *
     * @return buff/debuff level
     */
    public int getModifierLevel()
    {
        return this.modifierLevel;
    }

    /**
     * Set armour modifier level.
     *
     * @param level replacement modifier level
     */
    public void setModifierLevel(int level)
    {
        this.modifierLevel = level;
    }

    /**
     * Retrieve armour element.
     *
     * @return element
     */
    public String getElement()
    {
        return this.element;
    }

    /**
     * Set armour element.
     *
     * @param ele new element
     */
    public void setElement(String ele)
    {
        this.element = ele;
    }

    @Override
    public boolean isStackable()
    {
        return false;
    }

    /**
     * Read Armour attributes.
     */
    @Override
    public void read(Scanner snr)
    {
        super.name   = snr.next();
        this.material = snr.next();
        this.durability = snr.nextInt();
        this.defense = snr.nextInt();
        this.modifier = snr.next();
        this.modifierLevel = snr.nextInt();
        this.element = snr.next();
    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Item clone()
    {
        return new Armour(this);
    }

    /**
     * Check for logical equivalence--based on name, material, modifier, and
     * element.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Armour)) {
            return false;
        }

        Armour rhsItem = (Armour) rhs;

        if (this == rhsItem) {
            return true;
        }

        if (!this.name.equals(rhsItem.getName())) {
            return false;
        }

        if (!this.material.equals(rhsItem.getMaterial())) {
            return false;
        }

        if (!this.modifier.equals(rhsItem.getModifier())) {
            return false;
        }

        if (!this.element.equals(rhsItem.getElement())) {
            return false;
        }

        // Replace the next line
        return true;
    }

    /**
     * Generate a hash code by adding the name, material, modifier, and element
     * hash codes.
     */
    @Override
    public int hashCode()
    {
        int result = name.hashCode() + material.hashCode() + modifier.hashCode() + element.hashCode();
        return result;
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder(String.format("  Nme: %s%n", this.name));
        strBuilder.append(String.format("  Dur: %d%n", this.durability))
                  .append(String.format("  Def: %d%n", this.defense))
                  .append(String.format("  Mtl: %s%n", this.material))
                  .append(String.format("  Mdr: %s (Lvl %d)%n", this.modifier, this.modifierLevel))
                  .append(String.format("  Emt: %s%n", this.element));
        return strBuilder.toString();
    }
}





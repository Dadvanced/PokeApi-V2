package models.pokemon;

public class Ability {
    private boolean isHidden;
    private int slot;
    private AbilityDetails ability;

    public Ability() {
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public AbilityDetails getAbility() {
        return ability;
    }

    public void setAbility(AbilityDetails ability) {
        this.ability = ability;
    }
}

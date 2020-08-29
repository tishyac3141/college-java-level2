package inheritance.lesson1;

public class Bear extends Animal {

    private boolean isHibernating;

    public void setIsHibernating(boolean hibernate) {
        isHibernating = hibernate;
    }

    public boolean getIsHibernating() {
        return isHibernating;
    }
}

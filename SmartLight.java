package Lambda_function;

class SmartLight {
    private LightBehavior behavior;

    // Set dynamic behavior
    public void setBehavior(LightBehavior behavior) {
        this.behavior = behavior;
    }

    // Run current behavior
    public void trigger() {
        if (behavior != null)
            behavior.activate();
        else
            System.out.println("No behavior set!");
    }
}

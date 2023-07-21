class Car {

    private String model;

    private boolean isAutomatic;

    private CaseType caseType;

    private ColorType color;

    private int fromZeroToHundredSec;

    private Engine engine;

    private int maxSpeed;


    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    public int getFromZeroToHundredSec() {
        return fromZeroToHundredSec;
    }

    public void setFromZeroToHundredSec(int fromZeroToHundredSec) {
        this.fromZeroToHundredSec = fromZeroToHundredSec;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
class ManualCar {
    private String brand;
    private String model;
    private boolean isEngineOn;
    private int currentSpeed;
    private int currentGear;

    public ManualCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isEngineOn = false;
        this.currentSpeed = 0;
        this.currentGear = 0;
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine started.");
    }

    public void stopEngine() {
        isEngineOn = false;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }

    // Overloading accelerate - Static Polymorphism
    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    public void accelerate(int speed) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += speed;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
        System.out.println(brand + " " + model + " : Braking! Speed is now "
                           + currentSpeed + " km/h");
    }

    public void shiftGear(int gear) {
        currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }
}

public class StaticPolymorphism {
    public static void main(String[] args) {
        ManualCar myManualCar = new ManualCar("Suzuki", "WagonR");
        myManualCar.startEngine();
        myManualCar.accelerate();      
        myManualCar.accelerate(40);    
        myManualCar.brake();
        myManualCar.stopEngine();
    }
}
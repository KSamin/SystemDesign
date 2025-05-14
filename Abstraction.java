interface Car{
    void startEngine(); 
    void shiftGear(int gear);
    void accelerate();
    void brake();
    void stopEngine();
    
}
class SportCar implements Car{
    
        String brand;
        String model;
        boolean isEngineOn = false;
        int currentSpeed = 0;
        int currentGear = 0;

        public SportCar(String brand,String model){
            this.brand = brand;
            this.model = model;
        }
        @Override
        public void startEngine(){
            isEngineOn = true;
            System.out.println(brand + " " + " "+ model +": Engine started ! ");
        }
        @Override
        public void shiftGear(int gear){
            if(!isEngineOn){
                System.out.println( brand+ " "+ gear + " "+": Enginer is off! cannot shift gear.");
                return;
            }
            this.currentGear = gear;
            System.out.println(brand + " " + model +" Gear is Shifted to"+currentGear);
        }
        @Override
        public void accelerate(){
            if(!isEngineOn){
                System.out.println( brand+ " "+ model+ ": Enginer is off! cannot accelerate.");
                return;
            }
            this.currentSpeed += 20;
            System.out.println(brand + " " + model + "Accelerate to :"+currentSpeed);
        }
        @Override
        public void brake(){
            this.currentSpeed-=10;
            if(currentSpeed<0){
                currentSpeed = 0;
            }
            System.out.println(brand + " " + model +"Breaking! current speed now : " + currentSpeed );
        }
        @Override
        public void stopEngine(){
            isEngineOn = false;
            currentGear = 0;
            currentSpeed = 0;
            System.out.println(brand + " " + model +":Engine turn off!");
        }


}
public class Abstraction {
        public static void main(String[] args) {
        Car myCar = new SportCar("maruti", "wagenar");
        myCar.startEngine();
       
        myCar.shiftGear(1);
        myCar.accelerate();
        myCar.shiftGear(2);
        myCar.accelerate();
        myCar.brake();
        myCar.stopEngine();
        
    }
}
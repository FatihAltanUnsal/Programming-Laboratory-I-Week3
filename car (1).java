public class Car {
    // 1. Öznitelikler (Attributes)
    private String plateNumber;
    private String model;
    private double mileage;       // Başlangıçta 0 olacak
    private double fuelLevel;     // Mevcut yakıt miktarı
    private double tankCapacity;  // Maksimum depo kapasitesi

    // Yapıcı Metot (Constructor)
    public Car(String plateNumber, String model, double startingFuelLevel, double tankCapacity) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.mileage = 0.0; // Mileage kural gereği 0 ile başlar
        this.tankCapacity = tankCapacity;
        
        // Başlangıç yakıtı depo kapasitesini aşamaz
        if (startingFuelLevel > tankCapacity) {
            this.fuelLevel = tankCapacity;
        } else {
            this.fuelLevel = startingFuelLevel;
        }
    }

    // 2. Operasyon Metotları (Methods)

    // drive(km): Her 10 km için 1 litre yakıt tüketir
    public void drive(double km) {
        double requiredFuel = km / 10.0;

        if (this.fuelLevel >= requiredFuel) {
            this.mileage += km;
            this.fuelLevel -= requiredFuel;
            System.out.println("Trip completed: " + km + " km driven.");
        } else {
            System.out.println("Not enough fuel for this trip!");
        }
    }

    // refuel(amount): Yakıt ekler, depo kapasitesini aşamaz
    public void refuel(double amount) {
        if (this.fuelLevel + amount > this.tankCapacity) {
            this.fuelLevel = this.tankCapacity;
            System.out.println("Tank is full, extra fuel discarded.");
        } else {
            this.fuelLevel += amount;
            System.out.println("Added " + amount + " liters of fuel.");
        }
    }

    // checkStatus(): Kilometreyi ve yakıt seviyesini yazdırır, %10 altındaysa uyarı verir
    public void checkStatus() {
        System.out.println("Car: " + this.model + " (" + this.plateNumber + ")");
        System.out.println("Current Mileage: " + this.mileage + " km");
        System.out.println("Fuel Level: " + this.fuelLevel + " / " + this.tankCapacity + " L");

        if (this.fuelLevel < (this.tankCapacity * 0.10)) {
            System.out.println("Low fuel warning!");
        }
        System.out.println("----------------------------------------");
    }
}
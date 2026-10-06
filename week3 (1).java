public class week3 {
    public static void main(String[] args) {
        // Bir Car nesnesi oluşturuluyor (Başlangıç yakıtı: 20L, Depo: 50L)
        System.out.println("Creating car object...");
        Car myCar = new Car("34 ABC 123", "Toyota Corolla", 20.0, 50.0);
        myCar.checkStatus();

        // 1. Normal Sürüş Simülasyonu
        System.out.println("Driving 120 km...");
        myCar.drive(120); // 12 litre yakar, 8L kalır (%16 - uyarı vermez)
        myCar.checkStatus();

        // 2. Düşük Yakıt Uyarısı Testi (Sürüş sonrası %10 altına inme)
        System.out.println("Driving 50 km...");
        myCar.drive(50); // 5 litre yakar, 3L kalır (Depo 50L olduğu için %10 sınırı 5L'dir -> Uyarı verir)
        myCar.checkStatus();

        // 3. Uç Durum (Edge Case 1): Yetersiz yakıt ile sürüş denemesi
        System.out.println("Driving 100 km (Needs 10L, but only 3L available)...");
        myCar.drive(100); // "Not enough fuel for this trip!" yazdırmalı
        myCar.checkStatus();

        // 4. Normal Yakıt Ekleme
        System.out.println("Refueling 20 liters...");
        myCar.refuel(20); // 3L + 20L = 23L olur
        myCar.checkStatus();

        // 5. Uç Durum (Edge Case 2): Depo kapasitesini aşan yakıt ekleme
        System.out.println("Refueling 40 liters (Exceeds 50L capacity)...");
        myCar.refuel(40); // 23 + 40 = 63L > 50L -> "Tank is full, extra fuel discarded."
        myCar.checkStatus();
    }
}

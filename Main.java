import java.util.Scanner;

public class Main {

    private int sumHotWater = 0; //м,куб
    private int sumColdWater = 0; //м,куб

    private static int limitHotWater = 10; //м,куб
    private static int limitColdWater = 15; //м,куб

    private static int priceLimitHotWater = 4; //руб.
    private static int priceHotWater = 6; //руб.
    private static int priceLimitColdWater = 2; //руб.
    private static double priceColdWater = 3; //руб.

    private double totalPay; //руб.
    private int hotWaterNow;
    private int coldWaterNow;
    private int payHotWater;
    private int payColdWater;

    public  void hotWaterNow(int sumHotWater) {
        System.out.println("Введите значение счетчика горячей воды: ");
        //м,куб
        int hotWaterNow = new Scanner(System.in).nextInt();
        this.hotWaterNow = hotWaterNow;
        this.sumHotWater = sumHotWater;
    }

    public void coldWaterNow(int sumColdWater) {
        System.out.println("Введите значение счетчика холодной воды: ");
        //м,куб
        int coldWaterNow = new Scanner(System.in).nextInt();
        this.coldWaterNow = coldWaterNow;
        this.sumColdWater = sumColdWater;
    }

    public int getSumHotWater() {return sumHotWater;}

    public int getSumColdWater() {return sumColdWater;}

    public void main(String[] args)
    {
        for(int month = 0;; month++)
        {            
            double payHotWater;
            if (hotWaterNow <= limitHotWater)
            {
                payHotWater = hotWaterNow * priceLimitHotWater;
                System.out.println("лимит не привышен");
            } else
            {
                payHotWater = limitHotWater * priceHotWater + (hotWaterNow - limitHotWater) * priceHotWater;
                System.out.println( "лимит привышен на: " + (hotWaterNow - limitHotWater) + "м,куб" );
            }
            sumHotWater = sumHotWater + hotWaterNow;

            
            double payColdWater;
            if (coldWaterNow <= limitColdWater)
            {
                payColdWater = coldWaterNow * priceLimitColdWater;
                System.out.println("Лимит не привышен");
            } else
            {
                payColdWater = limitColdWater * priceLimitColdWater +
                        (coldWaterNow - limitColdWater) * priceColdWater;
                System.out.println("Лимит привышен на :" + (coldWaterNow - limitColdWater) + "м,куб");
            }
            sumColdWater = sumColdWater + coldWaterNow;

            System.out.println("К оплате за холодную воду : " + payHotWater);


            totalPay = payHotWater + payColdWater;
            System.out.println("Всего к оплате: " + totalPay + "руб");

            if (month % 12 == 0)
            {
                System.out.println("Всего использовано горячей воды: " + sumHotWater + "м,куб" +
                "\nВсего использовано холодной воды: " + sumColdWater + "м,куб");
            }
        }
    }

    public int getPayHotWater() {return payHotWater;}

    public int getPayColdWater() {return payColdWater;}

    public void printer()
    {
        System.out.println(getPayHotWater());
        System.out.println(getPayColdWater());
    }




}

package com.matas;

public class Main {
    /**
     * 本期应预扣预缴税额=（累计预扣预缴应纳税所得额×预扣率-速算扣除数)-累计减免税额-累计已预扣预缴税额。
     *
     * @param args
     * @return
     * @author matas
     * @date 2018/12/31 18:37
     */
    public static void main(String[] args) {
        double salary = 30000;//税前工资
        double freeLine = 5000; //每月减免【固定】
        double insurance = 1400; //三险一金【公积金+医保】
        double children = 0;//子女
        double oldman = 0;//老人
        double rent = 0;//租房
        double loans = 1000;//房贷

        int month = 12; //第几个月
        double totalTax = 0; //累计预扣预缴税
        for (int i = 1; i <= month; i++) {
            double sum = (salary - freeLine - insurance - children - oldman - rent - loans) * i; //累计预扣预缴应纳税所得额
            double fast = 0; //速算扣除数
            double rate = 0.03; //预扣率

            if (sum <= 36000) {
                rate = 0.03;
                fast = 0;
            } else if (sum > 36000 && sum <= 144000) {
                rate = 0.1;
                fast = 2520;
            } else if (sum > 144000 && sum <= 300000) {
                rate = 0.2;
                fast = 16920;
            } else if (sum > 300000 && sum <= 420000) {
                rate = 0.25;
                fast = 31920;
            } else if (sum > 420000 && sum <= 660000) {
                rate = 0.3;
                fast = 52920;
            } else if (sum > 660000 && sum <= 960000) {
                rate = 0.35;
                fast = 85920;
            } else if (sum > 960000) {
                rate = 0.45;
                fast = 181920;
            }

            double preTax = sum * rate - fast - totalTax;
            totalTax += preTax;
            double daoshou = salary - preTax - insurance;
            System.err.println("第" + i + "个月应预扣预缴税=>" + preTax + " 到手工资=>" + daoshou + "，到目前共预缴税=>" + totalTax);
        }
    }
}

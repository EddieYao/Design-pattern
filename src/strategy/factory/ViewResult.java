package strategy.factory;

import simpleFactory.mall.CashSup;
import simpleFactory.mall.CashierFactory;

import java.util.Scanner;

/**
 * 界面
 */
public class ViewResult {
    public static void main(String[] args) {
        try {
            //工厂只负责产生对象，具体操作由对象本身操作
            Scanner scanner = new Scanner(System.in);
            System.out.print("确认启动计算器？(Y:是 N:否) ：");
            double cashAll = 0;
            while ("Y".equals(scanner.next())) {
                CashContext cashContext = new CashContext();
                System.out.print("请输入折扣类型：");
                cashContext.getCashier(scanner.nextInt());
                System.out.print("请输入金额：");
                double cashResult = cashContext.getResultMoney(scanner.nextDouble());
                //double精度问题，保留6位小数
                System.out.println("计算结果：" + String.format("%.6f",cashResult));
                cashAll = cashAll + cashResult;
                System.out.println("总金额：" + String.format("%.6f",cashAll));
                System.out.println("是否继续计算？(Y:是 N:否) ：");
            }
        } catch (Exception e) {
            System.out.println("错误信息: " + e.getMessage());
        }
    }
}

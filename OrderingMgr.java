import java.util.Scanner;

public class OrderingMgr {
    String[] names= new String[10];
    String[] dishMegs= new String[10];
    int[] times= new int[10];
    String[] addresses= new String[10];
    int[] states= new int[10];
    double[] sumPrices= new double[10];

    String[] dishNames= {"红烧肉","烤鱼","麻辣香锅"};
    double[] Prices= {5,25,15};
    int[] praiseNums=new int[dishNames.length];

    public static void main(String[] args) {
        OrderingMgr order = new OrderingMgr();
        while(true) {
            order.showMainMenu();
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("***我要订餐***");
                    order.placeOrder();
                    break;
                case 2:
                    System.out.println("***查看餐袋***");
                    break;
                case 3:
                    System.out.println("***签收订单***");
                    break;
                case 4:
                    System.out.println("***删除订单***");
                    break;
                case 5:
                    System.out.println("***我要点赞***");
                    break;
                case 6:
                    System.out.println("感谢使用外卖订餐系统，再见！");
                    System.exit(0);
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误，请选择1-6之间的数字！");
                    break;
            }
        }
    }
    public void showMainMenu(){
        System.out.println("欢迎使用“外卖订餐系统”");
        System.out.println("*****************************");
        System.out.println("1.我要订餐");
        System.out.println("2.查看餐袋");
        System.out.println("3.签收订单");
        System.out.println("4.删除订单");
        System.out.println("5.我要点赞");
        System.out.println("6.退出系统");
        System.out.println("*****************************");
        System.out.println("请选择：");
    }
    public void placeOrder(){
        boolean flag = false;
        for (int j = 0; j < names.length; j++) {
            if (names[j] == null) {
                // 找到第一个空位置，可以添加订单信息
                flag = true; // 置标志位，可以订餐
                //输入订餐人的姓名
                System.out.print("请输入订餐人姓名：");
                Scanner input = new Scanner(System.in);
                String name=input.next();

                //选择的菜品和份数
                System.out.println("序号" + "\t" + "菜名" + "\t" + "单价");
                for (int i = 0; i < dishNames.length; i++) {
                    String price = Prices[i] + "元";
                    String praiseNum = (praiseNums[i] > 0) ? praiseNums[i] + "赞" : "";
                    System.out.println((i + 1) + "\t" + dishNames[i] + "\t" + price + "\t" + praiseNum);
                }

                // 用户点菜
                System.out.print("请选择您要点的菜品编号：");
                int chooseDish = input.nextInt();
                System.out.print("请选择您需要的份数：");
                int number = input.nextInt();
                String dishMeg = dishNames[chooseDish - 1] + " " + number + "份";
                //餐费计算
                double sumPrice = Prices[chooseDish - 1] * number;
                // 餐费满50元，免送餐费，否则5元
                double deliCharge = (sumPrice >= 50) ? 0 : 5;
                //输出订单时间
                System.out.print("请输入送餐时间（送餐时间是10点至20点间整点送餐）：");
                int time = input.nextInt();
                while (time < 10 || time > 20) {
                    System.out.print("您的输入有误，请输入10~20间的整数！");
                    time = input.nextInt();
                }
                System.out.print("请输入送餐地址：");
                String address = input.next();

                System.out.println("订餐成功！");
                System.out.println("您订的是：" + dishMeg);
                System.out.println("送餐时间：" + time + "点");
                System.out.println("餐费：" + sumPrice + "元， 送餐费" + deliCharge + "元， 总计：" + (sumPrice + deliCharge) + "元。");
                // 添加数据
                names[j] = name;
                dishMegs[j] = dishMeg;
                times[j] = time;
                addresses[j] = address;
                sumPrices[j] = sumPrice + deliCharge;
                break;
            }
            
        }

    }
}

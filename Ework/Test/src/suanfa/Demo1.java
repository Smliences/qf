package suanfa;
/*��Ŀ���ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�С���ӳ������ĸ���
 * ��ÿ��������һ�����ӣ��������Ӷ���������ÿ���µ���������Ϊ���٣�
 * 2 2 4 6 8 10 
 */
public class Demo1 {
    public static void main(String args[]) {
        for (int i = 1; i <= 20; i++)
            System.out.println(f(i));
    }
    public static int f(int x) {
        if (x == 1||x == 2)
            return 1;
        else
            return f(x - 1) + f(x - 2);
    }
}
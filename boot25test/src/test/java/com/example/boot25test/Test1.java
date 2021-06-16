package com.example.boot25test;

import com.baomidou.mybatisplus.core.toolkit.AES;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
        // 生成 16 位随机 AES 密钥
        String randomKey = AES.generateRandomKey();

        // 随机密钥加密
        String url = AES.encrypt("jdbc:mysql://localhost:3306/jeethink-crm?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8", randomKey);

        String userName = AES.encrypt("root", randomKey);

        String password = AES.encrypt("123456", randomKey);

        System.out.println("mpw:" + url);
        System.out.println("mpw:" + userName);
        System.out.println("mpw:" + password);
        System.out.println(randomKey);

        int[] arr = {2, 5, 1, 3, 8, 5, 7, 4, 3};

        int[] arr2 = {4, 2, 35, 9, 7, 8, 1, 5, 0, 4, 3};

        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        quickSort(arr2, 0, arr.length - 1);
        for (int i : arr2) {
            System.out.print(i);
            System.out.print(",");
        }

        System.out.println();
        int[] ass = {2, 3, 1, 0, 2, 5};
        dicsC(ass);

    }


    public static void sort(int[] array) {
        int temp = 0; // 用来交换的临时数
        boolean bChange = false; // 交换标志
    }


    public static void quick_sort(int s[], int l, int r) {
        int i, j, t, temp;
        if (l > r)
            return;
        temp = s[l]; //temp中存的就是基准数
        i = l;
        j = r;

        while (i != j) {
            //顺序很重要，要先从右边开始找
            while (s[j] >= temp && i < j)
                j--;
            //再找左边的
            while (s[i] <= temp && i < j)
                i++;
            //交换两个数在数组中的位置
            if (i < j) {
                t = s[i];
                s[i] = s[j];
                s[j] = t;
            }
        }
        //最终将基准数归位
        s[l] = s[i];
        s[i] = temp;

        quick_sort(s, l, i - 1);//继续处理左边的，这里是一个递归的过程
        quick_sort(s, i + 1, r);//继续处理右边的 ，这里是一个递归的过程
    }


    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void t2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {    // 必须加
            return;
        }

        int temp = arr[left]; // 以左边的元素为基准元素
        int i = left, j = right; // i,j为两个游标
        while (i < j) {
            while (i < j && arr[j] >= temp) { // 右边先走
                j--;
            }
            while (i < j && arr[i] <= temp) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        arr[left] = arr[i]; // 注意，这一步必须要，填上最左边的坑
        arr[i] = temp; // 基准元素就位
        quickSort(arr, left, i - 1);    // 递归操作左边部分
        quickSort(arr, i + 1, right);   // 递归操作右边部分
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int binarySearch(int[] arr, int left, int right, int find) {
        int midIndex = (left + right) / 2;
        int midVal = arr[midIndex];
        if (left > right) {
            return -1;
        }

        if (midVal > find) {
            binarySearch(arr, left, midIndex - 1, find);
        } else if (midVal < find) {
            binarySearch(arr, midIndex + 1, right, find);
        } else {
            return midIndex;
        }
        return -1;
    }

    // java 转 xml 使用freemark模板

    // kerry 物流同步客户产品型号及相关参数拉取sftp 数据先将所有按照 存入map里
    // 因为没有id 从数据库查出存入map中 根据sku+序列号+库号+。。 做key 因为几个字段加起来是唯一的 再将excel中读的数据写入map替换相关属性再做更新和添加
    // 再将数据库唯一查询出来的数据删除，再将map中数据重新写入数据库

    // 对接顺丰快递接口，顺丰快递的提供的开发文档不清晰已经各种bug，将顺丰快递提供的client客户端请求json方式进行统一

    // android版本迭代使用nginx静态路径代理，本来我们是使用一个专用服务放在静态resource包下但每次部署要新运行一个项目实在浪费添加client升级表以及版本和路径

    // 原子性、一致性、隔离性、持久性


    // 岱宗crm系统开发：线索、客户报价单、订单模块开发、客户报价以及设备、客户跟进，客户定时转公客。财务模块 回款计划回款以及发票管理。进销存入库出库、库存盘点


    public static void dicsC(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.getOrDefault(i, -1) == -1) {
                map.put(i, 1);
            } else {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean find2S(int target, int[][] matrix) {
        int x = 0;
        int y = matrix[0].length - 1;

        while (true) {
            if (target == matrix[x][y]) {
                System.out.println("target=:" + target);
                break;
            }
            if (matrix[x][y] > target) {
                y--;
                continue;
            }
            if (y == 0) {
                System.out.println("不存在");
                break;
            }
            if (matrix[x][y] < target&&y<matrix[0].length) {
                y++;
                continue;
            }

        }

        return false;

    }


}



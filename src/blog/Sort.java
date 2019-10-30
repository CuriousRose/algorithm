package blog;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author chj
 * @date 2019/8/21 10:09
 */
public class Sort {

    public static void main(String[] args) {
        int[] nums = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
//        bubbleSort(nums);
//        selectionSort(nums);
//        insertSort(nums);
//        shellSort(nums);
//        MergeSort(nums, 0, nums.length - 1);
//        quickSort(nums, 0, nums.length - 1);
//        heapSort(nums);
//        countingSort(nums);
//        radixSort(nums);
        bucketSort(nums, 3);
        for (int i : nums) {
            System.out.print(i + " ");
        }
        return;
    }

    /**
     * 冒泡排序
     * 思想:重复扫描列表,比较相邻数据,进行交换,达成有序列表
     * <p>
     * 特点:
     * 1.每次将最大数据,置于末端
     * 2.扫描范围逐渐缩小
     * <p>
     * 优化:记录本轮比较是否发生交换,若不存在交换,表明队列已有序,提前结束扫描
     * <p>
     * 时间复杂度:O(n)~O(n^2) 平均:O(n^2) (取决于当前列表顺序状态)
     * 空间复杂度O(n)
     *
     * @param nums
     */
    static void bubbleSort(int[] nums) {
        //扫描次数
        for (int i = 0; i < nums.length; i++) {
            //交换记录
            boolean change = false;
            //两两比较
            for (int j = 0; j < nums.length - 1 - i; j++) {
                //交换
                if (nums[j] > nums[j + 1]) {
                    int swap = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = swap;
                    //记录
                    change = true;
                }
            }
            //本轮不存在交换,提前退出
            if (!change) {
                break;
            }
        }
    }

    /**
     * 选择排序
     * 思想:重复扫描列表,每次选出最小值,下一轮从余下数据中再进行选择,达成有序列表
     * <p>
     * 特点:
     * 1.符合常规思维
     * 2.时间复杂度稳定
     * <p>
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(n)
     *
     * @param nums
     */
    static void selectionSort(int[] nums) {
        //选择次数
        for (int i = 0; i < nums.length - 1; i++) {
            //初始化
            int minIndex = i;
            //进行比较
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            //进行交换
            int swap = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = swap;
        }
    }

    /**
     * 插入排序
     * 思想:列表划分为已排序和未排序列表,不断从未排序列表中获取数据,插入已排序列表中相应位置
     * <p>
     * 特点:
     * 1.数据拆分
     * 2.数据合并
     * <p>
     * 优化:在源列表中,进行拆分,不开辟存储空间
     * <p>
     * 时间复杂度:O(n)~O(n^2) 平均:O(n^2)
     * 空间复杂度:O(n)
     *
     * @param nums
     */
    static void insertSort(int[] nums) {
        //已排序/未排序划分位置
        for (int i = 1; i < nums.length; i++) {
            //选择数据
            int swap = nums[i];
            int j = i - 1;
            //比较,移动
            while (j >= 0 && swap < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            //插入
            nums[j + 1] = swap;
        }
    }

    /**
     * 希尔排序
     * 前提:越有序的序列,插入排序效率越高
     * <p>
     * 思想:
     * 1.将列表划分为更小的组,进行插入排序,不断缩小分组数量,再进行插入排序
     * 2.每次可提高队列有序度,提升下轮插入排序效率
     * <p>
     * 特点:
     * 1.提高有序度
     * <p>
     * 时间复杂度:O(n*log2n)
     * 空间复杂度:O(n)
     *
     * @param nums
     */
    static void shellSort(int[] nums) {
        //分组数量
        int gap = nums.length / 2;
        while (gap > 0) {
            //插入排序
            for (int i = gap; i < nums.length; i++) {
                //选择数据
                int swap = nums[i];
                int j = i - gap;
                //比价,移动
                while (j >= 0 && swap < nums[j]) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                //插入
                nums[j + gap] = swap;
            }
            //缩小分组数量
            gap /= 2;
        }
    }


    /**
     * 归并排序
     * 思想:列表拆分至单个数据,两两有序列表合并,组成有序列表
     * <p>
     * 特点:
     * 1.分治
     * 2.合并
     * 3.额外空间
     * <p>
     * 时间复杂度:O(n*log2n)
     * 空间复杂度:O(n*2)
     *
     * @param nums
     * @param l
     * @param r
     */
    static void MergeSort(int[] nums, int l, int r) {
        //单个数据返回(有序)
        if (r - l < 1) {
            return;
        }
        //分治
        int m = (l + r) / 2;
        MergeSort(nums, l, m);
        MergeSort(nums, m + 1, r);
        //合并
        int ls = l;
        int rs = m + 1;
        int[] list = new int[r - l + 1];
        int index = 0;
        while (index < list.length) {
            if (ls > m) {
                list[index++] = nums[rs++];
                continue;
            }
            if (rs > r) {
                list[index++] = nums[ls++];
                continue;
            }
            if (nums[ls] < nums[rs]) {
                list[index++] = nums[ls++];
            } else {
                list[index++] = nums[rs++];
            }
        }
        //赋值
        for (int i = 0; i < list.length; i++) {
            nums[l + i] = list[i];
        }
    }

    /**
     * 快速排序
     * 思想:每次操作,选出一个数据,将其他数据与其比较,进行列表划分,再对子列表重复操作
     * <p>
     * 特点:
     * 1.分治
     * <p>
     * 时间复杂度:O(n^2)~O(n*log2n) 平均:O(n*log2n)
     * 空间复杂度:O(n)
     *
     * @param nums
     * @param l
     * @param r
     */
    static void quickSort(int[] nums, int l, int r) {
        //有序数据返回
        if (l >= r) {
            return;
        }
        int x = l;
        int y = r;
        //数据划分
        while (x < y) {
            //右缩进
            while (x < y && nums[x] <= nums[y]) {
                y--;
            }
            //交换
            int swap = nums[x];
            nums[x] = nums[y];
            nums[y] = swap;
            //左缩进
            while (x < y && nums[x] <= nums[y]) {
                x++;
            }
            //交换
            swap = nums[x];
            nums[x] = nums[y];
            nums[y] = swap;
        }
        //处理子集
        quickSort(nums, l, x - 1);
        quickSort(nums, y + 1, r);
    }

    /**
     * 堆排序
     * 前提:二叉树
     * <p>
     * 思想:建立树,父节点大于子节点,每轮获取根节点最大值,进行堆调整
     * <p>
     * 特点:
     * 1.堆构造
     * 2.堆调整
     * 3.数组表示二叉树结构
     * <p>
     * 时间复杂度:O(n*log2n)
     * 空间复杂度:O(n)
     *
     * @param nums
     */
    static void heapSort(int[] nums) {
        int len = nums.length - 1;
        //堆建立
        for (int i = len; i > 0; i--) {
            if (nums[i] > nums[(i - 1) / 2]) {
                int swap = nums[i];
                nums[i] = nums[(i - 1) / 2];
                nums[(i - 1) / 2] = swap;
            }
        }
        //获取最大值
        while (len > 0) {
            int swap = nums[0];
            nums[0] = nums[len];
            nums[len] = swap;
            //调整
            heap(nums, --len, 0);
        }
    }

    /**
     * 堆调整
     *
     * @param nums
     * @param len
     * @param index
     */
    static void heap(int[] nums, int len, int index) {
        int maxIndex = index;
        int l = index * 2 + 1;
        int r = index * 2 + 2;
        //左子树比较
        if (l <= len && nums[index] < nums[l]) {
            maxIndex = l;
        }
        //右子树比较
        if (r <= len && nums[maxIndex] < nums[r]) {
            maxIndex = r;
        }
        //调整
        if (maxIndex != index) {
            int swap = nums[index];
            nums[index] = nums[maxIndex];
            nums[maxIndex] = swap;
            //调整子树
            heap(nums, len, maxIndex);
        }
    }

    /**
     * 计数排序
     * 思想:记录每个数字出现次数,按顺序组成有序列表
     * <p>
     * 特点:
     * 1.记录
     * 2.时空转换
     * 3.桶
     * <p>
     * tips:k -> 数据范围
     * <p>
     * 时间复杂度:O(n+k)
     * 空间复杂度:O(n+k)
     *
     * @param nums
     */
    static void countingSort(int[] nums) {
        //记录表
        int[] count = new int[100];
        for (int i : nums) {
            //记录
            count[i]++;
        }
        //组成列表
        int index = 0;
        for (int i = 0; i < 100; i++) {
            while (count[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }

    /**
     * 基数排序
     * 思想:根据数据的每一位进行排序,每次排序后,将结果顺序展开,供下次排序使用
     * <p>
     * 特点:
     * 1.特征提取
     * 2.分组排序
     * 3.桶
     * <p>
     * tips:k -> 特征数量
     * <p>
     * 时间复杂度:O(n*k)
     * 空间复杂度:O(n+k)
     *
     * @param nums
     */
    static void radixSort(int[] nums) {
        //获取最大值
        int max = nums[0];
        for (int i : nums) {
            max = max > i ? max : i;
        }
        //计算特征数
        int rounds = 0;
        while (max != 0) {
            max /= 10;
            rounds++;
        }
        //创建桶
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }
        int div = 1;
        //特征处理
        for (int i = 0; i < rounds; i++, div *= 10) {
            //数据提取
            for (int j = 0; j < nums.length; j++) {
                int key = (nums[j] / div) % 10;
                bucketList.get(key).add(nums[j]);
            }
            //数据展开
            int index = 0;
            for (List<Integer> list : bucketList) {
                for (int value : list) {
                    nums[index++] = value;
                }
                list.clear();
            }
        }
    }

    /**
     * 桶排序
     * 思想:将数据分组放入桶中,对桶数据排序,再进行展开
     * <p>
     * 特点:
     * 1.特征提取
     * 2.分组排序
     * 3.桶
     * <p>
     * tips:k -> 桶数量
     * <p>
     * 时间复杂度:O(n+k)
     * 空间复杂度:O(n+k)
     *
     * @param nums
     * @param count
     */
    static void bucketSort(int[] nums, int count) {
        int max = nums[0];
        int min = nums[0];
        for (int i : nums) {
            max = max > i ? max : i;
            min = min < i ? min : i;
        }
        if (max == min) {
            return;
        }
        int size = (max - min) / count + 1;
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            bucketList.add(new ArrayList<>());
        }
        for (int i : nums) {
            int key = (i - min) / size;
            bucketList.get(key).add(i);
        }
        int index = 0;
        for (List<Integer> list : bucketList) {
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int i : list) {
                nums[index++] = i;
            }
        }
    }
}

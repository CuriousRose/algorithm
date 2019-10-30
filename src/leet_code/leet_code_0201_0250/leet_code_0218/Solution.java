package leet_code.leet_code_0201_0250.leet_code_0218;

import java.util.*;

/**
 * 离散化 线段树
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] buildings = new int[][]{
//                {2, 9, 10},
//                {3, 7, 15},
//                {5, 12, 12},
//                {15, 20, 10},
//                {19, 24, 8}
//        };
        //[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
        int[][] buildings = new int[][]{
                {0, 6, 1}, {4, 7, 2}, {3, 11, 3}, {1, 10, 4}, {5, 9, 5}, {2, 8, 6}
        };
        //[[0,1],[1,4],[2,6],[8,5],[9,4],[10,3],[11,0]]
        System.out.println(solution.getSkyline(buildings));
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Segment> segments = new ArrayList<>();
    List<Integer> list = new ArrayList<>();


    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length == 0) {
            return result;
        }
        Set<Integer> set = new HashSet<>();
        for (int[] is : buildings) {
            for (int j = 0; j < 2; j++) {
                if (set.contains(is[j])) {
                    continue;
                } else {
                    set.add(is[j]);
                    list.add(is[j]);
                }
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        for (int[] is : buildings) {
            Segment segment = new Segment(map.get(is[0]), map.get(is[1]), is[2]);
            segments.add(segment);
        }
        segments.sort(new Comparator<Segment>() {
            @Override
            public int compare(Segment o1, Segment o2) {
                return o1.height - o2.height;
            }
        });

        STree root = new STree(0, list.size() - 1, 0);
        for (Segment segment : segments) {
//            segment.out();
            root.update(segment.left, segment.right - 1, segment.height);
        }
        statistics(root);
        return result;
    }

    int record = -1;

    void statistics(STree node) {
//        node.out();
        if (node == null) {
            return;
        }
        if (node.value != -1) {
            if (node.value != record) {
                List<Integer> item = new ArrayList<>();
                item.add(list.get(node.left));
                item.add(node.value);
                result.add(item);
                record = node.value;
            }
            return;
        }
        statistics(node.leftNode);
        statistics(node.rightNode);
    }

    class Segment {
        int left;
        int right;
        int height;

        Segment(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }

        void out() {
            System.out.println(left + "," + right + "," + height);
        }
    }

    class STree {
        int left;
        int right;
        int mid;
        int value;
        STree leftNode;
        STree rightNode;

        STree(int left, int right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
            this.mid = (left + right) >> 1;
        }

        void update(int l, int r, int v) {
            if (l > right || r < left) {
                return;
            }
            if (l <= left && r >= right) {
//                System.out.println("up:" + l + ":" + r + ":" + v + "___" + left + ":" + right);
                this.value = v;
                return;
            } else {
                if (leftNode == null) {
                    leftNode = new STree(left, mid, value);
                }
                if (rightNode == null) {
                    rightNode = new STree(mid + 1, right, value);
                }
                if (value != -1) {
                    leftNode.value = value;
                    rightNode.value = value;
                }
                leftNode.update(l, r, v);
                rightNode.update(l, r, v);
                this.value = -1;
            }
        }

        void out() {
            System.out.println(left + ":" + right + ":" + value);
        }
    }
}


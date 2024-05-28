package 其他练习;

public class 网格图中最少访问的格子数 {
    public int minimumVisitedCells(int[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;
        int all = rl * cl - 1;
        update(root, 0, all, 0, 0, 1);
        update(root2, 0, all, 0, 0, 1);
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                int curr1 = query(root, 0, all, i * cl + j, i * cl + j);
                int curr2 = query(root2, 0, all, j * rl + i, j * rl + i);
                int curr = Math.min(curr1, curr2);
                if (curr != Integer.MAX_VALUE) {
                    if (grid[i][j] != 0) {
                        update(root, 0, all, i * cl + j + 1, i * cl + j + grid[i][j] >= (i + 1) * cl ? (i + 1) * cl - 1 : i * cl + j + grid[i][j], curr + 1);
                        update(root2, 0, all, j * rl + i + 1, j * rl + i + grid[i][j] >= (j + 1) * rl ? (j + 1) * rl - 1 : j * rl + i + grid[i][j], curr + 1);
                    }
                }
            }
        }
        int t=Math.min(query(root, 0, all, all, all), query(root2, 0, all, all, all));
        return t==Integer.MAX_VALUE?-1:t;
    }

    public static void main(String[] args) {
        System.out.println(new 网格图中最少访问的格子数()
                .minimumVisitedCells(new int[][]{{3, 4, 2, 1}, {4, 2, 3, 1}, {2, 1, 0, 0}}));
    }

    public Node root = new Node();
    public Node root2 = new Node();

    class Node {
        Node left, right;
        int val = Integer.MAX_VALUE;
//        int lazy;
    }

    public void update(Node node, int cl, int cr, int l, int r, int val) {
        if (l <= cl && cr <= r) {
            if (val < node.val) {
                node.val = val;
            }
            return;
        }
        pushdown(node);
        int mid = (cl + cr) >> 1;
        if (l <= mid) update(node.left, cl, mid, l, r, val);
        if (mid + 1 <= r) update(node.right, mid+1, cr, l, r, val);
    }

    public void pushdown(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.val < node.left.val)
            node.left.val = node.val;
        if (node.val < node.right.val)
            node.right.val = node.val;
    }

    public int query(Node node, int cl, int cr, int l, int r) {
        if (l <= cl && cr <= r)
            return node.val;
        int mid = (cl + cr) >> 1;
        pushdown(node);
        int result = Integer.MAX_VALUE;
        if (l <= mid) result = query(node.left, cl, mid, l, r);
        if (mid + 1 <= r) result = Math.min(result, query(node.right, mid + 1, cr, l, r));
        return result;
    }
}

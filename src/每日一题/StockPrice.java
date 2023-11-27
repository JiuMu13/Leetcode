package 每日一题;

import java.util.*;

class StockPrice {
    Map<Integer,Integer> map;
    List<Integer> list=new LinkedList<>();
    PriorityQueue<Node> pqMax;
    PriorityQueue<Node> pqMin;
    int now;
    class Node{
        int time;
        int price;

        public Node(int time, int price) {
            this.time = time;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return time == node.time;
        }

        @Override
        public int hashCode() {
            return Objects.hash(time);
        }
    }
    public StockPrice() {
        map=new HashMap<>();
        pqMax=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                return t1.price-node.price;
            }
        });
        pqMin=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                return node.price-t1.price;
            }
        });

    }

    public void update(int timestamp, int price) {
        if (now<timestamp)
            now = timestamp;
        pqMax.add(new Node(timestamp,price));
        pqMin.add(new Node(timestamp,price));
        map.put(timestamp,price);
    }

    public int current() {
        return map.get(now);
    }

    public int maximum() {
        int time=pqMax.peek().time;
        int price=pqMax.peek().price;
        while (map.get(time)!=price){
            pqMax.poll();
            time=pqMax.peek().time;
            price=pqMax.peek().price;
        }
        return price;
    }

    public int minimum() {
        int time=pqMin.peek().time;
        int price=pqMin.peek().price;
        while (map.get(time)!=price){
            pqMin.poll();
            time=pqMin.peek().time;
            price=pqMin.peek().price;
        }
        return price;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        //1.담을 그릇 생성
        Queue<int[]> queue = new PriorityQueue<int[]>(points.length,Comp);
        int[][] result = new int[K][2];
        int index=0;
        //2.큐에 데이터 삽입
        for(int[] p : points) {
            queue.offer(p);
        }
        //3.result에 큐로부터 데이터 저장
        while(index < K) {//for반복문을 while문으로 나타냈다고 생각
            result[index] = queue.poll();
            index++;
        }
        return result;
        
        
    }
    Comparator<int[]> Comp = new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return (a[0]*a[0] + a[1]*a[1])-(b[0]*b[0] + b[1]*b[1]);
            }
        };
}
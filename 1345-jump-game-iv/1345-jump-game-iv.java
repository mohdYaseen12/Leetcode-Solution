class Solution {
    public int minJumps(int[] arr) {
          int n = arr.length;
        if (n == 1) {
            return 0;
        }
        
        Map<Integer, List<Integer>> valueToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndex.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n - 1) {
                    return steps;
                }
                
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }
                
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }
                
                for (int index : valueToIndex.getOrDefault(arr[curr], Collections.emptyList())) {
                    if (!visited[index]) {
                        visited[index] = true;
                        queue.offer(index);
                    }
                }
                
                // remove the indices with the same value to avoid revisiting them
                valueToIndex.remove(arr[curr]);
            }
            steps++;
        }
        
        return -1;
    }
}
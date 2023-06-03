class Solution {
    int maxTime = Integer.MIN_VALUE;

    public void dfs(ArrayList<ArrayList<Integer>> adjList, int[] informTime, int curr, int time) {
        maxTime = Math.max(maxTime, time);

        for (int adjacent : adjList.get(curr)) {
            dfs(adjList, informTime, adjacent, time + informTime[curr]);
        }
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(n);

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adjList.get(manager[i]).add(i);
            }
        }

        dfs(adjList, informTime, headID, 0);
        return maxTime;
    }
}

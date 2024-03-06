class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n ; j++){
                for(int k = 0; k<n ; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(0,0,n-1,grid,dp);
    }

    public int helper(int row, int c1, int c2, int[][]grid, int[][][]dp){
        if(c1 <0 || c1>=grid[0].length || c2<0 || c2>=grid[0].length)
            return 0;
        
        if(dp[row][c1][c2]!=-1)
            return dp[row][c1][c2];
        
        int result = 0;
        result += grid[row][c1];
        if(c1!=c2)
            result += grid[row][c2];

        //tranistion
        if(row != grid.length-1){
            int maxSum = 0;
            for(int newC1 = c1-1; newC1<= c1+1; newC1++){
                for(int newC2 = c2 -1; newC2 <= c2+1; newC2++){
                    maxSum = Math.max(maxSum , helper(row+1, newC1, newC2, grid, dp));
                }
            }
            result += maxSum;
            
        }
        dp[row][c1][c2] = result;
        return result;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        int ans1 = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i*j == 0 || i == row-1 || j == col-1){
                    dfs(grid,i,j);
                }
            }
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    
                    ans1 += dfs(grid,i,j);
                }
            }
        }
        
        
        return ans1;
    }
    
    public int dfs(int[][] grid,int i,int j){
        
        if(i < 0|| j < 0|| i >= grid.length || j>= grid[0].length  || grid[i][j] == 0|| grid[i][j] == 2){
            return 0;
        }
         
        
        grid[i][j] = 2;
        int ans = 1;
        ans+=dfs(grid,i+1,j);
        ans+=dfs(grid,i-1,j);
        ans+=dfs(grid,i,j-1);
        ans+=dfs(grid,i,j+1);
        
        return ans;
    }
}
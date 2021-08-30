// Basically same as Max area in histogram
public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        // for each cell with value=1, we look upward (north), the number of continuous '1' is the height of cell
        int[] heights = new int[matrix[0].length];
        int maxArea=-1;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]=='0'){
                    heights[j] = 0;
                } else {
                    heights[j] ++;
                }
            }            
            int area = MaxAreaInHistogramMethod(heights);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length<1) return false;
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = row*column - 1;
        while(left<=right) {
            int mid = left + (right - left)/2;
            if(target == matrix[mid/column][mid%column]) {
                return true;
            }else if(target>matrix[mid/column][mid%column]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }
}
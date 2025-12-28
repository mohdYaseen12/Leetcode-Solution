/**
 * @param {number[][]} grid
 * @return {number}
 */
var countNegatives = function(grid) {
    let count = 0;
    for(mat of grid){
        for( let i =0; i< mat.length; i++){
            if(mat[i] < 0){
                count += mat.length - i;
                break
            }
        }
    }
    return count;
};
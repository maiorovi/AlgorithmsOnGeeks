package tasks

class Neighbor {
    int value
    int row
    int column
}

def findNumberOfIslands(Integer[][] matrix) {
    boolean[][] visited = new boolean[matrix.length][matrix.length]
    for (int i = 0; i < visited.length; i++) {
        for (int j = 0; j < visited.length; j++) {
            visited[i][j] = false;
        }
    }

    int counter = 0

    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix.length; j++) {
            if (!visited[i][j] && matrix[i][j] == 1) {
                runDfs(matrix, i,j, visited)
                counter++
            }
        }
    }

    counter

}

private def runDfs(Integer[][] matrix, int row, int column, boolean [][] visited) {
    int initialValue = matrix[row][column]
    visited[row][column] = true

   for(Neighbor n : getAllNeighbors(matrix, row, column)) {
       if (n.value == initialValue && !visited[n.row][n.column]) {
           visited[n.row][n.column] = true
           runDfs(matrix, n.row, n.column, visited)
       }
   }
}


private List<Neighbor> getAllNeighbors(Integer[][] matrix, int row, int column) {
    int n = matrix.length
    ArrayList<Neighbor> result = []

    int[] additionalRows = [-1,-1, 0, 1, 1, 1, 0, -1]
    int[] additionalColumns = [0,+1, 1, 1, 0, -1, -1, -1]

    for (int i = 0; i < 8; i++) {
        def computedRow = row + additionalRows[i];
        def computedColumn = column + additionalColumns[i]
        if (isSafe(matrix, computedRow, computedColumn)) {
            result << new Neighbor(value: matrix[computedRow][computedColumn], row: computedRow, column: computedColumn)
        }
    }

    result
}

private boolean isSafe(Integer[][] matrix, int row, int column) {
    int n = matrix.length

    if ( row >= 0  && row < n && column >= 0 && column < n)
        return true
    else
        return false
}

println findNumberOfIslands( (Integer[][])[
        [1, 1, 0, 0, 0],
        [0, 1, 0, 0, 1],
        [1, 0, 0, 1, 1],
        [0, 0, 0, 0, 0],
        [1, 0, 1, 0, 1]
].toArray())
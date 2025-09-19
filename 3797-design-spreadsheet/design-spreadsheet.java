class Spreadsheet {

private Map<String,Integer> cells;
private int rows;
    public Spreadsheet(int rows) {
        this.rows=rows;
        this.cells=new HashMap<>();
        
    }
    
    public void setCell(String cell, int value) {
        cells.put(cell,value);
        
    }
    
    public void resetCell(String cell) {
        cells.put(cell,0);
        
    }
    
    public int getValue(String formula) {
        String ex=formula.substring(1);
        String [] parts=ex.split("\\+");

        int sum=0;
        for(String part:parts)
        {
            if(Character.isDigit(part.charAt(0)))
            {
                sum +=Integer.parseInt(part);
            }else
            {
                sum +=cells.getOrDefault(part,0);
            }
        }
        return sum;
        
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
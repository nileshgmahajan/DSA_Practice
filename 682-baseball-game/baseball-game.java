class Solution {
    public int calPoints(String[] ops) {
        List<Integer> stack = new ArrayList<>();

        for (String op : ops) {
            if (op.equals("C")) {
                stack.remove(stack.size() - 1);
            } else if (op.equals("D")) {
                stack.add(stack.get(stack.size() - 1) * 2);
            } else if (op.equals("+")) {
                int size = stack.size();
                stack.add(stack.get(size - 1) + stack.get(size - 2));
            } else {
                stack.add(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int num : stack) sum += num;

        return sum;
    }
}

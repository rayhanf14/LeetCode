class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(need1 == 0 && need2 == 0){
            return 0;
        }
        long c1 = (long) need1 * cost1 + (long) need2 * cost2;
        long n = Math.min(need1, need2);
        long c2 = n * costBoth + + (long) (need1 - n) * cost1 + (long) (need2 - n) * cost2;
        long c3 = (long) Math.max(need1, need2) * costBoth;
        return Math.min(c1, Math.min(c2, c3));

    }
}
import java.util.*;

class MovieRentingSystem {

    private static class MovieEntry implements Comparable<MovieEntry> {
        int price, shop, movie;

        MovieEntry(int price, int shop, int movie) {
            this.price = price;
            this.shop = shop;
            this.movie = movie;
        }

        @Override
        public int compareTo(MovieEntry other) {
            if (this.price != other.price) return this.price - other.price;
            if (this.shop != other.shop) return this.shop - other.shop;
            return this.movie - other.movie;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof MovieEntry)) return false;
            MovieEntry other = (MovieEntry) o;
            return this.price == other.price && this.shop == other.shop && this.movie == other.movie;
        }

        @Override
        public int hashCode() {
            return Objects.hash(price, shop, movie);
        }
    }

    // Map movieId -> TreeSet of unrented copies (sorted by price, shop)
    private Map<Integer, TreeSet<MovieEntry>> unrented;
    // TreeSet of rented movies (sorted by price, shop, movie)
    private TreeSet<MovieEntry> rented;
    // Map (shop, movie) -> price
    private Map<String, Integer> priceMap;

    public MovieRentingSystem(int n, int[][] entries) {
        unrented = new HashMap<>();
        rented = new TreeSet<>();
        priceMap = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            unrented.computeIfAbsent(movie, k -> new TreeSet<>()).add(new MovieEntry(price, shop, movie));
            priceMap.put(shop + "," + movie, price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!unrented.containsKey(movie)) return res;

        TreeSet<MovieEntry> set = unrented.get(movie);
        int count = 0;
        for (MovieEntry me : set) {
            if (count == 5) break;
            res.add(me.shop);
            count++;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "," + movie);
        MovieEntry me = new MovieEntry(price, shop, movie);
        unrented.get(movie).remove(me);
        rented.add(me);
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "," + movie);
        MovieEntry me = new MovieEntry(price, shop, movie);
        rented.remove(me);
        unrented.get(movie).add(me);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (MovieEntry me : rented) {
            if (count == 5) break;
            res.add(Arrays.asList(me.shop, me.movie));
            count++;
        }
        return res;
    }
}

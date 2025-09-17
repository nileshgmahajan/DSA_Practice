class FoodRatings {


private Map<String,String> foodToCuisine;
private Map<String,Integer> foodToRating ;
private Map<String,TreeSet<Food>> cuisineToFood;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        foodToCuisine=new HashMap<>();
        foodToRating=new HashMap<>();

        cuisineToFood=new HashMap<>();

        for(int i=0;i<foods.length;i++)
        {
            String food=foods[i];
            String cuisine=cuisines[i];
            int rating=ratings[i];

            foodToCuisine.put(food,cuisine);
            foodToRating.put(food,rating);

            cuisineToFood.computeIfAbsent(cuisine,k->new TreeSet<>())
            .add(new Food(food,rating));
        }
        
    }
    
    public void changeRating(String food, int newRating) {

        String cuisine=foodToCuisine.get(food);
        int oldRating=foodToRating.get(food);

        cuisineToFood.get(cuisine).remove(new Food(food,oldRating));

        foodToRating.put(food,newRating);

        cuisineToFood.get(cuisine).add(new Food(food,newRating));
        
    }
    
    public String highestRated(String cuisine) {
        return cuisineToFood.get(cuisine).first().name;
        
    }
    private static class Food implements Comparable<Food>
    {
        String name;
        int rating;

        Food(String name,int rating)
        {
            this.name=name;
            this.rating=rating;
        }
        public int compareTo(Food other)
        {
            if(this.rating != other.rating)
            {
                return Integer.compare(other.rating,this.rating);
            }
            return this.name.compareTo(other.name);
        }

        public boolean equals(Object o)
        {
            if(this==o)return true;

            if(!(o instanceof Food)) return false;
            Food food=(Food) o;

            return name.equals(food.name) && rating==food.rating;

        }
        public int hashCode()
        {
            return Objects.hash(name,rating);
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
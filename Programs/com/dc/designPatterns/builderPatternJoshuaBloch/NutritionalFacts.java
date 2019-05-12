package Programs.com.dc.designPatterns.builderPatternJoshuaBloch;

//Best Way to Create BuilerPattern
public class NutritionalFacts {

    private int servingSize;
    private int servings;
    private int calories;
    private int fats;
    private int sodium;
    private int carbs;

    //static class for Builder
    public static class Builder{
        //Required Values
        private int servingSize;
        private int servings;

        //optional parameters
        private int calories=0;
        private int fats=0;
        private int sodium=0;
        private int carbs=0;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            this.calories = val;
            return this;
        }

        public Builder fats(int val){
            this.fats = val;
            return this;
        }

        public Builder carbs(int val){
            this.carbs = val;
            return this;
        }

        public Builder sodium(int val){
            this.fats = val;
            return this;
        }

        public NutritionalFacts build(){
            return new NutritionalFacts(this);
        }
    }

    private NutritionalFacts(Builder builder){
        servingSize= builder.servingSize;
        servings = builder.servings;
        fats = builder.fats;
        carbs = builder.carbs;
        calories = builder.calories;
        sodium = builder.sodium;
    }

    @Override
    public String toString() {
        return "NutritionalFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fats=" + fats +
                ", sodium=" + sodium +
                ", carbs=" + carbs +
                '}';
    }
}

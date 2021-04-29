package racing.domain.display;

public class NumberPlate {

    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    private NumberPlate(String inputName) {
        this.name = inputName;
    }


    public Integer length() {
        return this.name.length();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static NumberPlate create(String name) {

        if (name == null) {
            throw new NullPointerException();
        }

        String filterName = name.trim();
        filterName = filterName.replaceAll("\\p{Z}", "");

        if (filterName.length() < MIN_NAME_LENGTH || filterName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }

        return new NumberPlate(filterName);

    }


}

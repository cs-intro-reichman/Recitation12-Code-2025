// TOPIC: Enum with constructor and methods

public enum TitleEnum {
    SIR("Sir"),
    LADY("Lady");

    private final String title;

    TitleEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}

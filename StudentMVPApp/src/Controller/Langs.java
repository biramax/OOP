package Controller;

// Доступные языки вывода списка студентов
public enum Langs {
    RUS ("Русский"),
    ENG ("Английский");

    public final String label;

    private Langs (String label) {
        this.label = label;
    }

    // Выбранный язык
    public static String lang = "RUS";
}



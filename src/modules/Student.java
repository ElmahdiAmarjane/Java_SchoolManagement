package modules;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty attendanceStatus;

    public Student(String id, String name) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.attendanceStatus = new SimpleStringProperty("Absent"); // Valeur par défaut
    }

    // Getter pour l'ID
    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    // Getter pour le nom
    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    // Getter et Setter pour le statut de présence
    public String getAttendanceStatus() {
        return attendanceStatus.get();
    }

    public void setAttendanceStatus(String status) {
        this.attendanceStatus.set(status);
    }

    public StringProperty attendanceStatusProperty() {
        return attendanceStatus;
    }
}

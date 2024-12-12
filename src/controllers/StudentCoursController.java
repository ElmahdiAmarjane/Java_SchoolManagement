package controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import application.Main;
import dao.CourseDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modules.Course;
import modules.User;

public class StudentCoursController {

	private  CourseDao courseDao = new CourseDao();
    @FXML
    private ScrollPane coursScrollPane; // Connect to FXML

    @FXML private VBox mainContainer;


    public void initialize() {
        // Set mainContainer as the content of the ScrollPane
        coursScrollPane.setContent(mainContainer);

        User connectedUser = (User) Main.get("connectedUser");
         System.out.println("HIIII : "+connectedUser.toString());
         
        // Example Data
        Map<String, List<Course>> groupedCourses = fetchGroupedCourses("");

        for (Map.Entry<String, List<Course>> entry : groupedCourses.entrySet()) {
            String elementName = entry.getKey();
            List<Course> courses = entry.getValue();

            // Create a styled container for each category (e.g., Economics, Literature)
            VBox categoryContainer = new VBox(15);
            categoryContainer.setStyle("-fx-background-color: #f4f4f9; -fx-padding: 15; -fx-border-radius: 10px;");
            categoryContainer.setPrefWidth(700);
            
            // Title for the category
           

            // Create a VBox for each course in this category
            for (Course course : courses) {
                VBox courseItem = new VBox(10);
                courseItem.setStyle("-fx-background-color: #ffffff; -fx-padding: 10; -fx-border-radius: 5px; -fx-border-color: #ddd;");
              //  courseItem.setPrefWidth(650);
                courseItem.setMaxWidth(Double.MAX_VALUE);

                // Course Title
                Label courseTitle = new Label("Title: " + course.getTitle());
                courseTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
                courseTitle.setStyle("-fx-text-fill: #34495e;");

                // Description
                Label courseDescription = new Label("Description: " + course.getDescription());
                courseDescription.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
                courseDescription.setStyle("-fx-text-fill: #7f8c8d;");

                // Create buttons for files
                String[] files = course.getFiles().split(", "); // Assuming files are comma-separated
                HBox fileButtonsBox = new HBox(10); // Horizontal box for file buttons
                for (String file : files) {
                	Button fileButton = new Button(file);
                    fileButton.setStyle(
                        "-fx-background-color: #3498db; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 12px; " +
                        "-fx-padding: 5px 8px; " +
                        "-fx-border-radius: 20px; " +
                        "-fx-border-color: transparent;"
                    );

                    // Hover effect
                    fileButton.setOnMouseEntered(e -> fileButton.setStyle(
                        "-fx-background-color: #2980b9; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 12px; " +
                        "-fx-padding: 5px 8px; " +
                        "-fx-border-radius: 20px; " +
                        "-fx-border-color: transparent;"));
                    fileButton.setOnMouseExited(e -> fileButton.setStyle(
                        "-fx-background-color: #3498db; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 12px; " +
                        "-fx-padding: 5px 8px; " +
                        "-fx-border-radius: 20px; " +
                        "-fx-border-color: transparent;"));

                    fileButton.setOnAction(e -> downloadFile(file)); // Trigger download on click
                    fileButtonsBox.getChildren().add(fileButton);
                }

             // Type
                Label courseType = new Label("Type: " + course.getType());
                courseType.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
                courseType.setStyle("-fx-text-fill: #7f8c8d;");

                // Date publication
                Label courseDatePub = new Label("" + course.getDatePublication());
                courseDatePub.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
                courseDatePub.setStyle("-fx-text-fill: #7f8c8d;");

                // Create HBox to hold both labels
                HBox typeAndDate = new HBox();
                typeAndDate.setMaxWidth(Double.MAX_VALUE);
                typeAndDate.setSpacing(10); // Optional: Set spacing between labels
                HBox.setHgrow(courseType, Priority.ALWAYS); // Allow courseType to take up available space
                typeAndDate.getChildren().addAll(courseType, courseDatePub);

                // Align courseDatePub to the far right
                HBox.setHgrow(courseDatePub, Priority.NEVER); // Prevent the date from growing and push it to the right
                typeAndDate.setStyle("-fx-alignment: CENTER_LEFT;"); // Aligns both elements to the left of the HBox

                // Add all course details to the VBox
                courseItem.getChildren().addAll(courseTitle, courseDescription, fileButtonsBox, typeAndDate);
                
                // Add course VBox to the category container
                categoryContainer.getChildren().add(courseItem);
            }

            // Create a TitledPane for the category with the course container
            TitledPane titledPane = new TitledPane();
            titledPane.setText(elementName);
            titledPane.setContent(categoryContainer);
            titledPane.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #2980b9;");

            // Add TitledPane to the main container (ScrollPane content)
            mainContainer.getChildren().add(titledPane);
        }
    }

    private Object downloadFile(String file) {
		// TODO Auto-generated method stub
		return null;
	}

	// Example Data Model
    private Map<String, List<Course>> fetchGroupedCourses(String Filliere_title) {
        // Replace with real data fetching
        List<Course> courses = courseDao.selectCoursesByFilliere(8); // 10 is filier ID
        System.out.println(courses);

        // Group the courses by their category (e.g., "Mathematics", "Network")
        return courses.stream()
                .collect(Collectors.groupingBy(course -> course.getTitle()));
    }
    
    public void setAnnoncesListToFront() {
        // Your logic here
    }
    public void refrechAnnoncesWidgets() {
        // Your logic here
    }
}

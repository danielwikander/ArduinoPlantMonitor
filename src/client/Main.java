package client;

import client.controllers.ChangeViewController;
import client.controllers.ConfirmRemoveDialogController;
import client.controllers.ConnectionController;
import client.controllers.GraphViewController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import models.Plant;

import java.io.IOException;

/**
 * Sets all JavaFX views and starts the application.
 * @author Eric, David, Anton, Daniel.
 */
public class Main extends Application {

	private static Stage primaryStage;
	private static BorderPane mainLayout;
	private static String user;
	@FXML
	private static Image applicationIcon = new Image("client/images/smallIcon.png");

	/**
	 * Starts applications primary stage and presents the login view.
	 * Closes socket when the primary stage is closed.
	 * @param primaryStage	The primary view to present.
	 * @throws IOException	Throws exception if the stage is invalid.
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		Main.primaryStage = primaryStage;
		Main.primaryStage.setTitle("Arduino Plant Monitor");
		Main.primaryStage.getIcons().add(applicationIcon);
		showLoginView();
		Main.primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                ConnectionController cc = ConnectionController.getInstance();
                if(cc.isServerAvailable() ) {
					cc.closeSocket();
				}
            }
        });
	}

	/**
	 * Presents the login view.
	 * A window where users can log in.
	 * @throws IOException	Throws if the loader cannot load the LoginView.
	 */
	public static void showLoginView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/LoginView.fxml"));
		BorderPane loginLayout = loader.load();
		Scene scene = new Scene(loginLayout);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Presents the new user view.
	 * A window where users can create a new account.
	 * @throws IOException	Throws if the loader cannot load the NewUserView.
	 */
	public static void showNewUserView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/NewUserView.fxml"));
		BorderPane newUserLayout = loader.load();
		Scene scene = new Scene(newUserLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Presents the main view.
	 * @throws IOException	Throws if the loader cannot load the MainView.
	 */
	public static void showMainView() {
		Platform.runLater(() -> {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("views/MainView.fxml"));
			try {
				mainLayout = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.setResizable(true);
			primaryStage.show();
			try {
				showStartView();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Presents the start view.
	 * @throws IOException	Throws if the loader cannot load the StartView.
	 */
	public static void showStartView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/StartView.fxml"));
		BorderPane startLayout = loader.load();
		mainLayout.setCenter(startLayout);
	}

	/**
	 * Presents the add view.
	 * @throws IOException	Throws if the loader cannot load the AddView.
	 */
	public static void showAddView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/AddView.fxml"));
		BorderPane addLayout = loader.load();
		mainLayout.setCenter(addLayout);
	}

	/**
	 * Presents the change view.
	 * @throws IOException	Throws if the loader cannot load the ChangeView.
	 */
	public static void showChangeView(Plant plant) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/ChangeView.fxml"));
		BorderPane changeLayout = loader.load();
		mainLayout.setCenter(changeLayout);
		ChangeViewController cvc = loader.getController();
		cvc.initialize(plant);
	}

	/**
	 * Presents the graph view.
	 * @throws IOException	Throws if the loader cannot load the GraphView.
	 */
	public static void showGraphView(Plant plant) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/GraphView.fxml"));
		BorderPane graphLayout = loader.load();
		mainLayout.setCenter(graphLayout);
		GraphViewController gvc = loader.getController();
		gvc.initialize(plant);
	}

	/**
	 * Presents the confirm remove dialog.
	 * It's a popup-window where users need to confirm if
	 * they wish to remove a plant.
	 * @param plant			The plant they wish to remove.
	 * @throws IOException	Thrown if the loader can't load the confirmRemoveDialog.
	 */
	public static void showConfirmRemoveDialog(Plant plant) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/ConfirmRemoveDialog.fxml"));
		BorderPane confirmRemoveDialogLayout = loader.load();
		Scene scene = new Scene(confirmRemoveDialogLayout);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Är du säker?");
		stage.setScene(scene);
		stage.getIcons().add(applicationIcon);
		ConfirmRemoveDialogController crdc = loader.getController();
		crdc.initialize(plant);
		stage.show();
	}

	/**
	 * Sets the logged in user.
	 * @param email	The email of the logged in user.
	 */
	public static void setLoggedInUser(String email) {
		user = email;
	}

	/**
	 * Returns the logged in user.
	 * @return	The email of the logged in user.
	 */
	public static String getLoggedInUser() {
		return user;
	}	
	
	/**
	 * Launches the application.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
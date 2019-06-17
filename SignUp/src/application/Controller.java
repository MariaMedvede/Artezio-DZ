package application;

	import java.io.IOException;
import java.net.URL;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ResourceBundle;
	import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
import javafx.stage.Stage;

	import javafx.scene.text.Text;
	import application.DatabaseHandler;

	import static application.DatabaseHandler.getDbConnection;

public class Controller {

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField LoginField;

	    @FXML
	    private PasswordField PasswordField;

	    @FXML
	    private Button enterButton;

	    @FXML
	    private Button SingUpButton;

	    @FXML
		private Text AuthText;

	private void LoginUser(String loginText, String loginPassword) {//GEN-FIRST:event_jButton_LoginActionPerformed
		ResultSet rs;

		//create a select query to check if the username and the password exist in the database
		String query = "SELECT * FROM users WHERE Login = ? AND Password = ?";

		try {

			PreparedStatement st = getDbConnection().prepareStatement(query);

			st.setString(1, loginText);
			st.setString(2, loginPassword);
			rs = st.executeQuery();

			if (rs.next()) {

				//открывается меню (надо сделать)
				String level = "select AccessLevel from users where login = " + "'" + loginText + "'";
				 st = getDbConnection().prepareStatement(query);

				ResultSet res = st.executeQuery(level);
				String AccessLevel;
				while (res.next()) {
					 AccessLevel = res.getString("AccessLevel");

				if (AccessLevel.equals("Аналитик")) { //аналитик

				} else if (AccessLevel.equals("Администратор")) { //админ
				}
			else { //пользователь
					enterButton.getScene().getWindow().hide();
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("/application/main.fxml"));
					try {
						loader.load();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Parent root = loader.getRoot();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.showAndWait();
			}}
		}else{
			// error message
			AuthText.setText("Invalid Login or Password");

		}

		} catch (SQLException ex) {
			System.out.println("Error SQL");
		} catch (ClassNotFoundException ex)
		{
			System.out.println("Error class");
		}

	}
	    @FXML
	    void initialize() {
	        enterButton.setOnAction(event -> {

	        	String loginText = String.valueOf(LoginField.getText());
						/*if(loginText.equals(""))
						{loginText = "login";}
						loginText.trim();*/

				String loginPassword =  String.valueOf(PasswordField.getText()).trim();
				/*if(loginPassword.equals(""))
				{loginPassword = "password";}
				loginPassword.trim();*/

	        	if(!loginText.equals("")&&!loginPassword.equals(""))
	        	{
	        		LoginUser(loginText, loginPassword);
	        	}
	        	else
				{AuthText.setText("Login and password is empty");}
	        });

	    	SingUpButton.setOnAction(event -> {
	    		SingUpButton.getScene().getWindow().hide();
	    		FXMLLoader loader = new FXMLLoader();
	    		loader.setLocation(getClass().getResource("/application/registration.fxml"));
	    		try {
					loader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    		Parent root = loader.getRoot();
	    		Stage stage = new Stage();
	    		stage.setScene(new Scene(root));
	    		stage.showAndWait();
	    	});

	    }
}


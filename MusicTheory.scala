/* MusicTheory.scala creates the GUI for the project
 *
 * For CS 214, at Calvin College.
 * Completed by: Sarah Griffioen
 * Date: 05/14/18
 **********************************************************/

 package MusicProgram

 import notes.Notes
 import operations.Operations

 import scalafx.Includes._
 import scalafx.application.JFXApp
 import scalafx.application.JFXApp.PrimaryStage
 import scalafx.geometry.Pos
 import scalafx.scene.Scene
 import scalafx.scene.paint.Color._
 import scalafx.scene.paint._
 import scalafx.scene.text.{Font, FontWeight}
 import scalafx.scene.control.{Button, Label, TextField}
 import scalafx.event.ActionEvent

 object MusicTheory extends JFXApp {

  stage = new PrimaryStage {

    title = "Music Theory Program"
    scene = new Scene(600, 400) {

      // set window color
      fill = Color.rgb(188, 188, 188)

      // title of program
      val label1 = new Label("Music Theory Fun!")
      label1.layoutX = 20
      label1.layoutY = 20
      label1.setFont(new Font("Impact", 50.0));
      label1.setStyle("-fx-font-weight: bold")
      label1.setStyle("-fx-underline: true")

      // prompt user to pick what they want to do
      val label2 = new Label("Pick which music theory option you would like to continue.")
      label2.layoutX = 20
      label2.layoutY = 100

      // create a button for the scale-naming option
      val scale_button = new Button("Scale Naming")
      scale_button.layoutX = 20
      scale_button.layoutY = 140

      // create a button for the chord-naming option
      val chord_button = new Button("Chord Naming")
      chord_button.layoutX = 200
      chord_button.layoutY = 140

      // put the different components on the screen
      content = List(label1, label2, scale_button, chord_button)

      /*
       * handle action when scale-naming button is pressed
       */
       scale_button.onAction = handle => {

        // update labels
        label1.text = "Scale Naming"
        label2.text = "Please enter the notes of a scale separated by spaces. (8 notes)"

        // create a textField for scale input
        val textField = new TextField
        textField.layoutX = 20
        textField.layoutY = 160
        textField.promptText = "e.g. F G A Bb C D E F"

        // create label to hold answers
        val label3 = new Label("e.g. F G A Bb C D E F")
        label3.layoutX = 20
        label3.layoutY = 210

        // create a button for going back to the previous page
        val back_button = new Button("Back")
        back_button.layoutX = 20
        back_button.layoutY = 350

        // create a button for quitting the program
        val quit_button = new Button("Quit Program")
        quit_button.layoutX = 480
        quit_button.layoutY = 350

        // put the different components on the screen
        content = List(label1, textField, label2, label3, back_button, quit_button)

        // handle action when user inputs scale
        textField.onAction = handle => {

          // get input string and split it
          val aString: String = textField.text.apply
          val nameList: List[String] = aString.split(" ").map(_.trim).toList
          val length = nameList.length

          // if the input is valid, print out scale name to screen
          val note_class = new Notes(nameList)
          if ((note_class.is_valid == "invalid") || (length != 8)) {
            label3.text = "ERROR: invalid input"
          } else {
            val op_class = new Operations(nameList)
            label3.text = op_class.create_scale
          }
        }

        // handle action when back button is pressed
        back_button.onAction = handle => {
          label1.text = "Music Theory Fun!"
          label2.text = "Pick which music theory option you would like to execute."
          content = List(label1, label2, scale_button, chord_button)
        }

        // handle action when quit button is pressed
        quit_button.onAction = handle => {
          System.exit(0);
        }
      }

      /*
       * handle action when chord-naming button is pressed
       */
       chord_button.onAction = handle => {

        // update labels
        label1.text = "Chord Naming"
        label2.text = "Please enter the notes of a chord separated by spaces."

        // create a textField for chord input
        val textField = new TextField
        textField.layoutX = 20
        textField.layoutY = 160
        textField.promptText = "e.g. A C# E"

        // create label to hold answers
        val label3 = new Label("e.g. A C# E")
        label3.layoutX = 20
        label3.layoutY = 210

        // create a button for going back to the previous page
        val back_button = new Button("Back")
        back_button.layoutX = 20
        back_button.layoutY = 350

        // create a button for quitting the program
        val quit_button = new Button("Quit Program")
        quit_button.layoutX = 480
        quit_button.layoutY = 350

        // put the different components on the screen
        content = List(label1, textField, label2, label3, back_button, quit_button)

        // handle action when user inputs chord
        textField.onAction = handle => {

          // get input string and split it
          val aString: String = textField.text.apply
          val nameList: List[String] = aString.split(" ").map(_.trim).toList
          val length = nameList.length

          // if the input is valid, print out chord name to screen
          val note_class = new Notes(nameList)
          if ((note_class.is_valid == "invalid") || (length < 3) || (length > 4)) {
            label3.text = "ERROR: invalid input"
            // System.exit(0)
          } else {
            val op_class = new Operations(nameList)
            // print out chord based on length and kind
            if (length == 3) {
              label3.text = op_class.create_triad
            } else {
              label3.text = op_class.create_seventh_chord
            }
          }
        }

        // handle action when back button is pressed
        back_button.onAction = handle => {
          label1.text = "Music Theory Fun!"
          label2.text = "Pick which music theory option you would like to execute."
          content = List(label1, label2, scale_button, chord_button)
        }

        // handle action when quit button is pressed
        quit_button.onAction = handle => {
          System.exit(0);
        }
      }
    }
  }
}



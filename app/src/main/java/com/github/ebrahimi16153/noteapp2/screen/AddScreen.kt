package com.github.ebrahimi16153.noteapp2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.ebrahimi16153.noteapp2.component.InputText
import com.github.ebrahimi16153.noteapp2.component.NoteButton
import com.github.ebrahimi16153.noteapp2.model.Note

@Composable
fun AddScreen(navController: NavController, onAdd: (Note) -> Unit) {
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    Scaffold(topBar = {
        // topBar
        TopAppBar() {
            Text(
                text = "Add Note",
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                style = MaterialTheme.typography.subtitle1
            )

        }
    }) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            InputText(text =title, label = "Title", maxLine = 1) { onText ->
                if (onText.all {
                        it.isWhitespace() || it.isLetter()
                }) {
                    title = onText
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
             InputText(text = description, label ="description" , maxLine =1 , onTextChange = { onText ->

                 if (onText.all {
                         it.isLetter() || it.isWhitespace()
                     }) {
                     description = onText
                 }
             } )
            Spacer(modifier = Modifier.height(8.dp))
            NoteButton(title = "Save") {

                if (description.isNotEmpty() && title.isNotEmpty()) {
                    onAdd(Note(title = title, description = description))
                    navController.popBackStack()
                }

            }

        }

    }
}
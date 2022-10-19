package com.github.ebrahimi16153.noteapp2.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.ebrahimi16153.noteapp2.model.Note
import com.github.ebrahimi16153.noteapp2.navigation.ScreenName

@Composable
fun ListScreen(navController: NavController, list:List<Note>, onRemove: (Note) -> Unit) {
    Scaffold(topBar = {
        // topBar
        TopAppBar() {
            Text(
                text = "Note",
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                style = MaterialTheme.typography.subtitle1
            )

        }
    },
        //FAB
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(ScreenName.AddScreen.name) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add icon")

            }
        }) {
        //list
        LazyColumn(){
            items(list){ note ->
                NoteRow(note = note, onClick = {onRemove(note)} )
            }
        }

    }
}

@Composable
fun NoteRow(note: Note, onClick: (Note) -> Unit){
    Card(
        backgroundColor = MaterialTheme.colors.onPrimary,
        modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { onClick(note)},
    shape = CircleShape.copy(all = CornerSize(8.dp)),

    ) {
        Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {

            Text(text = note.title, style = MaterialTheme.typography.subtitle2)
            Text(text = note.description, style = MaterialTheme.typography.subtitle1)

        }

    }
}


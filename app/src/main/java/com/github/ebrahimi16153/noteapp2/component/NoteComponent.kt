package com.github.ebrahimi16153.noteapp2.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int,
    onImeAction: () -> Unit ={},
    onTextChange: (String) -> Unit,


) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent
        ),
        maxLines = maxLine,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        label = { Text(text = label) },
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()

        })


    )

}


@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    title: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        onClick = onClick,
        enabled = enabled
    ) {

        Text(text = title)
    }

}

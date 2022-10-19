package com.github.ebrahimi16153.noteapp2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.github.ebrahimi16153.noteapp2.model.Note
import com.github.ebrahimi16153.noteapp2.screen.AddScreen
import com.github.ebrahimi16153.noteapp2.screen.ListScreen

@Composable
fun NoteNavigation(){
    //nav controller
 val navController = rememberNavController()
    //list
    val list = remember { mutableStateListOf<Note>() }
    //navHost and navGraph
  NavHost(navController = navController, startDestination = ScreenName.ListScreen.name ){
      composable(ScreenName.ListScreen.name){
          ListScreen(navController = navController,list=list){
              list.remove(it)
          }
      }

      composable(ScreenName.AddScreen.name){
          AddScreen(navController = navController){ note ->
              list.add(note)
          }
      }
  }
}
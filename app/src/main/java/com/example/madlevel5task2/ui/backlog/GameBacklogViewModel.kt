package com.example.madlevel5task2.ui.backlog

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.madlevel5task2.database.GameRepository
import com.example.madlevel5task2.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GameBacklogViewModel(application: Application) : AndroidViewModel(application) {

    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)
    val gameBacklog =
        gameRepository.getGames()
    val successDeleteGameBacklog = MutableLiveData<List<Game>>()
    val successDeleteGame = MutableLiveData<Game>()

    fun deleteGame(game: Game) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.delete(game)
            }
            successDeleteGame.value = game
        }
    }

    /**
     * Delete the game backlog from the repository.
     */
    fun deleteGameBacklog() {
        mainScope.launch {
            val games = gameBacklog.value
            withContext(Dispatchers.IO) {
                gameRepository.deleteAll()
            }
            successDeleteGameBacklog.value = games
        }
    }

    fun addGameBacklog(games: List<Game>) {
        mainScope.launch {
            gameRepository.insert(games)
        }
    }

    fun addGame(game: Game) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.insert(game)
            }
        }
    }
}
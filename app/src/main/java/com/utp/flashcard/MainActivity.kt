package com.utp.flashcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.utp.flashcard.Navigation.NavGraph
import com.utp.flashcard.database.AppDatabase
import com.utp.flashcard.database.entities.Card
import com.utp.flashcard.database.entities.Pack
import com.utp.flashcard.database.entities.User
import com.utp.flashcard.ui.theme.FlashCardTheme
import java.util.Date
import com.utp.flashcard.database.entities.Collection

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            FlashCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConentApp()
                }
            }
        }

        //intacia de bases de datos



        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "flashCardDB").allowMainThreadQueries().build()

        val userDAO = db.userDAO()
        val collectionDAO = db.collectionDAO()
        val packDAO = db.packDAO()
        val cardDAO = db.cardDAO()

        val currentDate = Date()


        val user1 = User ("Wilfredo","El perro del desierto", currentDate.toString())
        val user1ID = userDAO.insert(user1)

        val collection1 = Collection ("Collection Default",user1ID.toInt(),currentDate.toString())
        val collection1ID = collectionDAO.insert(collection1)

        val pack1 = Pack( "Pack Default", collection1ID.toInt(), currentDate.toString())
        val pack1ID = packDAO.insert(pack1)

        val card1 = Card("¿Cuál es mi nombre?","Wilfredo Batista",pack1ID.toInt(),currentDate.toString())
        cardDAO.insert(card1)

        val card2 = Card("¿A qué universidad asistes?", "UNIVERSIDAD TECNOLÓGICA DE PANAMÁ",pack1ID.toInt(), currentDate.toString())
        cardDAO.insert(card2)

        val card3 = Card("¿Cuál es esta materia?","Desarrollo de Software 6",pack1ID.toInt(),currentDate.toString())
        cardDAO.insert(card3)

        val card4 = Card("¿Cuál es el nombre del nuevo presidente de Panamá para el período 2024-2029?","José Raúl Mulino", pack1ID.toInt(),currentDate.toString())
        cardDAO.insert(card4)

        val card5 = Card("¿Cuál es el nombre del Rector de la UTP para el período 2023-2028?","Dr. Omar Olmedo Aizpurúa Pino",pack1ID.toInt(),currentDate.toString() )
        cardDAO.insert(card5)


    }
}
@Composable
fun ConentApp() {
    val navController = rememberNavController()
    NavGraph(navController = navController)
}


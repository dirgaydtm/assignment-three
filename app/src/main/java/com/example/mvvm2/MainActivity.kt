package com.example.mvvm2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm2.model.User
import com.example.mvvm2.model.users
import com.example.mvvm2.ui.theme.Mvvm2Theme
import com.example.mvvm2.view.allUser
import com.example.mvvm2.view.detail

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mvvm2Theme {
                val navController = rememberNavController()
                val userViewModel: UserViewModel = viewModel()

                NavHost(navController = navController, startDestination = NavDestination.List)
                {
                    composable(NavDestination.List)
                    {
                        allUser(users, onItemClicked = {
                            userViewModel.setUser(it.id, it.name)
                            navController.navigate(NavDestination.Detail)
                        })
                    }
                    composable(NavDestination.Detail)
                    {
                        detail(
                            user = User(
                                id = userViewModel.user.collectAsState().value.id,
                                name = userViewModel.user.collectAsState().value.name,
                                username = "username",
                                email = "email"
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mvvm2Theme {
        //allUser(users)
    }
}
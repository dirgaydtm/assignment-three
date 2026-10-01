package com.example.mvvm2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    val userViewModel: UserViewModel = viewModel()

                    NavHost(
                        navController = navController,
                        startDestination = NavDestination.List,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(NavDestination.List) {
                            allUser(users, onItemClicked = { selectedUser ->
                                userViewModel.setUser(selectedUser)
                                navController.navigate(NavDestination.Detail)
                            })
                        }
                        composable(NavDestination.Detail) {
                            val selectedUser = userViewModel.user.collectAsState().value
                            detail(user = selectedUser)
                        }
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
        allUser(users, onItemClicked = {})
    }
}
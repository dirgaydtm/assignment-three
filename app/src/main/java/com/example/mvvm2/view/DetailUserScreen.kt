package com.example.mvvm2.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvvm2.model.User

@Composable
fun detail(user: User) {
    Column(modifier = Modifier.padding(50.dp)) {
        Text(text = "id = " + user.id.toString())
        Text(text = "nama = " + user.name)
        Text(text = "email = " + user.email)
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun detailPreview() {
    detail(User(1, "name", "username", "email@email.com"))
}
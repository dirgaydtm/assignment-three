package com.example.mvvm2.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mvvm2.R
import com.example.mvvm2.model.User

@Composable
fun userCard(user:User, onClick: (User) -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick(user) },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row {
            Image(
                painter = painterResource(R.drawable.profile_picture),
                contentDescription = "profile",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Column(Modifier.padding(10.dp))
            {
                Text(
                    text = user.id.toString(), style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = user.name, style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = user.email, style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
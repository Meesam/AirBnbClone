package com.airbnb.airbnbclone.presentation.search_bar.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun SearchDetailsBottom(){
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Divider (
            color = Color.Gray,
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(text = "Clear All", textDecoration = TextDecoration.Underline)
            Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(20.dp)) {
                Icon(imageVector = Icons.Outlined.Search , tint = Color.White , contentDescription = "Close")
                Text(text = "Search")
            }
        }
    }
}
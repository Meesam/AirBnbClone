package com.airbnb.airbnbclone.presentation.search_bar.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.ClearAll
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.airbnb.airbnbclone.R
import com.airbnb.airbnbclone.presentation.Screen
import com.airbnb.airbnbclone.presentation.search_bar.model.WhereTo

@Composable
fun WhereToScreen(navController: NavController){
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)) {
        Column {
            WhereToScreenHeader(navController)
            LaunchedEffect(key1 = true ){
                expanded = true
            }
            Spacer(modifier = Modifier.height(20.dp))
            WhereToScreenPrimaryBlock(expanded)
            Spacer(modifier = Modifier.height(20.dp))
            WhenBlock(expanded)
            Spacer(modifier = Modifier.height(20.dp))
            WhoBlock(expanded)
        }
    }
}

@Composable
fun WhenBlock(expanded:Boolean){
    Box{
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween   ,
            modifier = Modifier
                .shadow(
                    elevation = 20.dp,
                    shape = RoundedCornerShape(20.dp),
                    clip = true,
                    ambientColor = Color.Black,
                    spotColor = Color.Black
                )
                .background(Color.White)
                .fillMaxWidth()
                .padding(20.dp)
        ){
            Text(
                text = "When",
                fontSize = 16.sp,
                fontFamily = FontFamily.Default,
                color = Color.DarkGray
            )
            Text(
                text = "Any week",
                fontSize = 16.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}
@Composable
fun WhoBlock(expanded:Boolean){
    Box{
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween   ,
            modifier = Modifier
                .shadow(
                    elevation = 20.dp,
                    shape = RoundedCornerShape(20.dp),
                    clip = true,
                    ambientColor = Color.Black,
                    spotColor = Color.Black
                )
                .background(Color.White)
                .fillMaxWidth()
                .padding(20.dp)
        ){
            Text(
                text = "Who",
                fontSize = 16.sp,
                fontFamily = FontFamily.Default,
                color = Color.DarkGray
            )
            Text(
                text = "Add guests",
                fontSize = 16.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}

@Composable
fun WhereToScreenHeader(navController: NavController){
    Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier
        .fillMaxWidth()
    ) {
        Box(contentAlignment= Alignment.Center ,modifier = Modifier
            .border(1.dp, Color.LightGray, shape = CircleShape)
            .size(32.dp)
        ) {
            IconButton(onClick = {
                navController.popBackStack()
                navController.navigate(Screen.ExploreScreen.route)
             }
            ) {
                Icon(imageVector = Icons.Rounded.Close , tint = Color.Black , contentDescription = "Close")
            }
        }
        Spacer(modifier = Modifier.width(40.dp))
        Text(text = "Stays", textDecoration = TextDecoration.Underline, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Experiences", textDecoration = TextDecoration.Underline, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun WhereToScreenPrimaryBlock(expanded:Boolean){
    Box{
        Row(
            verticalAlignment = if(!expanded) Alignment.CenterVertically else Alignment.Top,
            modifier = Modifier
                .shadow(
                    elevation = 20.dp,
                    shape = if (!expanded) RoundedCornerShape(50.dp) else RoundedCornerShape(20.dp),
                    clip = true,
                    ambientColor = Color.Black,
                    spotColor = Color.Black
                )
                .background(Color.White)
                .animateContentSize()
                .height(if (expanded) 300.dp else 70.dp)
                .fillMaxWidth()
                .padding(20.dp)
                .zIndex(1f)
        ){
            Column {
                Text(
                    text = "Where to?",
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Black
                )
                Spacer(modifier = Modifier.height(20.dp))
                AutoComplete()
                Spacer(modifier = Modifier.height(20.dp))
                WhereToList()
            }
        }
    }
}

@Composable
fun WhereToList(){
    val whereToList= listOf(
        WhereTo(title = "I'm flexible"
            //image = Image(painter = painterResource(id = R.drawable.world_map), contentDescription ="")
        ),
        WhereTo(title = "Europe"
            //image = Image(painter = painterResource(id = R.drawable.world_map ), contentDescription ="")
        ),
        WhereTo(title = "United Kingdom"
            //image = Image(painter = painterResource(id = R.drawable.world_map ), contentDescription ="")
        ),
        WhereTo(title = "Southeast Asia"
            //image = Image(painter = painterResource(id = R.drawable.world_map ), contentDescription ="")
        ),
        WhereTo(title = "Canada"
            //image = Image(painter = painterResource(id = R.drawable.world_map ), contentDescription ="")
        ),
        WhereTo(title = "United States"
            //image = Image(painter = painterResource(id = R.drawable.world_map ), contentDescription ="")
        ),
        WhereTo(title = "Indonesia"
            //image = Image(painter = painterResource(id = R.drawable.world_map ), contentDescription ="")
        ),
        WhereTo(title = "Middle East"
            //image = Image(painter = painterResource(id = R.drawable.world_map ), contentDescription ="")
        ),
        WhereTo(title = "Italy"
            //image = Image(painter = painterResource(id = R.drawable.world_map ), contentDescription ="")
        )
    )
    LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        items(whereToList){
            Column {
                Box(modifier = Modifier
                    .border(1.dp,Color.Gray, shape = RoundedCornerShape(10.dp))
                    .size(100.dp)
                ) {
                    //it.image
                    //Text(text = it.title)
                    Image(painter = painterResource(id = R.drawable.world_map ),
                        contentDescription ="",
                        contentScale=ContentScale.FillHeight,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(text = it.title, fontSize = 13.sp)
            }
        }
    }
}
package com.airbnb.airbnbclone.presentation.splash_screen


import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.airbnbclone.presentation.Screen
import com.airbnb.airbnbclone.presentation.ui.theme.AirBnbCloneTheme
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController){
  var startAnimation by remember { mutableStateOf(false) }
  var alphaAnim = animateFloatAsState(
    targetValue = if (startAnimation) 1f else 0f,
    animationSpec = tween(
      durationMillis = 3000
    ),
    label = ""
  )
  
  LaunchedEffect(key1 = true ){
    startAnimation = true
    delay(4000)
    navController.popBackStack()
    navController.navigate(Screen.ExploreScreen.route)
  }
  Splash(alphaAnim.value)
}
@Composable
fun Splash(alpha:Float){
  Box(
    modifier = Modifier
      .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
      .fillMaxSize(),
    contentAlignment = Alignment.Center
  ){
    Icon(
      imageVector = Icons.Filled.Flight,
      contentDescription = "Loading..",
      tint = (if (isSystemInDarkTheme()) Color.White else Color.Black),
      modifier = Modifier.size(120.dp)
        .alpha(alpha)
      )
  }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
  AirBnbCloneTheme {
    Splash(1f)
  }
}
@Preview
@Composable
fun GreetingPreviewLight() {
  AirBnbCloneTheme {
    Splash(1f)
  }
}
package com.airbnb.airbnbclone.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.airbnb.airbnbclone.R


// Set of Material typography styles to start with

/*private val Roboto = FontFamily(
  Font(R.font.roboto_black,FontWeight.W900),
  Font(R.font.roboto_bold,FontWeight.W700),
  Font(R.font.roboto_medium,FontWeight.W500),
  Font(R.font.roboto_regular,FontWeight.W400),
  Font(R.font.roboto_light,FontWeight.W300),
  Font(R.font.roboto_thin,FontWeight.W100),
)*/

val Typography = Typography(
  displayLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W900,
    fontSize = 30.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  ),
  displayMedium = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W700,
    fontSize = 25.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  ),
  displaySmall= TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W500,
    fontSize = 20.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  ),
  headlineLarge= TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W700,
    fontSize = 30.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  ),
  headlineMedium= TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W700,
    fontSize = 25.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  )
)
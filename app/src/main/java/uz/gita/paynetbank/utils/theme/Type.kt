package uz.gita.paynetbank.utils.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(

//  h1 is the largest headline, reserved for short, important text or numerals
    h1 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 96.sp,
        letterSpacing = (-1.5).sp
    ),


//  h2 is the second largest headline, reserved for short, important text or numerals
    h2 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 60.sp,
        letterSpacing = (-0.5).sp
    ),


//  h3 is the third largest headline, reserved for short, important text or numerals
    h3 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        letterSpacing = 0.sp
    ),


//  h4 is the fourth largest headline, reserved for short, important text or numerals.
    h4 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp,
        letterSpacing = 0.25.sp
    ),


//  h5 is the fifth largest headline, reserved for short, important text or numerals
    h5 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        letterSpacing = 0.sp
    ),


//  h6 is the sixth largest headline, reserved for short, important text or numerals
    h6 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp
    ),


//  subtitle1 is the largest subtitle, and is typically reserved for medium-emphasis text that is shorter in length
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
    ),


//  subtitle2 is the smallest subtitle, and is typically reserved for medium-emphasis text that is shorter in length
    subtitle2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    ),


//  body1 is the largest body, and is typically used for long-form writing as it works well for small text sizes
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    ),


//  body2 is the smallest body, and is typically used for long-form writing as it works well for small text sizes.
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),


//  button text is a call to action used in different types of buttons (such as text, outlined and contained buttons) and in tabs, dialogs, and cards
    button = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp
    ),


//  caption is one of the smallest font sizes. It is used sparingly to annotate imagery or to introduce a headline
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp
    ),


//  overline is one of the smallest font sizes. It is used sparingly to annotate imagery or to introduce a headline
    overline = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        letterSpacing = 1.5.sp
    ),
)
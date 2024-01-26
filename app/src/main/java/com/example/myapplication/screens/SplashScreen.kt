package com.example.myapplication.screens

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.graphics.drawable.Animatable
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import kotlinx.coroutines.delay

/** Загрузочный экран. Отображается 1,5 секунды с помощью задержки (delay(1500L))
 * Далее с помощью navController,navigate() запускает страницу LogIn
 *
 * */

@SuppressLint("RememberReturnType")
@Composable
fun SplashScreen(navController: NavHostController) {
    val configuration = LocalConfiguration.current
    if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        // portrait mode
        LaunchedEffect(key1 = true) {
            // Customize the delay time
            delay(1500L)
            navController.navigate("logInScreen") {
                popUpTo("splashScreen")//удаляет страницу и стека, чтобы не было возможности вернуться к этому экрану
                {
                    inclusive = true
                }
            }
        }
        //Верстка, про каждый компонент и свойство о нем, вы можете почитать в moodle
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.gallery),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = "App Name", fontSize = 32.sp,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur", fontSize = 17.sp,
                color = MaterialTheme.colorScheme.secondary
            )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(0.dp, 0.dp, 0.dp, 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        )
        {
            Text(
                text = "Product of Team Name", fontSize = 16.sp,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}


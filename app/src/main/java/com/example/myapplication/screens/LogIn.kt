package com.example.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.RoundCheckBox

@Composable
fun LogIn(navHost: NavHostController) {
    var email: String by rememberSaveable { mutableStateOf("") }
    var password: String by rememberSaveable { mutableStateOf("") }
    val checkedState = remember { mutableStateOf(true) }
    Column(modifier = Modifier.fillMaxSize(1f)) {
        Text(
            text = "Log In", fontSize = 40.sp, color = Color(0xFF1D68FF),
            modifier = Modifier.padding(top = 30.dp, bottom = 50.dp, start = 10.dp)
        )
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomEmail(search = email, onValueChange = {
            })
            CustomPassword(search = password, onValueChange = {
            })
            /*TextField(
                modifier = Modifier.padding(bottom = 10.dp),
                value = email.value,

                onValueChange = { newText -> email.value = newText })
            TextField(
                value = password.value,
                onValueChange = { newText -> password.value = newText })*/
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp,bottom = 15.dp, end = 10.dp), textAlign = TextAlign.End,
            text = "Forget Password?", fontSize = 14.sp, color = Color(0xFF1D68FF)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            var roundCheckBoxState by remember { mutableStateOf(false) }
            RoundCheckBox(
                modifier = Modifier.width(60.dp),
                isChecked = roundCheckBoxState,
                onClick = { roundCheckBoxState = !roundCheckBoxState },
                enabled = true
            )
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0XFFE8EFFF),
                    checkmarkColor = Color(0XFF578FFF)
                )
            )
            Text(text = "Remember Password", fontSize = 14.sp, color = Color(0xFF1D68FF))
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(top = 15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0XFFE8EFFF),
                    contentColor = Color(0xFF1D68FF)
                )
            ) {
                Text(text = "Login")
            }
            Text(
                text = "OR", fontSize = 14.sp, color = Color(0xFF1D68FF),
                modifier = Modifier.padding(vertical = 15.dp)
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly)
            {
                Button(
                    onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0XFFE8EFFF),
                        contentColor = Color(0xFF1D68FF)
                    )
                ) {
                    Text(text = "GOOGLE")
                }
                Button(
                    onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0XFFE8EFFF),
                        contentColor = Color(0xFF1D68FF)
                    )
                ) {
                    Text(text = "FACEBOOK")
                }
            }
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
                text = "Dont’ have an account? Let’s Register",
                fontSize = 16.sp,
                color = Color(0xFF1D68FF)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomEmail(
    search: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0XFFE8EFFF))

    ) {
        TextField(
            value = search,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0XFFE8EFFF),
                focusedIndicatorColor = Color.Black,
                focusedTextColor = Color(0XFF578FFF),
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color(0XFF578FFF),
            ),
            modifier = Modifier.background(Color(0XFFF5F5F9)),
            placeholder = {
                Text(
                    text = "Enter Email / Phone Number",
                    color = Color(0XFF578FFF)
                )
            }
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomPassword(
    search: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0XFFE8EFFF))

    ) {
        TextField(
            value = search,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0XFFE8EFFF),
                focusedIndicatorColor = Color.Black,
                focusedTextColor = Color(0XFF578FFF),
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color(0XFF578FFF),
            ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock, contentDescription = "",
                    tint = Color(0XFF578FFF)
                )
            },
            modifier = Modifier.background(Color(0XFFF5F5F9)),
            placeholder = {
                Text(
                    text = "Password",
                    color = Color(0XFF578FFF)
                )
            }
        )

    }
}
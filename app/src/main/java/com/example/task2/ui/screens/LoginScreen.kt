package com.example.task2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.task2.R

class LoginScreen : Screen {
    @Composable
    override fun Content() {

    }

    @Composable
    private fun LoginScreenContent(
        email: String,
        password: String,
        onEmailChange: (String) -> Unit,
        onPasswordChange: (String) -> Unit
    ) {
        Scaffold { innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start) {
                Spacer(modifier = Modifier.padding(top = 24.dp))
                Text("Login", style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold))
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceAround
            ) {
                Spacer(modifier = Modifier.padding(top = 60.dp))

                Image(painter = painterResource(R.drawable.logominuman), contentDescription = null)

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Selamat Datang",
                        style = TextStyle(
                            fontSize = 40.sp,
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.W600
                        )
                    )
                }

                Spacer(modifier = Modifier.padding(top = 20.dp))



                OutlinedTextField(
                    value = email, onValueChange = onEmailChange,
                    placeholder = {
                        Text(text = "Masukkan email anda")
                    },
                    label = {
                        Text(text = "Email")
                    },
                    leadingIcon = {
                        Icon(Icons.Filled.Email, contentDescription = null)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp)
                )
                Spacer(modifier = Modifier.padding(4.dp))



                OutlinedTextField(
                    value = password, onValueChange = onPasswordChange,
                    placeholder = {
                        Text(text = "Masukkan password anda")
                    },
                    label = {
                        Text(text = "password")
                    },
                    leadingIcon = {
                        Icon(Icons.Filled.Lock, contentDescription = null)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp)
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Magenta)

                ) { Text("Login") }

                Spacer(modifier = Modifier.padding(8.dp))


                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "belum menjadi akun? ")
                    Text(
                        text = "daftar",
                        style = TextStyle(color = Color.Blue),
                        modifier = Modifier.clickable { })
                }
                Spacer(modifier = Modifier.padding(bottom = 20.dp))


            }


        }
    }


    @Preview
    @Composable
    fun LoginScreenContentPreview() {
        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        LoginScreenContent(
            email = email,
            password = password,
            onEmailChange = { email = it },
            onPasswordChange = { password = it }
        )
    }

}
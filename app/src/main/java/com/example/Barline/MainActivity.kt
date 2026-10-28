package com.example.barline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.barline.auth.AuthViewModel
import com.example.barline.auth.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val vm: AuthViewModel = viewModel()
                LoginScreen(
                    email = vm.email,
                    password = vm.password,
                    isLoading = vm.isLoading,
                    errorMessage = vm.errorMessage,
                    onEmailChange = vm::onEmailChange,
                    onPasswordChange = vm::onPasswordChange,
                    onSignInClick = { vm.signIn { /* navigate to home */ } },
                    onCreateAccountClick = { vm.createAccount { /* navigate */ } },
                )
            }
        }
    }
}

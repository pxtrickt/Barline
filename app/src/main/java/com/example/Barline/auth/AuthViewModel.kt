package com.example.Barline.auth

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    var isLoading by mutableStateOf(false)
        private set
    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun onEmailChange(value: String) { email = value }
    fun onPasswordChange(value: String) { password = value }
    fun clearError() { errorMessage = null }

    fun signIn(onSuccess: () -> Unit) {
        if (!validate()) return
        isLoading = true
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { isLoading = false; onSuccess() }
            .addOnFailureListener { isLoading = false; errorMessage = it.message }
    }

    fun createAccount(onSuccess: () -> Unit) {
        if (!validate()) return
        isLoading = true
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { isLoading = false; onSuccess() }
            .addOnFailureListener { isLoading = false; errorMessage = it.message }
    }

    private fun validate(): Boolean {
        if (email.isBlank() || password.isBlank()) {
            errorMessage = "Please enter email and password"
            return false
        }
        return true
    }
}

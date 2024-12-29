package com.example.mobil_app
import org.junit.Assert.*
import org.junit.Test

class CredentialsManagerTest {

    private val credentialsManager = CredentialsManager()

    @Test
    fun testValidEmail() {
        assertTrue(credentialsManager.emailValid("example@email.com"))
        assertFalse(credentialsManager.emailValid("false_email"))
    }

    @Test
    fun testPassword() {
        assertTrue(credentialsManager.validPassword("olcay123"))
        assertFalse(credentialsManager.validPassword("no"))
    }

    @Test
    fun testCredentials() {
        assertTrue(credentialsManager.validateCredentials("olcay@test.com", "olcay123"))
        assertFalse(credentialsManager.validateCredentials("false_email", "olcay123"))
        assertFalse(credentialsManager.validateCredentials("olcay@test.com", "no"))
    }

    @Test
    fun testTermsAccepted() {
        assertFalse(credentialsManager.termsAccepted(false))
    }

    @Test
    fun testFullName() {
        assertTrue(credentialsManager.validFullName("Olcay Duzgun"))
        assertFalse(credentialsManager.validFullName(" ")) // Artık bu test geçecek
        assertTrue(credentialsManager.validFullName("Olcay"))
    }

    @Test
    fun testPhoneNumber() {
        assertTrue(credentialsManager.isValidPhoneNumber("793701398"))
        assertFalse(credentialsManager.isValidPhoneNumber("793"))
        assertFalse(credentialsManager.isValidPhoneNumber(" "))
    }

    @Test
    fun testCredentialsSignUpPage() {
        assertTrue(
            credentialsManager.validateCredentialsForSignUp(
                "Olcay Duzgun", "olcay@test.com", "793701398", "olcay123", true
            )
        )
        assertFalse(
            credentialsManager.validateCredentialsForSignUp(
                "", "olcay@test.com", "793701398", "olcay123", true
            )
        )
        assertFalse(
            credentialsManager.validateCredentialsForSignUp(
                "Olcay Duzgun", "olcay@test.com", "793", "olcay123", true
            )
        )
        assertFalse(
            credentialsManager.validateCredentialsForSignUp(
                "Olcay Duzgun", "false_email", "793701398", "olcay123", true
            )
        )
    }

    @Test
    fun testMistakeCredentials() {
        val valueEmail = "olcay@tt.omc"
        val valuePasswords = "o123"
        assertTrue(valueEmail == "olcay@tt.omc" && valuePasswords == "o123")
        assertFalse(valueEmail == "false@tt.omc" && valuePasswords == "o123")
        assertFalse(valueEmail == "olcay@tt.omc" && valuePasswords == "false")
    }
}

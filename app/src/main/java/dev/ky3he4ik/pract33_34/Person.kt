package dev.ky3he4ik.pract33_34

import kotlinx.serialization.Serializable

@Serializable
data class Person(val sex: Char, val name: String, val phoneNumber: String)

package model

data class Address(
    val name: String,
    val street: String,
    val houseNumber: String,
    val postalCode: String,
    val cityName: String,
    val link: String = ""
)

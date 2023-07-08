package com.example.conversionapp.data

enum class MeasurementType(val conversionConstant: Double, val conversionUnit: String) {
    KILOMETER(0.62, "Miles"),
    MILES(1.61, "Kilometers"),
    CENTIMETER(0.39, "Inches"),
    INCHES(2.54, "Centimeters"),
    KILOGRAM(2.2, "Pounds"),
    POUNDS(0.45, "Kilograms"),
    GRAM(0.04, "Ounces"),
    OUNCE(28.35, "Grams"),
    LITRE(4.17, "Cups"),
    CUPS(0.24, "Litres"),
    FEET(0.33, "Yards"),
    YARD(0.9144, "Feet"),
}
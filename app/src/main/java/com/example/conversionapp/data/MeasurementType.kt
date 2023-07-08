package com.example.conversionapp.data

enum class MeasurementType(val conversionConstant: Double, val conversionUnit: String) {
    KM(0.62, "mi"),
    MI(1.61, "km"),
    CM(0.39, "in"),
    IN(2.54, "cm"),
    KG(2.2, "lb"),
    LB(0.45, "kg"),
    G(0.04, "oz"),
    OZ(28.35, "g"),
    L(4.17, "cups"),
    CUPS(0.24, "L"),
    FT(0.33, "yards"),
    YARDS(0.9144, "ft"),
}

fun stringToMeasurementType(name: String): MeasurementType = MeasurementType.valueOf(name.uppercase())
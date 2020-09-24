package com.farazandishehafagh.bmi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var validationResult: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtName = findViewById<EditText>(R.id.txtName)
        val txtAge = findViewById<EditText>(R.id.txtAge)
        val swtGender = findViewById<Switch>(R.id.swtGender)
        val txtHeight = findViewById<EditText>(R.id.txtHeight)
        val txtWeight = findViewById<EditText>(R.id.txtWeight)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            validationResult = validateInfo(
                txtName.text.toString(),
                txtAge.text.toString(),
                txtHeight.text.toString(),
                txtWeight.text.toString()
            )
            if (validationResult) {
                val bmi = calculateBMI(
                    txtHeight.text.toString().toDouble(),
                    txtWeight.text.toString().toDouble()
                )
                showMeTheResult(
                    bmi,
                    txtName.text.toString(),
                    txtAge.text.toString(),
                    swtGender.isChecked
                )
            }
        }
    }

    private fun validateInfo(name: String, age: String, height: String, weight: String): Boolean {
        when {
            name.isEmpty() -> {
                Toast.makeText(
                    baseContext,
                    "Name is required",
                    Toast.LENGTH_LONG
                ).show()
                return false
            }
            age.isEmpty() -> {
                Toast.makeText(
                    baseContext,
                    "Age is required",
                    Toast.LENGTH_LONG
                ).show()
                return false
            }
            height.isEmpty() -> {
                Toast.makeText(
                    baseContext,
                    "Height is required",
                    Toast.LENGTH_LONG
                ).show()
                return false
            }
            height.toDouble() > 100 -> {
                Toast.makeText(
                    baseContext,
                    "Please enter the height in meters",
                    Toast.LENGTH_LONG
                ).show()
                return false
            }
            weight.isEmpty() -> {
                Toast.makeText(
                    baseContext,
                    "Weight is required",
                    Toast.LENGTH_LONG
                ).show()
                return false
            }
            else -> return true
        }
    }

    private fun calculateBMI(height: Double, weight: Double): Double {

        return weight / (height * height)
    }

    private fun showMeTheResult(bmi: Double, name: String, age: String, gender: Boolean) {

        if (bmi < 18.5) {
            if (!gender)
                Toast.makeText(
                    baseContext,
                    "dear Mr.$name,at the age of $age , You are in 'Underweight' Category",
                    Toast.LENGTH_LONG
                ).show()
            else
                Toast.makeText(
                    baseContext,
                    "dear Miss/Mrs.$name,at the age of $age , You are in 'Underweight' Category",
                    Toast.LENGTH_LONG
                ).show()
        } else if (bmi in 18.5..24.9) {
            if (!gender)
                Toast.makeText(
                    baseContext,
                    "dear Mr.$name,at the age of $age , You are in 'Normal (healthy weight)' Category",
                    Toast.LENGTH_LONG
                ).show()
            else
                Toast.makeText(
                    baseContext,
                    "dear Miss/Mrs.$name,at the age of $age , You are in 'Normal (healthy weight)' Category",
                    Toast.LENGTH_LONG
                ).show()
        } else if (bmi in 25.0..29.9) {
            if (!gender)
                Toast.makeText(
                    baseContext,
                    "dear Mr.$name,at the age of $age ,You are in 'Normal (healthy weight)' Category",
                    Toast.LENGTH_LONG
                ).show()
            else
                Toast.makeText(
                    baseContext,
                    "dear Miss/Mrs.$name,at the age of $age ,You are in 'Normal (healthy weight)' Category",
                    Toast.LENGTH_LONG
                ).show()
        } else if (bmi in 30.0..34.9)
            if (!gender)
                Toast.makeText(
                    baseContext,
                    "dear Mr.$name,at the age of $age ,You are in 'Moderately obese' Category",
                    Toast.LENGTH_LONG
                ).show()
            else
                Toast.makeText(
                    baseContext,
                    "dear Miss/Mrs.$name,at the age of $age ,You are in 'Moderately obese' Category",
                    Toast.LENGTH_LONG
                ).show()
        else if (bmi >= 35)
            if (!gender)
                Toast.makeText(
                    baseContext,
                    "dear Mr.$name,at the age of $age ,You are in 'Severely obese' Category",
                    Toast.LENGTH_LONG
                ).show()
            else
                Toast.makeText(
                    baseContext,
                    "dear Miss/Mrs.$name,at the age of $age ,You are in 'Severely obese' Category",
                    Toast.LENGTH_LONG
                ).show()
    }
}

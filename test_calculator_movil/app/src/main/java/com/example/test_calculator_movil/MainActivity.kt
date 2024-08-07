package com.example.test_calculator_movil

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView

import kotlin.math.E
import kotlin.math.PI
import kotlin.math.pow


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonClear: Button = findViewById(R.id.button_clear)
        val button_bracket_left: Button = findViewById(R.id.button_bracket_left)
        val button_bracket_right: Button = findViewById(R.id.button_bracket_right)
        val button_0: Button = findViewById(R.id.button_0)
        val button_1: Button = findViewById(R.id.button_1)
        val button_2: Button = findViewById(R.id.button_2)
        val button_3: Button = findViewById(R.id.button_3)
        val button_4: Button = findViewById(R.id.button_4)
        val button_5: Button = findViewById(R.id.button_5)
        val button_6: Button = findViewById(R.id.button_6)
        val button_7: Button = findViewById(R.id.button_7)
        val button_8: Button = findViewById(R.id.button_8)
        val button_9: Button = findViewById(R.id.button_9)
        val button_power: Button = findViewById(R.id.button_power)
        val button_pi: Button = findViewById(R.id.button_pi)
        val button_euler: Button = findViewById(R.id.button_euler)
        val button_sqrt: Button = findViewById(R.id.button_sqrt)
        val button_addition: Button = findViewById(R.id.button_addition)
        val button_subtraction: Button = findViewById(R.id.button_subtraction)
        val button_multiplication: Button = findViewById(R.id.button_multiplication)
        val button_division: Button = findViewById(R.id.button_division)
        val button_dot: Button = findViewById(R.id.button_dot)
        val button_equals: Button = findViewById(R.id.button_equals)

        val input: TextView = findViewById(R.id.input)
        val output: TextView = findViewById(R.id.output)

        buttonClear.setOnClickListener {
            input.text = ""
            output.text = ""
        }
        button_bracket_left.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "(")
        }
        button_bracket_right.setOnClickListener {
            input.text = addToInputText(input.text.toString(), ")")
        }
        button_0.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "0")
        }
        button_1.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "1")
        }
        button_2.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "2")
        }
        button_3.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "3")
        }
        button_4.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "4")
        }
        button_5.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "5")
        }
        button_6.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "6")
        }
        button_7.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "7")
        }
        button_8.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "8")
        }
        button_9.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "9")
        }
        button_addition.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "+")
        }
        button_subtraction.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "-")
        }
        button_multiplication.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "*")
        }
        button_division.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "/")
        }
        button_dot.setOnClickListener {
            input.text = addToInputText(input.text.toString(), ".")
        }
        button_power.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "^")
        }
        button_sqrt.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "√")
        }
        button_pi.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "π")
        }
        button_euler.setOnClickListener {
            input.text = addToInputText(input.text.toString(), "e")
        }
        button_equals.setOnClickListener {
            val infixExpression = input.text.toString()
            Log.d("MainActivity", "Infix Expression: $infixExpression")
            if (ExpressionValidator.isValid(infixExpression)) {
                try {
                    val postfixExpression = ExpressionConverter.convertToPostfix(infixExpression)
                    Log.d("MainActivity", "Postfix Expression: $postfixExpression")
                    val result = PostfixCalculator.calculatePostfix(postfixExpression)
                    output.text = result.toString()
                } catch (e: Exception) {
                    output.text = "Error: ${e.message}"
                    Log.e("MainActivity", "Error: ${e.message}", e)
                }
            } else {
                output.text = "Expresión Inválida"
                Log.d("MainActivity", "Invalid expression")
            }
        }
    }

    private fun addToInputText(currentText: String, buttonValue: String): String {
        return "$currentText$buttonValue"
    }

    private fun enableEdgeToEdge() {
        // Implementación de edge-to-edge (si es necesario)
    }
}

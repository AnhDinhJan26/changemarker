package iuh_ad.dinhtuananh19489471.changemarker

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // textView
        val numPrice: TextView = findViewById(R.id.num_price)
        val numOne_cent: TextView = findViewById(R.id.num_one_cent)
        val numFive_cent: TextView = findViewById(R.id.num_five_cent)
        val numTen_cent: TextView = findViewById(R.id.num_ten_cent)
        val numTwentyFive_cent: TextView = findViewById(R.id.num_twentyFive_cent)
        val numOne_dollar: TextView = findViewById(R.id.num_one_dollar)
        val numFive_dollar: TextView = findViewById(R.id.num_five_dollar)
        val numTen_dollar: TextView = findViewById(R.id.num_ten_dollar)
        val numTwenty_dollar: TextView = findViewById(R.id.num_twenty_dollar)

        // button
        val zeroBtn: Button = findViewById(R.id.zero)
        val oneBtn: Button = findViewById(R.id.one)
        val twoBtn: Button = findViewById(R.id.two)
        val threeBtn: Button = findViewById(R.id.three)
        val fourBtn: Button = findViewById(R.id.four)
        val fiveBtn: Button = findViewById(R.id.five)
        val sixBtn: Button = findViewById(R.id.six)
        val sevenBtn: Button = findViewById(R.id.seven)
        val eightBtn: Button = findViewById(R.id.eight)
        val nineBtn: Button = findViewById(R.id.nine)
        val clearBtn: Button = findViewById(R.id.clear)

        // function
        var total: Float = 0f
        fun converter(){
            var dollar = (total / 100).toInt()
            var cent: Float = total / 100 - dollar
            numTwenty_dollar.setText(dollar.toString())
            numTen_dollar.setText(cent.toString())
            // dollar
            // 20 dollar
            numTwenty_dollar.setText((dollar / 20).toInt().toString())
            dollar = dollar - (dollar / 20).toInt() * 20
            // 10 dollar
            numTen_dollar.setText((dollar / 10).toInt().toString())
            dollar = dollar - (dollar / 10).toInt() * 10
            // 5 dollar
            numFive_dollar.setText((dollar / 5).toInt().toString())
            dollar = dollar - (dollar / 5).toInt() * 5
            // 1 dollar
            numOne_dollar.setText(dollar.toInt().toString())

            // cent
            // 25 cent
            numTwentyFive_cent.setText((cent / 0.25).toInt().toString())
            cent = (cent - (cent / 0.25).toInt() * 0.25).toFloat()
            // 10 cent
            numTen_cent.setText((cent / 0.1).toInt().toString())
            cent = (cent - (cent / 0.1).toInt() * 0.1).toFloat()
            // 5 cent
            numFive_cent.setText((cent / 0.05).toInt().toString())
            cent = (cent - (cent / 0.05).toInt() * 0.05).toFloat()
            // 1 cent
            numOne_cent.setText(((cent / 0.01) + 0.001).toInt().toString())
        }

        fun change(num: Int){
            total = total * 10 + num
            numPrice.setText((total / 100).toString())
            converter()
        }

        // button action
        zeroBtn.setOnClickListener(){
            change(0)
        }
        oneBtn.setOnClickListener(){
            change(1)
        }
        twoBtn.setOnClickListener(){
            change(2)
        }
        threeBtn.setOnClickListener(){
            change(3)
        }
        fourBtn.setOnClickListener(){
            change(4)
        }
        fiveBtn.setOnClickListener(){
            change(5)
        }
        sixBtn.setOnClickListener(){
            change(6)
        }
        sevenBtn.setOnClickListener(){
            change(7)
        }
        eightBtn.setOnClickListener(){
            change(8)
        }
        nineBtn.setOnClickListener(){
            change(9)
        }
        clearBtn.setOnClickListener(){
            total = 0f
            numPrice.setText((total / 100).toString())
            converter()
        }


    }
}
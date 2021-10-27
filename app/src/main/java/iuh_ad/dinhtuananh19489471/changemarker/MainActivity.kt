package iuh_ad.dinhtuananh19489471.changemarker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // onCreate and onRestoreInstanceState for state total
        var total = 0.toDouble()
        val numPrice: TextView = findViewById(R.id.num_price)
        if (savedInstanceState != null) {
            super.onRestoreInstanceState(savedInstanceState)
            numPrice.text = savedInstanceState.getString("num_price")
        }
        total = numPrice.text.toString().toDouble() * 100

        // declare button object
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
        // declare textview object
        val numOne_cent: TextView = findViewById(R.id.num_one_cent)
        val numFive_cent: TextView = findViewById(R.id.num_five_cent)
        val numTen_cent: TextView = findViewById(R.id.num_ten_cent)
        val numTwentyFive_cent: TextView = findViewById(R.id.num_twentyFive_cent)
        val numOne_dollar: TextView = findViewById(R.id.num_one_dollar)
        val numFive_dollar: TextView = findViewById(R.id.num_five_dollar)
        val numTen_dollar: TextView = findViewById(R.id.num_ten_dollar)
        val numTwenty_dollar: TextView = findViewById(R.id.num_twenty_dollar)

        // convert func
        fun converter(total: Double){
            var dollar = (total / 100).toInt()
            var cent: Double = total / 100 - dollar
            // dollar
            // 20 dollar
            numTwenty_dollar.text = (dollar / 20).toInt().toString()
            dollar -= (dollar / 20).toInt() * 20
            // 10 dollar
            numTen_dollar.text = (dollar / 10).toInt().toString()
            dollar -= (dollar / 10).toInt() * 10
            // 5 dollar
            numFive_dollar.text = (dollar / 5).toInt().toString()
            dollar -= (dollar / 5).toInt() * 5
            // 1 dollar
            numOne_dollar.text = dollar.toInt().toString()

            // cent
            // 25 cent
            numTwentyFive_cent.text = (cent / 0.25).toInt().toString()
            cent = (cent - (cent / 0.25).toInt() * 0.25).toDouble()
            // 10 cent
            numTen_cent.text = (cent / 0.1).toInt().toString()
            cent = (cent - (cent / 0.1).toInt() * 0.1).toDouble()
            // 5 cent
            numFive_cent.text = (cent / 0.05).toInt().toString()
            cent = (cent - (cent / 0.05).toInt() * 0.05).toDouble()
            // 1 cent
            numOne_cent.text = (cent / 0.01 + 0.1).toInt().toString()
        }
        // change func for button
        fun change(num: Int){
            if (total > 9999999){
                Toast.makeText(applicationContext, "Amount is too big!", Toast.LENGTH_SHORT).show()
            } else {
                total = total * 10 + num
                numPrice.setText(String.format("%.2f", (total / 100)).toDouble().toString())
                converter(total)
            }
        }

        converter(total)        // reStore textview amount

        // button interactive
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
            total = 0.00
            numPrice.text = (total / 100).toString()
            converter(total)
            Toast.makeText(applicationContext, "Clear!", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        // sate state numPrice
        var numPrice: TextView = findViewById(R.id.num_price)
        outState.putString("num_price", numPrice.text.toString())
        super.onSaveInstanceState(outState)
    }
}
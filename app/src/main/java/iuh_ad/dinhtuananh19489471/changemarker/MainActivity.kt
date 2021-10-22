package iuh_ad.dinhtuananh19489471.changemarker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    // function
    fun converter(total: Float, numTwenty_dollar: TextView, numTen_dollar: TextView, numFive_dollar: TextView,
                  numOne_dollar: TextView, numTwentyFive_cent: TextView, numTen_cent: TextView, numFive_cent: TextView,
                  numOne_cent: TextView){
        var dollar = (total / 100).toInt()
        var cent: Float = total / 100 - dollar
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
        numOne_cent.setText((cent / 0.01 + 0.1).toInt().toString())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        // textview
        val numPrice: TextView = findViewById(R.id.num_price)
        val numOne_cent: TextView = findViewById(R.id.num_one_cent)
        val numFive_cent: TextView = findViewById(R.id.num_five_cent)
        val numTen_cent: TextView = findViewById(R.id.num_ten_cent)
        val numTwentyFive_cent: TextView = findViewById(R.id.num_twentyFive_cent)
        val numOne_dollar: TextView = findViewById(R.id.num_one_dollar)
        val numFive_dollar: TextView = findViewById(R.id.num_five_dollar)
        val numTen_dollar: TextView = findViewById(R.id.num_ten_dollar)
        val numTwenty_dollar: TextView = findViewById(R.id.num_twenty_dollar)

        var total: Float = numPrice.text.toString().toFloat() * 100
        fun change(num: Int){
            var total: Float = numPrice.text.toString().toFloat() * 100
            val toast = Toast.makeText(applicationContext, "Amount is too big!", Toast.LENGTH_SHORT)
            if (total > 999999){
                toast.show()
            }
            else{
                toast.cancel()
                total = total * 10 + num
                numPrice.setText(String.format("%.2f", (total / 100)).toFloat().toString())
                converter(total, numTwenty_dollar, numTen_dollar, numFive_dollar, numOne_dollar, numTwentyFive_cent, numTen_cent, numFive_cent, numOne_cent)
            }
        }
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
            converter(total, numTwenty_dollar, numTen_dollar, numFive_dollar, numOne_dollar, numTwentyFive_cent, numTen_cent, numFive_cent, numOne_cent)
        }
        converter(total, numTwenty_dollar, numTen_dollar, numFive_dollar, numOne_dollar, numTwentyFive_cent, numTen_cent, numFive_cent, numOne_cent)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        var numPrice: TextView = findViewById(R.id.num_price)
        outState.putString("num_price", numPrice.text.toString())
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val numOne_cent: TextView = findViewById(R.id.num_one_cent)
        val numFive_cent: TextView = findViewById(R.id.num_five_cent)
        val numTen_cent: TextView = findViewById(R.id.num_ten_cent)
        val numTwentyFive_cent: TextView = findViewById(R.id.num_twentyFive_cent)
        val numOne_dollar: TextView = findViewById(R.id.num_one_dollar)
        val numFive_dollar: TextView = findViewById(R.id.num_five_dollar)
        val numTen_dollar: TextView = findViewById(R.id.num_ten_dollar)
        val numTwenty_dollar: TextView = findViewById(R.id.num_twenty_dollar)

        var numPrice: TextView = findViewById(R.id.num_price)
        numPrice.text = savedInstanceState.getString("num_price")
        var total: Float = numPrice.text.toString().toFloat() * 100
        converter(total, numTwenty_dollar, numTen_dollar, numFive_dollar, numOne_dollar, numTwentyFive_cent, numTen_cent, numFive_cent, numOne_cent)
    }
}
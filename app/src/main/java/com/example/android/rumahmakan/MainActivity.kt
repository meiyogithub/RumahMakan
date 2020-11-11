package com.example.android.rumahmakan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var listFoodChecked: Map<CheckBox, Int>
    lateinit var listDrinkCheked: Map<CheckBox, Int>

    var totalFood: Int = 0
    var totalDrink: Int = 0
    var total: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun hitungTagihan(view: View){
        getSelectedFood()
        getSelectedDrink()
        total_makanan.text = totalFood.toString()
        total_minuman.text = totalDrink.toString()
        total_harga.text = total.toString()
    }


    private fun getSelectedFood(){
        listFoodChecked = mapOf(
            batagor_rakyat_jelata to 10000,
            batagor_premium to 15000,
            batagor_vip to 20000,
            batagor_sultan to 25000
        )

        totalFood = 0

        for ((chekedItem:CheckBox, price:Int)in listFoodChecked){
            if (chekedItem.isChecked){
                var subTotalFood: Int
                when (chekedItem){
                    batagor_rakyat_jelata -> {
                        if(et_batagor_1.text.toString() != ""){
                            subTotalFood = et_batagor_1.text.toString().toInt() * price
                            totalFood += subTotalFood
                        }
                    }

                    batagor_premium -> {
                        if(et_batagor_2.text.toString() != ""){
                            subTotalFood = et_batagor_2.text.toString().toInt() * price
                            totalFood += subTotalFood
                        }
                    }

                    batagor_vip -> {
                        if(et_batagor_3.text.toString() != ""){
                            subTotalFood = et_batagor_3.text.toString().toInt() * price
                            totalFood += subTotalFood
                        }
                    }

                    batagor_sultan -> {
                        if(et_batagor_4.text.toString() != ""){
                            subTotalFood = et_batagor_4.text.toString().toInt() * price
                            totalFood += subTotalFood
                        }
                    }
                }
            }
        }
        total += totalFood
    }

    private fun getSelectedDrink(){
        listDrinkCheked = mapOf(
            es_teh to 3000,
            air_mineral to 3000,
            air_jeruk to 5000,
            es_buah to 10000
        )

        totalDrink = 0

        for ((checkerItem:CheckBox, price:Int)in listDrinkCheked){
            if(checkerItem.isChecked){
                var subTotalDrink: Int
                when(checkerItem){
                    es_teh -> {
                        if (et_minuman_1.text.toString() != ""){
                            subTotalDrink = et_minuman_1.text.toString().toInt() * price
                            totalDrink += subTotalDrink
                        }
                    }

                    air_mineral -> {
                        if (et_minuman_2.text.toString() != ""){
                            subTotalDrink = et_minuman_2.text.toString().toInt() * price
                            totalDrink += subTotalDrink
                        }
                    }

                    air_jeruk -> {
                        if (et_minuman_3.text.toString() != ""){
                            subTotalDrink = et_minuman_3.text.toString().toInt() * price
                            totalDrink += subTotalDrink
                        }
                    }

                    es_buah -> {
                        if (et_minuman_4.text.toString() != ""){
                            subTotalDrink = et_minuman_4.text.toString().toInt() * price
                            totalDrink += subTotalDrink
                        }
                    }
                }
            }
        }

        total += totalDrink
    }

    fun payNow(view: View){
        if (bayar_aja.text.toString() != "") {
            var total_pay: Int = bayar_aja.text.toString().toInt()
            if (total_pay > total) {
                total_pay -= total
                Toast.makeText(this, "Uang Kembalian Anda Sebesar $total_pay", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Maaf, Uang Pembayaran Anda Kurang", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Anda Belum Memasukan Nominal", Toast.LENGTH_SHORT).show()
        }
    }
}


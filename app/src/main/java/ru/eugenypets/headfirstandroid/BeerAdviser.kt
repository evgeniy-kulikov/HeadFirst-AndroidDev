package ru.eugenypets.headfirstandroid

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BeerAdviser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chapter_02)


        val findBeer = findViewById<Button>(R.id.btn_find_beer)


        findBeer.setOnClickListener {
            val brands = findViewById<TextView>(R.id.tv_brands)  // нашли текстовое поле
            val beerColor =
                findViewById<Spinner>(R.id.spn_beer_color)  // нашли раскрывающийся список
            val color =
                beerColor.selectedItem.toString()  // текущее значения раскрывающегося списка
//        val color = "${beerColor.selectedItem}"  // вариант записи

//            brands.text = "Bear color is $color"  // пример передачи данных в текстовый атрибут

            // Усложняем пример. Работаем со списком
            val beerList = getBeers(color)
//            val beers = beerList.reduce { st, el -> st + '\n' + el }  // вариант записи
//            val beers = beerList.reduce { st, el -> "$st\n$el" }  // вариант записи
            val beers = beerList.joinToString("\n")
            brands.text = beers.uppercase()
        }
    }

    fun getBeers(color: String): List<String> {
        return when (color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite", "Bock Brownie")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }

}
package ru.eugenypets.headfirstandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer

class Stopwatch : AppCompatActivity() {

    // lateinit var  Отложенная инициализация переменной
    lateinit var stopwatch: Chronometer
    var running = false  // статус работы секундомера
    var offset: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)

        /*
        Получить ссылку на свойство stopwatch можно только после вызова setContentView.
        До этого представление Chronometer не существует.
        */
        stopwatch = findViewById<Chronometer>(R.id.stopwatch)

        // Кнопка start запускает секундомер, если он не работал
        var startButton = findViewById<Button>(R.id.btn_start)
        startButton.setOnClickListener {
            if (!running) {
                setBaseTime()
                stopwatch.start()
                running = true
            }
        }

        //Кнопка pause останавливает секундомер, если он работал
        val pauseButton = findViewById<Button>(R.id.btn_pause)

        pauseButton.setOnClickListener {
            if (running) {
                saveOffset()
                stopwatch.stop()
                running = false
            }
        }
        //Кнопка reset обнуляет offset и базовое время
        val resetButton = findViewById<Button>(R.id.btn_reset)

        resetButton.setOnClickListener {
            offset = 0
            setBaseTime()
        }

    /*
    Метод start() запускает отсчет от базового времени
    Метод stop() Приостанавливает отсчет времени хронометром
    stopwatch.base = SystemClock.elapsedRealtime()  // Обнуляет показания времени
    SystemClock.elapsedRealtime() возвращает время в миллисекундах,
    прошедшее с момента загрузки устройства.
    Если присвоить свойству base это значение, выводимое время обнуляется.
    */

    }


    // Обновляет время stopwatch.base
    private fun setBaseTime() {
        stopwatch.base = SystemClock.elapsedRealtime() - offset
    }

    // Сохраняет offset
    fun saveOffset() {
        offset = SystemClock.elapsedRealtime() - stopwatch.base
    }



}
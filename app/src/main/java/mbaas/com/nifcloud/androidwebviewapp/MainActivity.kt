package mbaas.com.nifcloud.androidwebviewapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var _btn_info: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ボタンの処理を登録する
        _btn_info = findViewById<View>(R.id.btnInfo) as Button

        //Informationボタンの処理を実装
        _btn_info.setOnClickListener {
            // WebviewActivityに遷移
            val intent = Intent(applicationContext, WebviewActivity::class.java)
            startActivityForResult(intent, REQUEST_RESULT)
        }


    }

    companion object {

        private val TAG = "ShopActivity"
        private val REQUEST_RESULT = 0
    }
}

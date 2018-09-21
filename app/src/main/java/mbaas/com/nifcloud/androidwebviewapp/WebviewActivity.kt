package mbaas.com.nifcloud.androidwebviewapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.WebView
import android.widget.Button

class WebviewActivity : AppCompatActivity() {
    lateinit var _btn_back: Button
    lateinit var _webview: WebView

    //index.htmlの公開URL
    internal var url = "YOUR_HTML_PUBLIC_URL"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        //WebviewのURLを設定
        _webview = findViewById<View>(R.id.webviewInfo) as WebView
        _webview.loadUrl(url)

        //ボタンの処理を登録する
        _btn_back = findViewById<View>(R.id.btnBack) as Button

        //Btn Back 画面遷移の処理を実装
        _btn_back.setOnClickListener {
            // MainActivityに戻る処理
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivityForResult(intent, REQUEST_RESULT)
        }
    }

    companion object {

        private val TAG = "ShopActivity"
        private val REQUEST_RESULT = 0
    }
}
